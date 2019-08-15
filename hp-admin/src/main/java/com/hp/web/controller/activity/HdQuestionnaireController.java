package com.hp.web.controller.activity;

import java.util.List;

import com.hp.framework.util.ShiroUtils;
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
import com.hp.activity.domain.HdQuestionnaire;
import com.hp.activity.service.IHdQuestionnaireService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 问卷 信息操作处理
 * 
 * @author hp
 * @date 2019-07-11
 */
@Controller
@RequestMapping("/activity/hdQuestionnaire")
public class HdQuestionnaireController extends BaseController
{
    private String prefix = "activity/hdQuestionnaire";
	
	@Autowired
	private IHdQuestionnaireService hdQuestionnaireService;
	
	@RequiresPermissions("activity:hdQuestionnaire:view")
	@GetMapping()
	public String hdQuestionnaire()
	{
	    return prefix + "/hdQuestionnaire";
	}
	
	/**
	 * 查询问卷列表
	 */
	@RequiresPermissions("activity:hdQuestionnaire:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdQuestionnaire hdQuestionnaire)
	{
		startPage();
        List<HdQuestionnaire> list = hdQuestionnaireService.selectHdQuestionnaireList(hdQuestionnaire);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出问卷列表
	 */
	@RequiresPermissions("activity:hdQuestionnaire:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdQuestionnaire hdQuestionnaire)
    {
    	List<HdQuestionnaire> list = hdQuestionnaireService.selectHdQuestionnaireList(hdQuestionnaire);
        ExcelUtil<HdQuestionnaire> util = new ExcelUtil<HdQuestionnaire>(HdQuestionnaire.class);
        return util.exportExcel(list, "hdQuestionnaire");
    }
	
	/**
	 * 新增问卷
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存问卷
	 */
	@RequiresPermissions("activity:hdQuestionnaire:add")
	@Log(title = "问卷", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdQuestionnaire hdQuestionnaire)
	{		
		return toAjax(hdQuestionnaireService.insertHdQuestionnaire(hdQuestionnaire));
	}

	/**
	 * 修改问卷
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HdQuestionnaire hdQuestionnaire = hdQuestionnaireService.selectHdQuestionnaireById(id);
		mmap.put("hdQuestionnaire", hdQuestionnaire);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存问卷
	 */
	@RequiresPermissions("activity:hdQuestionnaire:edit")
	@Log(title = "问卷", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdQuestionnaire hdQuestionnaire)
	{		
		return toAjax(hdQuestionnaireService.updateHdQuestionnaire(hdQuestionnaire));
	}
	
	/**
	 * 删除问卷
	 */
	@RequiresPermissions("activity:hdQuestionnaire:remove")
	@Log(title = "问卷", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdQuestionnaireService.deleteHdQuestionnaireByIds(ids));
	}

	/**
	 * 任务调度状态修改
	 */
	@Log(title = "问卷", businessType = BusinessType.UPDATE)
	@RequiresPermissions("activity:hdQuestionnaire:changeStatus")
	@PostMapping("/changeStatus")
	@ResponseBody
	public AjaxResult changeStatus(HdQuestionnaire hdQuestionnaire)
	{
		hdQuestionnaire.setUpdateUser(ShiroUtils.getSysUser().getUserId().intValue());
		return toAjax(hdQuestionnaireService.updateHdQuestionnaire(hdQuestionnaire));
	}

	/**
	 * 问卷内容
	 */
	@GetMapping("/player/{id}")
	public String player(@PathVariable("id") Integer id, ModelMap mmap)
	{
		mmap.put("player",id);
		return "activity/hdInfo/hdInfo";
	}

	/**
	 * 问卷内容
	 */
	@GetMapping("/gift/{id}")
	public String gift(@PathVariable("id") Integer id, ModelMap mmap)
	{
		mmap.put("player",id);
		return "activity/hdQuestionnaireGift/hdQuestionnaireGift";
	}

	/**
	 * 问卷内容
	 */
	@GetMapping("/log/{id}")
	public String log(@PathVariable("id") Integer id, ModelMap mmap)
	{
		mmap.put("player",id);
		return "activity/hdInfogiftlog/hdInfogiftlog";
	}
}
