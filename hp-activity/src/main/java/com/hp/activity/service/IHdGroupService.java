package com.hp.activity.service;

import com.hp.activity.domain.HdGroup;
import java.util.List;

/**
 * 选手分组 服务层
 * 
 * @author hp
 * @date 2019-05-31
 */
public interface IHdGroupService 
{
	/**
     * 查询选手分组信息
     * 
     * @param id 选手分组ID
     * @return 选手分组信息
     */
	public HdGroup selectHdGroupById(Integer id);
	
	/**
     * 查询选手分组列表
     * 
     * @param hdGroup 选手分组信息
     * @return 选手分组集合
     */
	public List<HdGroup> selectHdGroupList(HdGroup hdGroup);
	
	/**
     * 新增选手分组
     * 
     * @param hdGroup 选手分组信息
     * @return 结果
     */
	public int insertHdGroup(HdGroup hdGroup);
	
	/**
     * 修改选手分组
     * 
     * @param hdGroup 选手分组信息
     * @return 结果
     */
	public int updateHdGroup(HdGroup hdGroup);
		
	/**
     * 删除选手分组信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdGroupByIds(HdGroup hdGroup);
	
}
