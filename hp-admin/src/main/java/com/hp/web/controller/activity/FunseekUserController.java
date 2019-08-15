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
import com.hp.activity.domain.FunseekUser;
import com.hp.activity.service.IFunseekUserService;
import com.hp.framework.web.base.BaseController;
import com.hp.common.page.TableDataInfo;
import com.hp.common.base.AjaxResult;
import com.hp.common.utils.poi.ExcelUtil;

/**
 * 乐寻注册用户 信息操作处理
 * 
 * @author hp
 * @date 2019-06-28
 */
@Controller
@RequestMapping("/activity/funseekUser")
public class FunseekUserController extends BaseController
{
    private String prefix = "activity/funseekUser";
	
	@Autowired
	private IFunseekUserService funseekUserService;
	
	@RequiresPermissions("activity:funseekUser:view")
	@GetMapping()
	public String funseekUser()
	{
	    return prefix + "/funseekUser";
	}
	
	/**
	 * 查询乐寻注册用户列表
	 */
	@RequiresPermissions("activity:funseekUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FunseekUser funseekUser)
	{
		startPage();
        List<FunseekUser> list = funseekUserService.selectFunseekUserList(funseekUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出乐寻注册用户列表
	 */
	@RequiresPermissions("activity:funseekUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FunseekUser funseekUser)
    {
    	List<FunseekUser> list = funseekUserService.selectFunseekUserList(funseekUser);
        ExcelUtil<FunseekUser> util = new ExcelUtil<FunseekUser>(FunseekUser.class);
        return util.exportExcel(list, "funseekUser");
    }
	
	/**
	 * 新增乐寻注册用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存乐寻注册用户
	 */
	@RequiresPermissions("activity:funseekUser:add")
	@Log(title = "乐寻注册用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FunseekUser funseekUser)
	{		
		return toAjax(funseekUserService.insertFunseekUser(funseekUser));
	}

	/**
	 * 修改乐寻注册用户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		FunseekUser funseekUser = funseekUserService.selectFunseekUserById(id);
		mmap.put("funseekUser", funseekUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存乐寻注册用户
	 */
	@RequiresPermissions("activity:funseekUser:edit")
	@Log(title = "乐寻注册用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FunseekUser funseekUser)
	{		
		return toAjax(funseekUserService.updateFunseekUser(funseekUser));
	}
	
	/**
	 * 删除乐寻注册用户
	 */
	@RequiresPermissions("activity:funseekUser:remove")
	@Log(title = "乐寻注册用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(funseekUserService.deleteFunseekUserByIds(ids));
	}
	
}
