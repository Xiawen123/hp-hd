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
import com.hp.activity.domain.HdCover;
import com.hp.activity.service.IHdCoverService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 活动封面 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdCover")
public class HdCoverController extends BaseController
{
    private String prefix = "activity/hdCover";
	
	@Autowired
	private IHdCoverService hdCoverService;
	
	@RequiresPermissions("activity:hdCover:view")
	@GetMapping()
	public String hdCover()
	{
	    return prefix + "/hdCover";
	}
	
	/**
	 * 查询活动封面列表
	 */
	@RequiresPermissions("activity:hdCover:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdCover hdCover)
	{
		startPage();
        List<HdCover> list = hdCoverService.selectHdCoverList(hdCover);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出活动封面列表
	 */
	@RequiresPermissions("activity:hdCover:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdCover hdCover)
    {
    	List<HdCover> list = hdCoverService.selectHdCoverList(hdCover);
        ExcelUtil<HdCover> util = new ExcelUtil<HdCover>(HdCover.class);
        return util.exportExcel(list, "hdCover");
    }
	
	/**
	 * 新增活动封面
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存活动封面
	 */
	@RequiresPermissions("activity:hdCover:add")
	@Log(title = "活动封面", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdCover hdCover)
	{		
		return toAjax(hdCoverService.insertHdCover(hdCover));
	}

	/**
	 * 修改活动封面
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdCover hdCover = hdCoverService.selectHdCoverById(id);
		mmap.put("hdCover", hdCover);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存活动封面
	 */
	@RequiresPermissions("activity:hdCover:edit")
	@Log(title = "活动封面", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdCover hdCover)
	{		
		return toAjax(hdCoverService.updateHdCover(hdCover));
	}
	
	/**
	 * 删除活动封面
	 */
	@RequiresPermissions("activity:hdCover:remove")
	@Log(title = "活动封面", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(HdCover hdCover)
	{		
		return toAjax(hdCoverService.deleteHdCoverByIds(hdCover));
	}
	
}
