package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdPlayerTicketLogMapper;
import com.hp.activity.domain.HdPlayerTicketLog;
import com.hp.activity.service.IHdPlayerTicketLogService;
import com.hp.common.support.Convert;

/**
 * 投票记录 服务层实现
 * 
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdPlayerTicketLogServiceImpl implements IHdPlayerTicketLogService 
{
	@Autowired
	private HdPlayerTicketLogMapper hdPlayerTicketLogMapper;

	/**
     * 查询投票记录信息
     * 
     * @param id 投票记录ID
     * @return 投票记录信息
     */
    @Override
	public HdPlayerTicketLog selectHdPlayerTicketLogById(Integer id)
	{
	    return hdPlayerTicketLogMapper.selectHdPlayerTicketLogById(id);
	}
	
	/**
     * 查询投票记录列表
     * 
     * @param hdPlayerTicketLog 投票记录信息
     * @return 投票记录集合
     */
	@Override
	public List<HdPlayerTicketLog> selectHdPlayerTicketLogList(HdPlayerTicketLog hdPlayerTicketLog)
	{
	    return hdPlayerTicketLogMapper.selectHdPlayerTicketLogList(hdPlayerTicketLog);
	}
	
    /**
     * 新增投票记录
     * 
     * @param hdPlayerTicketLog 投票记录信息
     * @return 结果
     */
	@Override
	public int insertHdPlayerTicketLog(HdPlayerTicketLog hdPlayerTicketLog)
	{
	    return hdPlayerTicketLogMapper.insertHdPlayerTicketLog(hdPlayerTicketLog);
	}
	
	/**
     * 修改投票记录
     * 
     * @param hdPlayerTicketLog 投票记录信息
     * @return 结果
     */
	@Override
	public int updateHdPlayerTicketLog(HdPlayerTicketLog hdPlayerTicketLog)
	{
	    return hdPlayerTicketLogMapper.updateHdPlayerTicketLog(hdPlayerTicketLog);
	}

	/**
     * 删除投票记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdPlayerTicketLogByIds(String ids)
	{
		return hdPlayerTicketLogMapper.deleteHdPlayerTicketLogByIds(Convert.toStrArray(ids));
	}

	@Override
	public int selectCount(HdPlayerTicketLog hdPlayerTicketLog)
	{
		return hdPlayerTicketLogMapper.selectCounts(hdPlayerTicketLog);
	}

	@Override
	public int selectCountHour(HdPlayerTicketLog hdPlayerTicketLog)
	{
		return hdPlayerTicketLogMapper.selectCountHour(hdPlayerTicketLog);
	}
}
