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
import com.hp.activity.domain.FunseekUserOrder;
import com.hp.activity.service.IFunseekUserOrderService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 用户支付订单记录 信息操作处理
 * 
 * @author hp
 * @date 2019-06-28
 */
@Controller
@RequestMapping("/activity/funseekUserOrder")
public class FunseekUserOrderController extends BaseController
{
    private String prefix = "activity/funseekUserOrder";
	
	@Autowired
	private IFunseekUserOrderService funseekUserOrderService;
	
	@RequiresPermissions("activity:funseekUserOrder:view")
	@GetMapping()
	public String funseekUserOrder()
	{
	    return prefix + "/funseekUserOrder";
	}
	
	/**
	 * 查询用户支付订单记录列表
	 */
	@RequiresPermissions("activity:funseekUserOrder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FunseekUserOrder funseekUserOrder)
	{
		startPage();
        List<FunseekUserOrder> list = funseekUserOrderService.selectFunseekUserOrderList(funseekUserOrder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户支付订单记录列表
	 */
	@RequiresPermissions("activity:funseekUserOrder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FunseekUserOrder funseekUserOrder)
    {
    	List<FunseekUserOrder> list = funseekUserOrderService.selectFunseekUserOrderList(funseekUserOrder);
        ExcelUtil<FunseekUserOrder> util = new ExcelUtil<FunseekUserOrder>(FunseekUserOrder.class);
        return util.exportExcel(list, "funseekUserOrder");
    }
	
	/**
	 * 新增用户支付订单记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户支付订单记录
	 */
	@RequiresPermissions("activity:funseekUserOrder:add")
	@Log(title = "用户支付订单记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FunseekUserOrder funseekUserOrder)
	{		
		return toAjax(funseekUserOrderService.insertFunseekUserOrder(funseekUserOrder));
	}

	/**
	 * 修改用户支付订单记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FunseekUserOrder funseekUserOrder = funseekUserOrderService.selectFunseekUserOrderById(id);
		mmap.put("funseekUserOrder", funseekUserOrder);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户支付订单记录
	 */
	@RequiresPermissions("activity:funseekUserOrder:edit")
	@Log(title = "用户支付订单记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FunseekUserOrder funseekUserOrder)
	{		
		return toAjax(funseekUserOrderService.updateFunseekUserOrder(funseekUserOrder));
	}
	
	/**
	 * 删除用户支付订单记录
	 */
	@RequiresPermissions("activity:funseekUserOrder:remove")
	@Log(title = "用户支付订单记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(funseekUserOrderService.deleteFunseekUserOrderByIds(ids));
	}
	
}
