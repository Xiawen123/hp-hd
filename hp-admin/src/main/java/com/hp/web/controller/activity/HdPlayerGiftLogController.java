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
import com.hp.activity.domain.HdPlayerGiftLog;
import com.hp.activity.service.IHdPlayerGiftLogService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 礼物记录 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdPlayerGiftLog")
public class HdPlayerGiftLogController extends BaseController
{
    private String prefix = "activity/hdPlayerGiftLog";
	
	@Autowired
	private IHdPlayerGiftLogService hdPlayerGiftLogService;
	
	@RequiresPermissions("activity:hdPlayerGiftLog:view")
	@GetMapping()
	public String hdPlayerGiftLog()
	{
	    return prefix + "/hdPlayerGiftLog";
	}
	
	/**
	 * 查询礼物记录列表
	 */
	@RequiresPermissions("activity:hdPlayerGiftLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdPlayerGiftLog hdPlayerGiftLog)
	{
		startPage();
        List<HdPlayerGiftLog> list = hdPlayerGiftLogService.selectHdPlayerGiftLogList(hdPlayerGiftLog);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出礼物记录列表
	 */
	@RequiresPermissions("activity:hdPlayerGiftLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdPlayerGiftLog hdPlayerGiftLog)
    {
    	List<HdPlayerGiftLog> list = hdPlayerGiftLogService.selectHdPlayerGiftLogList(hdPlayerGiftLog);
        ExcelUtil<HdPlayerGiftLog> util = new ExcelUtil<HdPlayerGiftLog>(HdPlayerGiftLog.class);
        return util.exportExcel(list, "hdPlayerGiftLog");
    }
	
	/**
	 * 新增礼物记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存礼物记录
	 */
	@RequiresPermissions("activity:hdPlayerGiftLog:add")
	@Log(title = "礼物记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdPlayerGiftLog hdPlayerGiftLog)
	{		
		return toAjax(hdPlayerGiftLogService.insertHdPlayerGiftLog(hdPlayerGiftLog));
	}

	/**
	 * 修改礼物记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdPlayerGiftLog hdPlayerGiftLog = hdPlayerGiftLogService.selectHdPlayerGiftLogById(id);
		mmap.put("hdPlayerGiftLog", hdPlayerGiftLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存礼物记录
	 */
	@RequiresPermissions("activity:hdPlayerGiftLog:edit")
	@Log(title = "礼物记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdPlayerGiftLog hdPlayerGiftLog)
	{		
		return toAjax(hdPlayerGiftLogService.updateHdPlayerGiftLog(hdPlayerGiftLog));
	}
	
	/**
	 * 删除礼物记录
	 */
	@RequiresPermissions("activity:hdPlayerGiftLog:remove")
	@Log(title = "礼物记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdPlayerGiftLogService.deleteHdPlayerGiftLogByIds(ids));
	}
	
}
