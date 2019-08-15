package com.hp.system.mapper;

import java.util.List;
import java.util.Map;

import com.hp.system.domain.SysUserRole;

/**
 * 用户表 数据层
 * 
 * @author hp
 */
public interface SysUserRoleMapper
{
    /**
     * 通过用户ID删除用户和角色关联
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserRoleByUserId(Long userId);

    /**
     * 批量删除用户和角色关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserRole(Long[] ids);

    /**
     * 通过角色ID查询角色使用数量
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 根据条件分页查询用户对象RoleId
     *
     * @param sysUserRole 用户信息
     * @return 用户信息集合信息
     */
    public List<Map<String,Object>> selectUserListByRole(SysUserRole sysUserRole);

    /**
     * 批量新增用户角色信息
     * 
     * @param userRoleList 用户角色列表
     * @return 结果
     */
    public int batchUserRole(List<SysUserRole> userRoleList);
}
