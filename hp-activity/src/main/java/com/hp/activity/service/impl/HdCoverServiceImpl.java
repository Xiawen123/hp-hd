package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdCoverMapper;
import com.hp.activity.domain.HdCover;
import com.hp.activity.service.IHdCoverService;
import com.hp.common.support.Convert;

/**
 * 活动封面 服务层实现
 * 
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdCoverServiceImpl implements IHdCoverService 
{
	@Autowired
	private HdCoverMapper hdCoverMapper;

	/**
     * 查询活动封面信息
     * 
     * @param id 活动封面ID
     * @return 活动封面信息
     */
    @Override
	public HdCover selectHdCoverById(Integer id)
	{
	    return hdCoverMapper.selectHdCoverById(id);
	}
	
	/**
     * 查询活动封面列表
     * 
     * @param hdCover 活动封面信息
     * @return 活动封面集合
     */
	@Override
	public List<HdCover> selectHdCoverList(HdCover hdCover)
	{
	    return hdCoverMapper.selectHdCoverList(hdCover);
	}
	
    /**
     * 新增活动封面
     * 
     * @param hdCover 活动封面信息
     * @return 结果
     */
	@Override
	public int insertHdCover(HdCover hdCover)
	{
	    return hdCoverMapper.insertHdCover(hdCover);
	}
	
	/**
     * 修改活动封面
     * 
     * @param hdCover 活动封面信息
     * @return 结果
     */
	@Override
	public int updateHdCover(HdCover hdCover)
	{
	    return hdCoverMapper.updateHdCover(hdCover);
	}

	/**
     * 删除活动封面对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdCoverByIds(HdCover hdCover)
	{
		return hdCoverMapper.deleteHdCoverByIds(hdCover);
	}
	
}
