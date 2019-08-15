package com.hp.activity.mapper;

import com.hp.activity.domain.HdPlayer;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 选手 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-05-31
 */
@MapperScan
public interface HdPlayerMapper  extends BaseMapper<HdPlayer>
{
	/**
     * 查询选手信息
     * 
     * @param id 选手ID
     * @return 选手信息
     */
	public HdPlayer selectHdPlayerById(Integer id);
	
	/**
     * 查询选手列表
     * 
     * @param hdPlayer 选手信息
     * @return 选手集合
     */
	public List<HdPlayer> selectHdPlayerList(HdPlayer hdPlayer);

	List<HdPlayer> playerRank(HdPlayer hdPlayer);

	List<HdPlayer> playerRank1(HdPlayer hdPlayer);

	List<HdPlayer> playerRankAll(HdPlayer hdPlayer);
	
	/**
     * 新增选手
     * 
     * @param hdPlayer 选手信息
     * @return 结果
     */
	public int insertHdPlayer(HdPlayer hdPlayer);
	
	/**
     * 修改选手
     * 
     * @param hdPlayer 选手信息
     * @return 结果
     */
	public int updateHdPlayer(HdPlayer hdPlayer);
	
	/**
     * 删除选手
     * 
     * @param id 选手ID
     * @return 结果
     */
	public int deleteHdPlayerById(Integer id);
	
	/**
     * 批量删除选手
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdPlayerByIds(String[] ids);

	int selectMaxId();

	int selectMaxExtend2(HdPlayer hdPlayer);

	int updatePlayerTicket(Integer id);

	List<HdPlayer> selectRankList(Integer id);
}