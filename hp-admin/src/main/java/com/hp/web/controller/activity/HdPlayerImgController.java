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
import com.hp.activity.domain.HdPlayerImg;
import com.hp.activity.service.IHdPlayerImgService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 选手图片 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdPlayerImg")
public class HdPlayerImgController extends BaseController
{
    private String prefix = "activity/hdPlayerImg";
	
	@Autowired
	private IHdPlayerImgService hdPlayerImgService;
	
	@RequiresPermissions("activity:hdPlayerImg:view")
	@GetMapping()
	public String hdPlayerImg()
	{
	    return prefix + "/hdPlayerImg";
	}
	
	/**
	 * 查询选手图片列表
	 */
	@RequiresPermissions("activity:hdPlayerImg:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdPlayerImg hdPlayerImg)
	{
		startPage();
        List<HdPlayerImg> list = hdPlayerImgService.selectHdPlayerImgList(hdPlayerImg);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出选手图片列表
	 */
	@RequiresPermissions("activity:hdPlayerImg:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdPlayerImg hdPlayerImg)
    {
    	List<HdPlayerImg> list = hdPlayerImgService.selectHdPlayerImgList(hdPlayerImg);
        ExcelUtil<HdPlayerImg> util = new ExcelUtil<HdPlayerImg>(HdPlayerImg.class);
        return util.exportExcel(list, "hdPlayerImg");
    }
	
	/**
	 * 新增选手图片
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存选手图片
	 */
	@RequiresPermissions("activity:hdPlayerImg:add")
	@Log(title = "选手图片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdPlayerImg hdPlayerImg)
	{		
		return toAjax(hdPlayerImgService.insertHdPlayerImg(hdPlayerImg));
	}

	/**
	 * 修改选手图片
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdPlayerImg hdPlayerImg = hdPlayerImgService.selectHdPlayerImgById(id);
		mmap.put("hdPlayerImg", hdPlayerImg);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存选手图片
	 */
	@RequiresPermissions("activity:hdPlayerImg:edit")
	@Log(title = "选手图片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdPlayerImg hdPlayerImg)
	{		
		return toAjax(hdPlayerImgService.updateHdPlayerImg(hdPlayerImg));
	}
	
	/**
	 * 删除选手图片
	 */
	@RequiresPermissions("activity:hdPlayerImg:remove")
	@Log(title = "选手图片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(HdPlayerImg hdPlayerImg)
	{		
		return toAjax(hdPlayerImgService.deleteHdPlayerImgByIds(hdPlayerImg));
	}
	
}
