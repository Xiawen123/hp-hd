package com.hp.web.controller.activity;

import java.util.List;
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
import com.hp.activity.domain.HdInfo;
import com.hp.activity.service.IHdInfoService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 学员调查问卷内容 信息操作处理
 * 
 * @author hp
 * @date 2019-07-16
 */
@Controller
@RequestMapping("/activity/hdInfo")
public class HdInfoController extends BaseController
{
    private String prefix = "activity/hdInfo";
	
	@Autowired
	private IHdInfoService hdInfoService;
	
	@RequiresPermissions("activity:hdInfo:view")
	@GetMapping()
	public String hdInfo()
	{
	    return prefix + "/hdInfo";
	}
	
	/**
	 * 查询学员调查问卷内容列表
	 */
	@RequiresPermissions("activity:hdInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdInfo hdInfo)
	{
		startPage();
        List<HdInfo> list = hdInfoService.selectHdInfoList(hdInfo);
		for (HdInfo hi:list) {
			if (hi.getExtend3() != null && hi.getCause() != null){
				hi.setCause(hi.getCause()+",其他原因："+hi.getExtend3());
			}
			if (hi.getExtend3() != null && hi.getCause() == null){
				hi.setCause("其他原因："+hi.getExtend3());
			}
		}
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学员调查问卷内容列表
	 */
	@RequiresPermissions("activity:hdInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdInfo hdInfo)
    {
    	List<HdInfo> list = hdInfoService.selectHdInfoList(hdInfo);
        ExcelUtil<HdInfo> util = new ExcelUtil<HdInfo>(HdInfo.class);
        return util.exportExcel(list, "hdInfo");
    }
	
	/**
	 * 新增学员调查问卷内容
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学员调查问卷内容
	 */
	@RequiresPermissions("activity:hdInfo:add")
	@Log(title = "学员调查问卷内容", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdInfo hdInfo)
	{		
		return toAjax(hdInfoService.insertHdInfo(hdInfo));
	}

	/**
	 * 修改学员调查问卷内容
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HdInfo hdInfo = hdInfoService.selectHdInfoById(id);
		mmap.put("hdInfo", hdInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学员调查问卷内容
	 */
	@RequiresPermissions("activity:hdInfo:edit")
	@Log(title = "学员调查问卷内容", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdInfo hdInfo)
	{		
		return toAjax(hdInfoService.updateHdInfo(hdInfo));
	}
	
	/**
	 * 删除学员调查问卷内容
	 */
	@RequiresPermissions("activity:hdInfo:remove")
	@Log(title = "学员调查问卷内容", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdInfoService.deleteHdInfoByIds(ids));
	}
	
}
