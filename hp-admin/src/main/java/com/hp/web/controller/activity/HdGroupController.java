package com.hp.web.controller.activity;

import java.util.List;

import com.hp.activity.domain.HdPlayer;
import com.hp.activity.service.IHdPlayerService;
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
import com.hp.activity.domain.HdGroup;
import com.hp.activity.service.IHdGroupService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 选手分组 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdGroup")
public class HdGroupController extends BaseController
{
    private String prefix = "activity/hdGroup";
	
	@Autowired
	private IHdGroupService hdGroupService;

	@Autowired
	private IHdPlayerService hdPlayerService;
	
	@RequiresPermissions("activity:hdGroup:view")
	@GetMapping()
	public String hdGroup()
	{
	    return prefix + "/hdGroup";
	}
	
	/**
	 * 查询选手分组列表
	 */
	@RequiresPermissions("activity:hdGroup:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdGroup hdGroup)
	{
		startPage();
        List<HdGroup> list = hdGroupService.selectHdGroupList(hdGroup);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出选手分组列表
	 */
	@RequiresPermissions("activity:hdGroup:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdGroup hdGroup)
    {
    	List<HdGroup> list = hdGroupService.selectHdGroupList(hdGroup);
        ExcelUtil<HdGroup> util = new ExcelUtil<HdGroup>(HdGroup.class);
        return util.exportExcel(list, "hdGroup");
    }
	
	/**
	 * 新增选手分组
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存选手分组
	 */
	@RequiresPermissions("activity:hdGroup:add")
	@Log(title = "选手分组", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdGroup hdGroup)
	{		
		return toAjax(hdGroupService.insertHdGroup(hdGroup));
	}

	/**
	 * 修改选手分组
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdGroup hdGroup = hdGroupService.selectHdGroupById(id);
		mmap.put("hdGroup", hdGroup);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存选手分组
	 */
	@RequiresPermissions("activity:hdGroup:edit")
	@Log(title = "选手分组", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdGroup hdGroup)
	{		
		return toAjax(hdGroupService.updateHdGroup(hdGroup));
	}
	
	/**
	 * 删除选手分组
	 */
	@RequiresPermissions("activity:hdGroup:remove")
	@Log(title = "选手分组", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(HdGroup hdGroup)
	{
		HdPlayer hdPlayer =new HdPlayer();
		hdPlayer.setGroupId(hdGroup.getId());
		List<HdPlayer> list = hdPlayerService.selectHdPlayerList(hdPlayer);
		if (list.size() > 0){
			return error("当前分组下有选手，不可删除！");
		}else {
			int a = hdGroupService.deleteHdGroupByIds(hdGroup);
			return toAjax(a);
		}
	}
	
}
