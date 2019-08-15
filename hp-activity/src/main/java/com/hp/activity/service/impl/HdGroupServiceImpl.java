package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdGroupMapper;
import com.hp.activity.domain.HdGroup;
import com.hp.activity.service.IHdGroupService;
import com.hp.common.support.Convert;

/**
 * 选手分组 服务层实现
 * 
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdGroupServiceImpl implements IHdGroupService 
{
	@Autowired
	private HdGroupMapper hdGroupMapper;

	/**
     * 查询选手分组信息
     * 
     * @param id 选手分组ID
     * @return 选手分组信息
     */
    @Override
	public HdGroup selectHdGroupById(Integer id)
	{
	    return hdGroupMapper.selectHdGroupById(id);
	}
	
	/**
     * 查询选手分组列表
     * 
     * @param hdGroup 选手分组信息
     * @return 选手分组集合
     */
	@Override
	public List<HdGroup> selectHdGroupList(HdGroup hdGroup)
	{
	    return hdGroupMapper.selectHdGroupList(hdGroup);
	}
	
    /**
     * 新增选手分组
     * 
     * @param hdGroup 选手分组信息
     * @return 结果
     */
	@Override
	public int insertHdGroup(HdGroup hdGroup)
	{
	    return hdGroupMapper.insertHdGroup(hdGroup);
	}
	
	/**
     * 修改选手分组
     * 
     * @param hdGroup 选手分组信息
     * @return 结果
     */
	@Override
	public int updateHdGroup(HdGroup hdGroup)
	{
	    return hdGroupMapper.updateHdGroup(hdGroup);
	}

	/**
     * 删除选手分组对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdGroupByIds(HdGroup hdGroup)
	{
		return hdGroupMapper.deleteHdGroupByIds(hdGroup);
	}
	
}
