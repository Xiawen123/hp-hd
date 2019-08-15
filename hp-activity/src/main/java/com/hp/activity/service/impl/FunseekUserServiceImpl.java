package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.FunseekUserMapper;
import com.hp.activity.domain.FunseekUser;
import com.hp.activity.service.IFunseekUserService;
import com.hp.common.support.Convert;

/**
 * 乐寻注册用户 服务层实现
 * 
 * @author hp
 * @date 2019-06-28
 */
@Service
public class FunseekUserServiceImpl implements IFunseekUserService 
{
	@Autowired
	private FunseekUserMapper funseekUserMapper;

	/**
     * 查询乐寻注册用户信息
     * 
     * @param id 乐寻注册用户ID
     * @return 乐寻注册用户信息
     */
    @Override
	public FunseekUser selectFunseekUserById(Long id)
	{
	    return funseekUserMapper.selectFunseekUserById(id);
	}
	
	/**
     * 查询乐寻注册用户列表
     * 
     * @param funseekUser 乐寻注册用户信息
     * @return 乐寻注册用户集合
     */
	@Override
	public List<FunseekUser> selectFunseekUserList(FunseekUser funseekUser)
	{
	    return funseekUserMapper.selectFunseekUserList(funseekUser);
	}
	
    /**
     * 新增乐寻注册用户
     * 
     * @param funseekUser 乐寻注册用户信息
     * @return 结果
     */
	@Override
	public int insertFunseekUser(FunseekUser funseekUser)
	{
	    return funseekUserMapper.insertFunseekUser(funseekUser);
	}
	
	/**
     * 修改乐寻注册用户
     * 
     * @param funseekUser 乐寻注册用户信息
     * @return 结果
     */
	@Override
	public int updateFunseekUser(FunseekUser funseekUser)
	{
	    return funseekUserMapper.updateFunseekUser(funseekUser);
	}

	/**
     * 删除乐寻注册用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFunseekUserByIds(String ids)
	{
		return funseekUserMapper.deleteFunseekUserByIds(Convert.toStrArray(ids));
	}
	
}
