package com.hp.activity.service;

import com.hp.activity.domain.HdInfogiftlog;
import java.util.List;

/**
 * 中奖记录 服务层
 * 
 * @author hp
 * @date 2019-07-18
 */
public interface IHdInfogiftlogService 
{
	/**
     * 查询中奖记录信息
     * 
     * @param id 中奖记录ID
     * @return 中奖记录信息
     */
	public HdInfogiftlog selectHdInfogiftlogById(Long id);
	
	/**
     * 查询中奖记录列表
     * 
     * @param hdInfogiftlog 中奖记录信息
     * @return 中奖记录集合
     */
	public List<HdInfogiftlog> selectHdInfogiftlogList(HdInfogiftlog hdInfogiftlog);
	
	/**
     * 新增中奖记录
     * 
     * @param hdInfogiftlog 中奖记录信息
     * @return 结果
     */
	public int insertHdInfogiftlog(HdInfogiftlog hdInfogiftlog);
	
	/**
     * 修改中奖记录
     * 
     * @param hdInfogiftlog 中奖记录信息
     * @return 结果
     */
	public int updateHdInfogiftlog(HdInfogiftlog hdInfogiftlog);
		
	/**
     * 删除中奖记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdInfogiftlogByIds(String ids);
	
}
