package com.hp.activity.service;

import com.hp.activity.domain.HdPlayerGiftLog;
import java.util.List;

/**
 * 礼物记录 服务层
 * 
 * @author hp
 * @date 2019-05-31
 */
public interface IHdPlayerGiftLogService 
{
	/**
     * 查询礼物记录信息
     * 
     * @param id 礼物记录ID
     * @return 礼物记录信息
     */
	public HdPlayerGiftLog selectHdPlayerGiftLogById(Integer id);
	
	/**
     * 查询礼物记录列表
     * 
     * @param hdPlayerGiftLog 礼物记录信息
     * @return 礼物记录集合
     */
	public List<HdPlayerGiftLog> selectHdPlayerGiftLogList(HdPlayerGiftLog hdPlayerGiftLog);

	List<HdPlayerGiftLog> selectHdPlayerGiftlist(HdPlayerGiftLog hdPlayerGiftLog);
	
	/**
     * 新增礼物记录
     * 
     * @param hdPlayerGiftLog 礼物记录信息
     * @return 结果
     */
	public int insertHdPlayerGiftLog(HdPlayerGiftLog hdPlayerGiftLog);
	
	/**
     * 修改礼物记录
     * 
     * @param hdPlayerGiftLog 礼物记录信息
     * @return 结果
     */
	public int updateHdPlayerGiftLog(HdPlayerGiftLog hdPlayerGiftLog);
		
	/**
     * 删除礼物记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdPlayerGiftLogByIds(String ids);
	
}
