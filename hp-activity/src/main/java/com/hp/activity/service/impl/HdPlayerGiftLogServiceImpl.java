package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdPlayerGiftLogMapper;
import com.hp.activity.domain.HdPlayerGiftLog;
import com.hp.activity.service.IHdPlayerGiftLogService;
import com.hp.common.support.Convert;

/**
 * 礼物记录 服务层实现
 * 
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdPlayerGiftLogServiceImpl implements IHdPlayerGiftLogService 
{
	@Autowired
	private HdPlayerGiftLogMapper hdPlayerGiftLogMapper;

	/**
     * 查询礼物记录信息
     * 
     * @param id 礼物记录ID
     * @return 礼物记录信息
     */
    @Override
	public HdPlayerGiftLog selectHdPlayerGiftLogById(Integer id)
	{
	    return hdPlayerGiftLogMapper.selectHdPlayerGiftLogById(id);
	}
	
	/**
     * 查询礼物记录列表
     * 
     * @param hdPlayerGiftLog 礼物记录信息
     * @return 礼物记录集合
     */
	@Override
	public List<HdPlayerGiftLog> selectHdPlayerGiftLogList(HdPlayerGiftLog hdPlayerGiftLog)
	{
	    return hdPlayerGiftLogMapper.selectHdPlayerGiftLogList(hdPlayerGiftLog);
	}

	@Override
	public List<HdPlayerGiftLog> selectHdPlayerGiftlist(HdPlayerGiftLog hdPlayerGiftLog)
	{
		return hdPlayerGiftLogMapper.selectHdPlayerGiftlist(hdPlayerGiftLog);
	}
	
    /**
     * 新增礼物记录
     * 
     * @param hdPlayerGiftLog 礼物记录信息
     * @return 结果
     */
	@Override
	public int insertHdPlayerGiftLog(HdPlayerGiftLog hdPlayerGiftLog)
	{
	    return hdPlayerGiftLogMapper.insertHdPlayerGiftLog(hdPlayerGiftLog);
	}
	
	/**
     * 修改礼物记录
     * 
     * @param hdPlayerGiftLog 礼物记录信息
     * @return 结果
     */
	@Override
	public int updateHdPlayerGiftLog(HdPlayerGiftLog hdPlayerGiftLog)
	{
	    return hdPlayerGiftLogMapper.updateHdPlayerGiftLog(hdPlayerGiftLog);
	}

	/**
     * 删除礼物记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdPlayerGiftLogByIds(String ids)
	{
		return hdPlayerGiftLogMapper.deleteHdPlayerGiftLogByIds(Convert.toStrArray(ids));
	}
	
}
