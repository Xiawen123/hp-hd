package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdInfogiftlogMapper;
import com.hp.activity.domain.HdInfogiftlog;
import com.hp.activity.service.IHdInfogiftlogService;
import com.hp.common.support.Convert;

/**
 * 中奖记录 服务层实现
 * 
 * @author hp
 * @date 2019-07-18
 */
@Service
public class HdInfogiftlogServiceImpl implements IHdInfogiftlogService 
{
	@Autowired
	private HdInfogiftlogMapper hdInfogiftlogMapper;

	/**
     * 查询中奖记录信息
     * 
     * @param id 中奖记录ID
     * @return 中奖记录信息
     */
    @Override
	public HdInfogiftlog selectHdInfogiftlogById(Long id)
	{
	    return hdInfogiftlogMapper.selectHdInfogiftlogById(id);
	}
	
	/**
     * 查询中奖记录列表
     * 
     * @param hdInfogiftlog 中奖记录信息
     * @return 中奖记录集合
     */
	@Override
	public List<HdInfogiftlog> selectHdInfogiftlogList(HdInfogiftlog hdInfogiftlog)
	{
	    return hdInfogiftlogMapper.selectHdInfogiftlogList(hdInfogiftlog);
	}
	
    /**
     * 新增中奖记录
     * 
     * @param hdInfogiftlog 中奖记录信息
     * @return 结果
     */
	@Override
	public int insertHdInfogiftlog(HdInfogiftlog hdInfogiftlog)
	{
	    return hdInfogiftlogMapper.insertHdInfogiftlog(hdInfogiftlog);
	}
	
	/**
     * 修改中奖记录
     * 
     * @param hdInfogiftlog 中奖记录信息
     * @return 结果
     */
	@Override
	public int updateHdInfogiftlog(HdInfogiftlog hdInfogiftlog)
	{
	    return hdInfogiftlogMapper.updateHdInfogiftlog(hdInfogiftlog);
	}

	/**
     * 删除中奖记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdInfogiftlogByIds(String ids)
	{
		return hdInfogiftlogMapper.deleteHdInfogiftlogByIds(Convert.toStrArray(ids));
	}
	
}
