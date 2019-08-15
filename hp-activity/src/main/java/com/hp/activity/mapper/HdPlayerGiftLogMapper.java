package com.hp.activity.mapper;

import com.hp.activity.domain.HdPlayerGiftLog;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 礼物记录 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-05-31
 */
@MapperScan
public interface HdPlayerGiftLogMapper  extends BaseMapper<HdPlayerGiftLog>
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
     * 删除礼物记录
     * 
     * @param id 礼物记录ID
     * @return 结果
     */
	public int deleteHdPlayerGiftLogById(Integer id);
	
	/**
     * 批量删除礼物记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdPlayerGiftLogByIds(String[] ids);
	
}