package com.hp.web.controller.activity;

import java.util.*;

import com.hp.activity.domain.*;
import com.hp.activity.service.IHdActivityService;
import com.hp.activity.service.IHdGroupService;
import com.hp.activity.service.IHdPlayerImgService;
import com.hp.common.base.Rs;
import com.hp.common.utils.FastJsonUtils;
import com.hp.web.controller.system.cloud.CloudStorageService;
import com.hp.web.controller.system.cloud.OSSFactory;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hp.common.annotation.Log;
import com.hp.common.enums.BusinessType;
import com.hp.activity.service.IHdPlayerService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 选手 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdPlayer")
public class HdPlayerController extends BaseController
{
    private String prefix = "activity/hdPlayer";
	
	@Autowired
	private IHdPlayerService hdPlayerService;

	@Autowired
	private IHdPlayerImgService hdPlayerImgService;

	@Autowired
	private IHdActivityService hdActivityService;

	@Autowired
	private IHdGroupService hdGroupService;
	
	@RequiresPermissions("activity:hdPlayer:view")
	@GetMapping()
	public String hdPlayer()
	{
	    return prefix + "/hdPlayer";
	}
	
	/**
	 * 查询选手列表
	 */
	@RequiresPermissions("activity:hdPlayer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdPlayer hdPlayer)
	{
		startPage();
        List<HdPlayer> list = hdPlayerService.selectHdPlayerList(hdPlayer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出选手列表
	 */
	@RequiresPermissions("activity:hdPlayer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdPlayer hdPlayer)
    {
    	List<HdPlayer> list = hdPlayerService.selectHdPlayerList(hdPlayer);
        ExcelUtil<HdPlayer> util = new ExcelUtil<HdPlayer>(HdPlayer.class);
        return util.exportExcel(list, "hdPlayer");
    }
	
	/**
	 * 新增选手
	 */
	@GetMapping("/add/{activityId}")
	public String add(@PathVariable("activityId") String activityId, ModelMap mmap)
	{
		HdActivity hdActivity = hdActivityService.selectHdActivityById(Integer.valueOf(activityId));
		HdGroup hdGroup = new HdGroup();
		hdGroup.setActivityId(Integer.valueOf(activityId));
		List<HdGroup> list = hdGroupService.selectHdGroupList(hdGroup);
		mmap.put("switch",hdActivity.getGrouping());
		mmap.put("activityId",activityId);
		mmap.put("HdGroup",list);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存选手
	 */
	@RequiresPermissions("activity:hdPlayer:add")
	@Log(title = "选手", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdPlayer hdPlayer)
	{
		HdPlayer hpp = new HdPlayer();
		hpp.setActivityId(hdPlayer.getActivityId());
		hpp.setName(hdPlayer.getName());
		hpp.setTel(hdPlayer.getTel());
		hpp.setExtend3(1);
		int row = hdPlayerService.selectCount(hpp);
		if (row == 1){
			return error("该选手已报名，请勿重复添加！");
		}else {
			//确定选手id    如表中无数据则id为1如有数据则id为当前最大id+1
			HdPlayer hp = new HdPlayer();
			int aa = hdPlayerService.selectCount(hp);
			int b = 1;
			if (aa > 0) {
				int c = hdPlayerService.selectMaxId();
				b = c + 1;
			}
			hdPlayer.setId(b);
			//确定选手编号   如该活动中还没有选手则当前编号为1如已有选手则当前选手编号为当前最大编号+1
			hp.setActivityId(hdPlayer.getActivityId());
			int f = hdPlayerService.selectCount(hp);
			int g = 1;
			if (f > 0) {
				int h = hdPlayerService.selectMaxExtend2(hp);
				g = h + 1;
			}
			hdPlayer.setExtend2(g);
			//获取活动封面图集合，遍历后存入封面表
			List<Map<String, Object>> list = FastJsonUtils.getJsonToListMap(hdPlayer.getPics().toString());
			list.get(0).get("img");
			for (int i = 0; i < list.size(); i++) {
				String a = list.get(i).get("img").toString();
				String suffix = a.substring(a.indexOf("/") + 1, a.indexOf(";"));
				CloudStorageService storage = OSSFactory.build();
				String str = a.substring(a.indexOf(",") + 1, a.length());
				byte[] bytes = Base64.getDecoder().decode(str);
				String url = storage.uploadSuffix(bytes, "." + suffix);
				HdPlayerImg hdPlayerImg = new HdPlayerImg();
				hdPlayerImg.setPlayerId(b);
				hdPlayerImg.setUrl(url);
				hdPlayerImgService.insertHdPlayerImg(hdPlayerImg);
				if (i == 0) {
					hdPlayer.setCoverImg(url);
				}
			}
		/*for (Map<String,Object> map:list){
			String a = map.get("img").toString();
		}*/
			hdPlayer.setCreateTime(new Date());
			int rows = hdPlayerService.insertHdPlayer(hdPlayer);
			if (rows > 0) {
				HdActivity hdActivity = hdActivityService.selectHdActivityById(hdPlayer.getActivityId());
				int c = hdActivity.getEnroll();
				hdActivity.setEnroll(c + 1);
				hdActivityService.updateHdActivity(hdActivity);
			}
			return toAjax(rows);
		}
	}

	/**
	 * 修改选手
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdPlayer hdPlayer = hdPlayerService.selectHdPlayerById(id);
		mmap.put("hdPlayer", hdPlayer);
		HdActivity hdActivity = hdActivityService.selectHdActivityById(Integer.valueOf(hdPlayer.getActivityId()));
		mmap.put("switch",hdActivity.getGrouping());
		HdGroup hdGroup = new HdGroup();
		hdGroup.setActivityId(Integer.valueOf(Integer.valueOf(hdPlayer.getActivityId())));
		List<HdGroup> list = hdGroupService.selectHdGroupList(hdGroup);
		mmap.put("HdGroup",list);
		/*HdPlayerImg hdPlayerImg = new HdPlayerImg();
		hdPlayerImg.setPlayerId(id);
		List<HdPlayerImg> list = hdPlayerImgService.selectHdPlayerImgList(hdPlayerImg);
		mmap.put("hdPlayerImg", list);*/
	    return prefix + "/edit";
	}

	@PostMapping("/playerImg")
	@ResponseBody
	public TableDataInfo playerImg(HdPlayer hdPlayer)
	{
		HdPlayerImg hdPlayerImg = new HdPlayerImg();
		hdPlayerImg.setPlayerId(hdPlayer.getId());
		List<HdPlayerImg> list = hdPlayerImgService.selectHdPlayerImgList(hdPlayerImg);
		return getDataTable(list);
	}
	
	/**
	 * 修改保存选手
	 */
	@RequiresPermissions("activity:hdPlayer:edit")
	@Log(title = "选手", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdPlayer hdPlayer)
	{
		//获取活动封面图集合，遍历后存入封面表
		List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(hdPlayer.getPics().toString());
		//list.get(0).get("img");
		for (int i=0;i<list.size();i++){
			String a = list.get(i).get("img").toString();
			if (a.substring(0,1).equals("h")){
				if(i == 0){
					if (a.equals(hdPlayer.getCoverImg()) == false){
						hdPlayer.setCoverImg(a);
					}
				}
			}else {
				String suffix = a.substring(a.indexOf("/")+1,a.indexOf(";"));
				CloudStorageService storage = OSSFactory.build();
				String str = a.substring(a.indexOf(",")+1,a.length());
				byte[] bytes = Base64.getDecoder().decode(str);
				String url = storage.uploadSuffix(bytes,"."+suffix);
				HdPlayerImg hdPlayerImg = new HdPlayerImg();
				hdPlayerImg.setPlayerId(hdPlayer.getId());
				hdPlayerImg.setUrl(url);
				hdPlayerImgService.insertHdPlayerImg(hdPlayerImg);
				if(i == 0){
					hdPlayer.setCoverImg(url);
				}
			}
		}
		return toAjax(hdPlayerService.updateHdPlayer(hdPlayer));
	}
	
	/**
	 * 删除选手
	 */
	@RequiresPermissions("activity:hdPlayer:remove")
	@Log(title = "选手", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdPlayerService.deleteHdPlayerByIds(ids));
	}

	/**
	 * 选手排行版
	 * @param hdPlayer
	 * @return
	 */
	@PostMapping("/playerRank")
	@ResponseBody
	public Rs playerRank(HdPlayer hdPlayer)
	{
		Map map = new HashMap();
		List<HdPlayer> playerList = hdPlayerService.playerRankAll(hdPlayer);
		map.put("playerList",playerList);
		Integer activityId = hdPlayer.getActivityId();
		HdActivity hdActivity = hdActivityService.selectHdActivityById(activityId);
		map.put("hdActivity",hdActivity);
		return Rs.success(map);
	}

	/**
	 * 选手详情
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdPlayer hdPlayer = hdPlayerService.selectHdPlayerById(id);
		mmap.put("hdPlayer", hdPlayer);
		HdActivity hdActivity = hdActivityService.selectHdActivityById(Integer.valueOf(hdPlayer.getActivityId()));
		mmap.put("switch",hdActivity.getGrouping());
		HdGroup hdGroup = new HdGroup();
		hdGroup.setActivityId(Integer.valueOf(Integer.valueOf(hdPlayer.getActivityId())));
		List<HdGroup> list = hdGroupService.selectHdGroupList(hdGroup);
		mmap.put("HdGroup",list);
		/*HdPlayer hdPlayer = hdPlayerService.selectHdPlayerById(id);
		mmap.put("hdPlayer", hdPlayer);*/
		return prefix + "/detail";
	}

	/**
	 * 审核选手
	 */
	@Log(title = "选手", businessType = BusinessType.UPDATE)
	@PostMapping( "/audit")
	@ResponseBody
	public AjaxResult audit(HdPlayer hdPlayer)
	{
		hdPlayer.setExtend1(1);
		return toAjax(hdPlayerService.updateHdPlayer(hdPlayer));
	}
}
