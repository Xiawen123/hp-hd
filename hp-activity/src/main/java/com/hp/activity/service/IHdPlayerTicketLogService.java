package com.hp.activity.service;

import com.hp.activity.domain.HdPlayerTicketLog;
import java.util.List;

/**
 * 投票记录 服务层
 * 
 * @author hp
 * @date 2019-05-31
 */
public interface IHdPlayerTicketLogService 
{
	/**
     * 查询投票记录信息
     * 
     * @param id 投票记录ID
     * @return 投票记录信息
     */
	public HdPlayerTicketLog selectHdPlayerTicketLogById(Integer id);
	
	/**
     * 查询投票记录列表
     * 
     * @param hdPlayerTicketLog 投票记录信息
     * @return 投票记录集合
     */
	public List<HdPlayerTicketLog> selectHdPlayerTicketLogList(HdPlayerTicketLog hdPlayerTicketLog);
	
	/**
     * 新增投票记录
     * 
     * @param hdPlayerTicketLog 投票记录信息
     * @return 结果
     */
	public int insertHdPlayerTicketLog(HdPlayerTicketLog hdPlayerTicketLog);
	
	/**
     * 修改投票记录
     * 
     * @param hdPlayerTicketLog 投票记录信息
     * @return 结果
     */
	public int updateHdPlayerTicketLog(HdPlayerTicketLog hdPlayerTicketLog);
		
	/**
     * 删除投票记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdPlayerTicketLogByIds(String ids);

	int selectCount(HdPlayerTicketLog hdPlayerTicketLog);

	int selectCountHour(HdPlayerTicketLog hdPlayerTicketLog);
	
}
