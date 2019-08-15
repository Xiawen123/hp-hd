package com.hp.web.controller.activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hp.activity.domain.HdCover;
import com.hp.activity.domain.HdGroup;
import com.hp.activity.domain.HdPlayer;
import com.hp.activity.service.IHdCoverService;
import com.hp.activity.service.IHdGroupService;
import com.hp.activity.service.IHdPlayerService;
import com.hp.common.utils.FastJsonUtils;
import com.hp.framework.util.ShiroUtils;
import com.hp.quartz.domain.SysJob;
import com.hp.quartz.service.ISysJobService;
import com.hp.web.controller.system.cloud.CloudStorageService;
import com.hp.web.controller.system.cloud.OSSFactory;
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
import com.hp.activity.domain.HdActivity;
import com.hp.activity.service.IHdActivityService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 活动 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdActivity")
public class HdActivityController extends BaseController
{
    private String prefix = "activity/hdActivity";
	
	@Autowired
	private IHdActivityService hdActivityService;

	@Autowired
	private IHdPlayerService hdPlayerService;

	@Autowired
	private IHdCoverService hdCoverService;

	@Autowired
	private IHdGroupService hdGroupService;

	@Autowired
	private ISysJobService jobService;
	
	@RequiresPermissions("activity:hdActivity:view")
	@GetMapping()
	public String hdActivity()
	{
	    return prefix + "/hdActivity";
	}
	
	/**
	 * 查询活动列表
	 */
	@RequiresPermissions("activity:hdActivity:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdActivity hdActivity)
	{
		startPage();
        List<HdActivity> list = hdActivityService.selectHdActivityList(hdActivity);
        for (HdActivity ha : list){
			int a = hdPlayerService.selectCountByActivityId(ha.getId());
			ha.setPlayers(a);
		}
		return getDataTable(list);
	}
	
	
	/**
	 * 导出活动列表
	 */
	@RequiresPermissions("activity:hdActivity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdActivity hdActivity)
    {
    	List<HdActivity> list = hdActivityService.selectHdActivityList(hdActivity);
        ExcelUtil<HdActivity> util = new ExcelUtil<HdActivity>(HdActivity.class);
        return util.exportExcel(list, "hdActivity");
    }
	
	/**
	 * 新增活动
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存活动
	 */
	@RequiresPermissions("activity:hdActivity:add")
	@Log(title = "活动", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdActivity hdActivity) throws ParseException {
		//确定活动id    如表中无数据则id为1如有数据则id为当前最大id+1
		HdActivity ha = new HdActivity();
		int aa = hdActivityService.selectCount(ha);
		int b = 1;
		if(aa>0){
			int c = hdActivityService.selectMaxId();
			b = c+1;
		}
		hdActivity.setId(b);
		//获取活动开始结束时间
		String[] array = hdActivity.getStart().toString().split(" ~ ");
		for (int i = 0; i < array.length; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date end = sdf.parse(array[1]);
			if ((end).before(new Date())){
				hdActivity.setExtend1(-1);
			}
			hdActivity.setStart(array[0]);
			hdActivity.setEnd(array[1]);
		}
		//获取活动封面图集合，遍历上传至文件服务器并存将链接入封面表
		List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(hdActivity.getPics().toString());
		for (Map<String,Object> map:list){
			String a = map.get("img").toString();
			String suffix = a.substring(a.indexOf("/")+1,a.indexOf(";"));
			CloudStorageService storage = OSSFactory.build();
			String str = a.substring(a.indexOf(",")+1,a.length());
			byte[] bytes = Base64.getDecoder().decode(str);
			String url = storage.uploadSuffix(bytes,"."+suffix);
			HdCover hdCover = new HdCover();
			hdCover.setActivityId(b);
			hdCover.setUrl(url);
			hdCoverService.insertHdCover(hdCover);
		}
		//如果开启分组则在分组表存入分组数据
		if (hdActivity.getGrouping() == 1){
			List<Map<String,Object>> list2 = FastJsonUtils.getJsonToListMap(hdActivity.getGroups().toString());
			for (Map<String,Object> map:list2) {
				HdGroup hdGroup = new HdGroup();
				hdGroup.setId(UUID.randomUUID().toString().replaceAll("-",""));
				hdGroup.setActivityId(b);
				hdGroup.setName(map.get("groupName").toString());
				hdGroup.setSort(Integer.parseInt(map.get("sort").toString()));
				hdGroupService.insertHdGroup(hdGroup);
			}
		}
		hdActivity.setCreateTime(new Date());

		int abc = hdActivityService.insertHdActivity(hdActivity);
		//如果活动添加成功则把活动加入定时任务
		if (abc>0){
			//获取活动结束时间并转化为时间格式
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(hdActivity.getEnd());
			//将结束时间转化为cron表达式
			SysJob job = new SysJob();
			SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? *");
			String formatTimeStr = sdf.format(date);
			job.setCronExpression(formatTimeStr);
			job.setStatus("0");
			job.setCreateBy(ShiroUtils.getLoginName());
			job.setJobName("hpTask");
			job.setJobGroup("活动结束");
			job.setMethodName("activityOverdue");
			job.setMethodParams(String.valueOf(b));
			job.setCreateTime(new Date());
			jobService.insertJobCron(job);
		}
		return toAjax(abc);
	}

	/**
	 * 修改活动
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdActivity hdActivity = hdActivityService.selectHdActivityById(id);
		hdActivity.setStart(hdActivity.getStart()+" ~ "+hdActivity.getEnd());
		mmap.put("hdActivity", hdActivity);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存活动
	 */
	@RequiresPermissions("activity:hdActivity:edit")
	@Log(title = "活动", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdActivity hdActivity) throws ParseException {
		//获取活动开始结束时间
		String[] array = hdActivity.getStart().toString().split(" ~ ");
		for (int i = 0; i < array.length; i++) {
			hdActivity.setStart(array[0]);
			hdActivity.setEnd(array[1]);
		}
		//如果开启分组则在分组表存入分组数据
		if (hdActivity.getGrouping() == 1){
			List<Map<String,Object>> list2 = FastJsonUtils.getJsonToListMap(hdActivity.getGroups().toString());
			for (Map<String,Object> map:list2) {
				HdGroup hdGroup = new HdGroup();
				if (map.get("id").toString().equals("1")){
					hdGroup.setId(UUID.randomUUID().toString().replaceAll("-",""));
					hdGroup.setActivityId(hdActivity.getId());
					hdGroup.setName(map.get("groupName").toString());
					hdGroup.setSort(Integer.parseInt(map.get("sort").toString()));
					hdGroupService.insertHdGroup(hdGroup);
				}else {
					hdGroup.setId(map.get("id").toString());
					hdGroup.setName(map.get("groupName").toString());
					hdGroup.setSort(Integer.parseInt(map.get("sort").toString()));
					hdGroupService.updateHdGroup(hdGroup);
				}

			}
		}
		//获取活动封面图集合，遍历后存入封面表
		List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(hdActivity.getPics().toString());
		for (Map<String,Object> map:list){
			String b = map.get("img").toString();
			if (b.substring(0,1).equals("d")){
				String a = map.get("img").toString();
				String suffix = a.substring(a.indexOf("/") + 1, a.indexOf(";"));
				CloudStorageService storage = OSSFactory.build();
				String str = a.substring(a.indexOf(",") + 1, a.length());
				byte[] bytes = Base64.getDecoder().decode(str);
				String url = storage.uploadSuffix(bytes, "." + suffix);
				HdCover hdCover = new HdCover();
				hdCover.setActivityId(hdActivity.getId());
				hdCover.setUrl(url);
				hdCoverService.insertHdCover(hdCover);
			}
		}

		if (hdActivity.getExtend1() == -1){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date end = sdf.parse(hdActivity.getEnd());
			if ((new Date()).before(end)){
				hdActivity.setExtend1(1);
			}
		}

		if (hdActivity.getExtend1() == 1){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date end = sdf.parse(hdActivity.getEnd());
			if ((end).before(new Date())){
				hdActivity.setExtend1(-1);
			}
		}

		int abc = hdActivityService.updateHdActivity(hdActivity);
		//如果活动添加成功则把活动加入定时任务
		if (abc>0){
			//获取活动结束时间并转化为时间格式
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(hdActivity.getEnd());
			//将结束时间转化为cron表达式
			SysJob job = new SysJob();
			SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? *");
			String formatTimeStr = sdf.format(date);
			job.setMethodParams(hdActivity.getId().toString());
			job = jobService.selectJobList(job).get(0);
			job.setCronExpression(formatTimeStr);
			job.setUpdateTime(new Date());
			jobService.updateJobCron(job);
		}
		return toAjax(abc);
	}
	
	/**
	 * 删除活动
	 */
	@RequiresPermissions("activity:hdActivity:remove")
	@Log(title = "活动", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdActivityService.deleteHdActivityByIds(ids));
	}

	/**
	 * 活动关闭
	 */
	@RequiresPermissions("activity:hdActivity:close")
	@Log(title = "活动", businessType = BusinessType.UPDATE)
	@PostMapping( "/close")
	@ResponseBody
	public AjaxResult close(HdActivity hdActivity)
	{
		hdActivity.setExtend1(0);
		return toAjax(hdActivityService.updateHdActivity(hdActivity));
	}

	/**
	 * 活动开启
	 */
	@RequiresPermissions("activity:hdActivity:unfold")
	@Log(title = "活动", businessType = BusinessType.UPDATE)
	@PostMapping( "/unfold")
	@ResponseBody
	public AjaxResult unfold(HdActivity hdActivity)
	{
		hdActivity.setExtend1(1);
		return toAjax(hdActivityService.updateHdActivity(hdActivity));
	}

	/**
	 * 选手管理
	 */
	@GetMapping("/player/{id}")
	public String player(@PathVariable("id") Integer id, ModelMap mmap)
	{
		mmap.put("hdPlayer",id);
		return "activity/hdPlayer/hdPlayer";
	}

	/**
	 * 票数排行榜
	 */
	@GetMapping("/poll/{id}")
	public String poll(@PathVariable("id") Integer id, ModelMap mmap)
	{
		mmap.put("hdPlayer",id);
		return "activity/hdRanking/ranking";
	}

	/**
	 * 资金流水
	 */
	@GetMapping("/gift/{id}")
	public String gift(@PathVariable("id") Integer id, ModelMap mmap)
	{
		mmap.put("hdPlayer",id);
		return "activity/hdPlayerGiftLog/hdPlayerGiftLog";
	}
}
