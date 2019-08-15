package com.hp.activity.mapper;

import com.hp.activity.domain.FunseekUser;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 乐寻注册用户 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-06-28
 */
@MapperScan
public interface FunseekUserMapper  extends BaseMapper<FunseekUser>
{
	/**
     * 查询乐寻注册用户信息
     * 
     * @param id 乐寻注册用户ID
     * @return 乐寻注册用户信息
     */
	public FunseekUser selectFunseekUserById(Long id);
	
	/**
     * 查询乐寻注册用户列表
     * 
     * @param funseekUser 乐寻注册用户信息
     * @return 乐寻注册用户集合
     */
	public List<FunseekUser> selectFunseekUserList(FunseekUser funseekUser);
	
	/**
     * 新增乐寻注册用户
     * 
     * @param funseekUser 乐寻注册用户信息
     * @return 结果
     */
	public int insertFunseekUser(FunseekUser funseekUser);
	
	/**
     * 修改乐寻注册用户
     * 
     * @param funseekUser 乐寻注册用户信息
     * @return 结果
     */
	public int updateFunseekUser(FunseekUser funseekUser);
	
	/**
     * 删除乐寻注册用户
     * 
     * @param id 乐寻注册用户ID
     * @return 结果
     */
	public int deleteFunseekUserById(Long id);
	
	/**
     * 批量删除乐寻注册用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFunseekUserByIds(String[] ids);
	
}