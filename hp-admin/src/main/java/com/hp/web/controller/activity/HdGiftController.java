package com.hp.web.controller.activity;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.hp.common.annotation.DataScope;
import com.hp.framework.util.ShiroUtils;
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
import com.hp.activity.domain.HdGift;
import com.hp.activity.service.IHdGiftService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;
import sun.misc.BASE64Decoder;

import javax.xml.crypto.Data;

/**
 * 礼物 信息操作处理
 * 
 * @author hp
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/activity/hdGift")
public class HdGiftController extends BaseController
{
    private String prefix = "activity/hdGift";
	
	@Autowired
	private IHdGiftService hdGiftService;
	
	@RequiresPermissions("activity:hdGift:view")
	@GetMapping()
	public String hdGift()
	{
	    return prefix + "/hdGift";
	}
	
	/**
	 * 查询礼物列表
	 */
	@RequiresPermissions("activity:hdGift:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HdGift hdGift)
	{
		startPage();
        List<HdGift> list = hdGiftService.selectHdGiftList(hdGift);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出礼物列表
	 */
	@RequiresPermissions("activity:hdGift:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HdGift hdGift)
    {
    	List<HdGift> list = hdGiftService.selectHdGiftList(hdGift);
        ExcelUtil<HdGift> util = new ExcelUtil<HdGift>(HdGift.class);
        return util.exportExcel(list, "hdGift");
    }
	
	/**
	 * 新增礼物
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存礼物
	 */
	@RequiresPermissions("activity:hdGift:add")
	@Log(title = "礼物", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HdGift hdGift) throws Exception
	{
		String icon = hdGift.getIcon();
		String suffix = icon.substring(icon.indexOf("/")+1,icon.indexOf(";"));
		CloudStorageService storage = OSSFactory.build();
		String str = icon.substring(icon.indexOf(",")+1,icon.length());
		byte[] bytes = Base64.getDecoder().decode(str);
		String url = storage.uploadSuffix(bytes,"."+suffix);
		hdGift.setIcon(url);
		hdGift.setCreateUser(ShiroUtils.getUserId().intValue());
		hdGift.setCreateTime(new Date());
		return toAjax(hdGiftService.insertHdGift(hdGift));
	}

	/**
	 * 修改礼物
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HdGift hdGift = hdGiftService.selectHdGiftById(id);
		mmap.put("hdGift", hdGift);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存礼物
	 */
	@RequiresPermissions("activity:hdGift:edit")
	@Log(title = "礼物", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HdGift hdGift)
	{
		hdGift.setUpdateUser(ShiroUtils.getUserId().intValue());
		hdGift.setUpdateTime(new Date());
		return toAjax(hdGiftService.updateHdGift(hdGift));
	}
	
	/**
	 * 删除礼物
	 */
	@RequiresPermissions("activity:hdGift:remove")
	@Log(title = "礼物", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hdGiftService.deleteHdGiftByIds(ids));
	}
	
}
