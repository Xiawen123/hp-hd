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
import com.hp.activity.domain.HdPlayerTicketLog;
import com.hp.activity.service.IHdPlayerTicketLogService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 投票记录 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdPlayerTicketLog")
public class HdPlayerTicketLogController extends BaseController
{
    private String prefix = "activity/hdPlayerTicketLog";
	
	@Autowired
	private IHdPlayerTicketLogService hdPlayerTicketLogService;
	
	@RequiresPermissions("activity:hdPlayerTicketLog:view")
	@GetMapping()
	public String hdPlayerTicketLog()
	{
	    return prefix + "/hdPlayerTicketLog";
	}
	
	/**
	 * 查询投票记录列表
	 */
	@RequiresPermissions("activity:hdPlayerTicketLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdPlayerTicketLog hdPlayerTicketLog)
	{
		startPage();
        List<HdPlayerTicketLog> list = hdPlayerTicketLogService.selectHdPlayerTicketLogList(hdPlayerTicketLog);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出投票记录列表
	 */
	@RequiresPermissions("activity:hdPlayerTicketLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdPlayerTicketLog hdPlayerTicketLog)
    {
    	List<HdPlayerTicketLog> list = hdPlayerTicketLogService.selectHdPlayerTicketLogList(hdPlayerTicketLog);
        ExcelUtil<HdPlayerTicketLog> util = new ExcelUtil<HdPlayerTicketLog>(HdPlayerTicketLog.class);
        return util.exportExcel(list, "hdPlayerTicketLog");
    }
	
	/**
	 * 新增投票记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存投票记录
	 */
	@RequiresPermissions("activity:hdPlayerTicketLog:add")
	@Log(title = "投票记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdPlayerTicketLog hdPlayerTicketLog)
	{		
		return toAjax(hdPlayerTicketLogService.insertHdPlayerTicketLog(hdPlayerTicketLog));
	}

	/**
	 * 修改投票记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdPlayerTicketLog hdPlayerTicketLog = hdPlayerTicketLogService.selectHdPlayerTicketLogById(id);
		mmap.put("hdPlayerTicketLog", hdPlayerTicketLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存投票记录
	 */
	@RequiresPermissions("activity:hdPlayerTicketLog:edit")
	@Log(title = "投票记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdPlayerTicketLog hdPlayerTicketLog)
	{		
		return toAjax(hdPlayerTicketLogService.updateHdPlayerTicketLog(hdPlayerTicketLog));
	}
	
	/**
	 * 删除投票记录
	 */
	@RequiresPermissions("activity:hdPlayerTicketLog:remove")
	@Log(title = "投票记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdPlayerTicketLogService.deleteHdPlayerTicketLogByIds(ids));
	}
	
}
