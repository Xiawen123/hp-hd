package com.hp.activity.service.impl;

import java.util.List;

import com.hp.activity.domain.HdActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdPlayerMapper;
import com.hp.activity.domain.HdPlayer;
import com.hp.activity.service.IHdPlayerService;
import com.hp.common.support.Convert;

/**
 * 选手 服务层实现
 * 
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdPlayerServiceImpl implements IHdPlayerService 
{
	@Autowired
	private HdPlayerMapper hdPlayerMapper;

	/**
     * 查询选手信息
     * 
     * @param id 选手ID
     * @return 选手信息
     */
    @Override
	public HdPlayer selectHdPlayerById(Integer id)
	{
	    return hdPlayerMapper.selectHdPlayerById(id);
	}
	
	/**
     * 查询选手列表
     * 
     * @param hdPlayer 选手信息
     * @return 选手集合
     */
	@Override
	public List<HdPlayer> selectHdPlayerList(HdPlayer hdPlayer)
	{
	    return hdPlayerMapper.selectHdPlayerList(hdPlayer);
	}

	@Override
	public List<HdPlayer> playerRank(HdPlayer hdPlayer)
	{
		return hdPlayerMapper.playerRank(hdPlayer);
	}

	@Override
	public List<HdPlayer> playerRank1(HdPlayer hdPlayer)
	{
		return hdPlayerMapper.playerRank1(hdPlayer);
	}

	@Override
	public List<HdPlayer> playerRankAll(HdPlayer hdPlayer)
	{
		return hdPlayerMapper.playerRankAll(hdPlayer);
	}

    /**
     * 新增选手
     * 
     * @param hdPlayer 选手信息
     * @return 结果
     */
	@Override
	public int insertHdPlayer(HdPlayer hdPlayer)
	{
	    return hdPlayerMapper.insertHdPlayer(hdPlayer);
	}
	
	/**
     * 修改选手
     * 
     * @param hdPlayer 选手信息
     * @return 结果
     */
	@Override
	public int updateHdPlayer(HdPlayer hdPlayer)
	{
	    return hdPlayerMapper.updateHdPlayer(hdPlayer);
	}

	/**
     * 删除选手对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdPlayerByIds(String ids)
	{
		return hdPlayerMapper.deleteHdPlayerByIds(Convert.toStrArray(ids));
	}

	@Override
	public int selectCountByActivityId(int activityId)
	{
		HdPlayer hp = new HdPlayer();
		hp.setActivityId(activityId);
		return hdPlayerMapper.selectCount(hp);
	}

	@Override
	public int selectCount(HdPlayer hdPlayer)
	{
		return hdPlayerMapper.selectCount(hdPlayer);
	}

	@Override
	public int selectMaxId()
	{
		return hdPlayerMapper.selectMaxId();
	}

	@Override
	public int selectMaxExtend2(HdPlayer hdPlayer)
	{
		return hdPlayerMapper.selectMaxExtend2(hdPlayer);
	}

	@Override
	public int updatePlayerTicket(Integer id)
	{
		return hdPlayerMapper.updatePlayerTicket(id);
	}

	@Override
	public List<HdPlayer> selectRankList(Integer id)
	{
		return hdPlayerMapper.selectRankList(id);
	}

	@Override
	public int insertSelective(HdPlayer hdPlayer)
	{
		return hdPlayerMapper.insertSelective(hdPlayer);
	}
}
