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
import com.hp.activity.domain.HdInfogiftlog;
import com.hp.activity.service.IHdInfogiftlogService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 中奖记录 信息操作处理
 * 
 * @author hp
 * @date 2019-07-18
 */
@Controller
@RequestMapping("/activity/hdInfogiftlog")
public class HdInfogiftlogController extends BaseController
{
    private String prefix = "activity/hdInfogiftlog";
	
	@Autowired
	private IHdInfogiftlogService hdInfogiftlogService;
	
	@RequiresPermissions("activity:hdInfogiftlog:view")
	@GetMapping()
	public String hdInfogiftlog()
	{
	    return prefix + "/hdInfogiftlog";
	}
	
	/**
	 * 查询中奖记录列表
	 */
	@RequiresPermissions("activity:hdInfogiftlog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdInfogiftlog hdInfogiftlog)
	{
		if (hdInfogiftlog.getTime() != null && "".equals(hdInfogiftlog.getTime()) == false){
			String[] array = hdInfogiftlog.getTime().toString().split(" ~ ");
			for (int i = 0; i < array.length; i++) {
				hdInfogiftlog.setStart(array[0]);
				hdInfogiftlog.setEnd(array[1]);
			}
		}
		startPage();
        List<HdInfogiftlog> list = hdInfogiftlogService.selectHdInfogiftlogList(hdInfogiftlog);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出中奖记录列表
	 */
	@RequiresPermissions("activity:hdInfogiftlog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdInfogiftlog hdInfogiftlog)
    {
    	List<HdInfogiftlog> list = hdInfogiftlogService.selectHdInfogiftlogList(hdInfogiftlog);
        ExcelUtil<HdInfogiftlog> util = new ExcelUtil<HdInfogiftlog>(HdInfogiftlog.class);
        return util.exportExcel(list, "hdInfogiftlog");
    }
	
	/**
	 * 新增中奖记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存中奖记录
	 */
	@RequiresPermissions("activity:hdInfogiftlog:add")
	@Log(title = "中奖记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdInfogiftlog hdInfogiftlog)
	{		
		return toAjax(hdInfogiftlogService.insertHdInfogiftlog(hdInfogiftlog));
	}

	/**
	 * 修改中奖记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HdInfogiftlog hdInfogiftlog = hdInfogiftlogService.selectHdInfogiftlogById(id);
		mmap.put("hdInfogiftlog", hdInfogiftlog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存中奖记录
	 */
	@RequiresPermissions("activity:hdInfogiftlog:edit")
	@Log(title = "中奖记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdInfogiftlog hdInfogiftlog)
	{		
		return toAjax(hdInfogiftlogService.updateHdInfogiftlog(hdInfogiftlog));
	}
	
	/**
	 * 删除中奖记录
	 */
	@RequiresPermissions("activity:hdInfogiftlog:remove")
	@Log(title = "中奖记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdInfogiftlogService.deleteHdInfogiftlogByIds(ids));
	}
	
}
