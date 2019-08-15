package com.hp.activity.mapper;

import com.hp.activity.domain.HdGroup;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 选手分组 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-05-31
 */
@MapperScan
public interface HdGroupMapper  extends BaseMapper<HdGroup>
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
     * 删除选手分组
     * 
     * @param id 选手分组ID
     * @return 结果
     */
	public int deleteHdGroupById(Integer id);
	
	/**
     * 批量删除选手分组
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdGroupByIds(HdGroup hdGroup);
	
}