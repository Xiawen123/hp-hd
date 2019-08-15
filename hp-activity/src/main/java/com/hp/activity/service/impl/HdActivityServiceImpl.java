package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdActivityMapper;
import com.hp.activity.domain.HdActivity;
import com.hp.activity.service.IHdActivityService;
import com.hp.common.support.Convert;

/**
 * 活动 服务层实现
 * 
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdActivityServiceImpl implements IHdActivityService 
{
	@Autowired
	private HdActivityMapper hdActivityMapper;

	/**
     * 查询活动信息
     * 
     * @param id 活动ID
     * @return 活动信息
     */
    @Override
	public HdActivity selectHdActivityById(Integer id)
	{
	    return hdActivityMapper.selectHdActivityById(id);
	}
	
	/**
     * 查询活动列表
     * 
     * @param hdActivity 活动信息
     * @return 活动集合
     */
	@Override
	public List<HdActivity> selectHdActivityList(HdActivity hdActivity)
	{
	    return hdActivityMapper.selectHdActivityList(hdActivity);
	}

	@Override
	public List<HdActivity> selectHotActivity()
	{
		return hdActivityMapper.selectHotActivity();
	}
	
    /**
     * 新增活动
     * 
     * @param hdActivity 活动信息
     * @return 结果
     */
	@Override
	public int insertHdActivity(HdActivity hdActivity)
	{
	    return hdActivityMapper.insertHdActivity(hdActivity);
	}
	
	/**
     * 修改活动
     * 
     * @param hdActivity 活动信息
     * @return 结果
     */
	@Override
	public int updateHdActivity(HdActivity hdActivity)
	{
	    return hdActivityMapper.updateHdActivity(hdActivity);
	}

	/**
     * 删除活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdActivityByIds(String ids)
	{
		return hdActivityMapper.deleteHdActivityByIds(Convert.toStrArray(ids));
	}

	@Override
	public int selectCount(HdActivity hdActivity)
	{
		return hdActivityMapper.selectCount(hdActivity);
	}

	@Override
	public int selectMaxId()
	{
		return hdActivityMapper.selectMaxId();
	}

	@Override
	public int updateTicket(Integer id)
	{
		return hdActivityMapper.updateTicket(id);
	}

	@Override
	public int getHotActivity()
	{
		return hdActivityMapper.getHotActivity();
	}
}
