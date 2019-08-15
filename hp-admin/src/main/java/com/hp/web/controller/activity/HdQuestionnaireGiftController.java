package com.hp.web.controller.activity;

import java.util.Base64;
import java.util.Date;
import java.util.List;

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
import com.hp.activity.domain.HdQuestionnaireGift;
import com.hp.activity.service.IHdQuestionnaireGiftService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 问卷礼物 信息操作处理
 * 
 * @author hp
 * @date 2019-07-18
 */
@Controller
@RequestMapping("/activity/hdQuestionnaireGift")
public class HdQuestionnaireGiftController extends BaseController
{
    private String prefix = "activity/hdQuestionnaireGift";
	
	@Autowired
	private IHdQuestionnaireGiftService hdQuestionnaireGiftService;
	
	@RequiresPermissions("activity:hdQuestionnaireGift:view")
	@GetMapping()
	public String hdQuestionnaireGift()
	{
	    return prefix + "/hdQuestionnaireGift";
	}
	
	/**
	 * 查询问卷礼物列表
	 */
	@RequiresPermissions("activity:hdQuestionnaireGift:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdQuestionnaireGift hdQuestionnaireGift)
	{
		startPage();
        List<HdQuestionnaireGift> list = hdQuestionnaireGiftService.selectHdQuestionnaireGiftList(hdQuestionnaireGift);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出问卷礼物列表
	 */
	@RequiresPermissions("activity:hdQuestionnaireGift:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdQuestionnaireGift hdQuestionnaireGift)
    {
    	List<HdQuestionnaireGift> list = hdQuestionnaireGiftService.selectHdQuestionnaireGiftList(hdQuestionnaireGift);
        ExcelUtil<HdQuestionnaireGift> util = new ExcelUtil<HdQuestionnaireGift>(HdQuestionnaireGift.class);
        return util.exportExcel(list, "hdQuestionnaireGift");
    }
	
	/**
	 * 新增问卷礼物
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("questionnaireId",id);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存问卷礼物
	 */
	@RequiresPermissions("activity:hdQuestionnaireGift:add")
	@Log(title = "问卷礼物", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdQuestionnaireGift hdQuestionnaireGift)
	{
		String icon = hdQuestionnaireGift.getIcon();
		String suffix = icon.substring(icon.indexOf("/")+1,icon.indexOf(";"));
		CloudStorageService storage = OSSFactory.build();
		String str = icon.substring(icon.indexOf(",")+1,icon.length());
		byte[] bytes = Base64.getDecoder().decode(str);
		String url = storage.uploadSuffix(bytes,"."+suffix);
		hdQuestionnaireGift.setIcon(url);
		hdQuestionnaireGift.setCreateTime(new Date());
		return toAjax(hdQuestionnaireGiftService.insertHdQuestionnaireGift(hdQuestionnaireGift));
	}

	/**
	 * 修改问卷礼物
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HdQuestionnaireGift hdQuestionnaireGift = hdQuestionnaireGiftService.selectHdQuestionnaireGiftById(id);
		mmap.put("hdQuestionnaireGift", hdQuestionnaireGift);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存问卷礼物
	 */
	@RequiresPermissions("activity:hdQuestionnaireGift:edit")
	@Log(title = "问卷礼物", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdQuestionnaireGift hdQuestionnaireGift)
	{		
		return toAjax(hdQuestionnaireGiftService.updateHdQuestionnaireGift(hdQuestionnaireGift));
	}
	
	/**
	 * 删除问卷礼物
	 */
	@RequiresPermissions("activity:hdQuestionnaireGift:remove")
	@Log(title = "问卷礼物", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdQuestionnaireGiftService.deleteHdQuestionnaireGiftByIds(ids));
	}
	
}
