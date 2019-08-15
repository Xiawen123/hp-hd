package com.hp.activity.mapper;

import com.hp.activity.domain.HdPlayerTicketLog;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 投票记录 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-05-31
 */
@MapperScan
public interface HdPlayerTicketLogMapper  extends BaseMapper<HdPlayerTicketLog>
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
     * 删除投票记录
     * 
     * @param id 投票记录ID
     * @return 结果
     */
	public int deleteHdPlayerTicketLogById(Integer id);
	
	/**
     * 批量删除投票记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdPlayerTicketLogByIds(String[] ids);

	int selectCounts(HdPlayerTicketLog hdPlayerTicketLog);

	int selectCountHour(HdPlayerTicketLog hdPlayerTicketLog);
	
}