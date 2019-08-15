package com.hp.activity.mapper;

import com.hp.activity.domain.HdGift;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 礼物 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-05-31
 */
@MapperScan
public interface HdGiftMapper  extends BaseMapper<HdGift>
{
	/**
     * 查询礼物信息
     * 
     * @param id 礼物ID
     * @return 礼物信息
     */
	public HdGift selectHdGiftById(Integer id);
	
	/**
     * 查询礼物列表
     * 
     * @param hdGift 礼物信息
     * @return 礼物集合
     */
	public List<HdGift> selectHdGiftList(HdGift hdGift);
	
	/**
     * 新增礼物
     * 
     * @param hdGift 礼物信息
     * @return 结果
     */
	public int insertHdGift(HdGift hdGift);
	
	/**
     * 修改礼物
     * 
     * @param hdGift 礼物信息
     * @return 结果
     */
	public int updateHdGift(HdGift hdGift);
	
	/**
     * 删除礼物
     * 
     * @param id 礼物ID
     * @return 结果
     */
	public int deleteHdGiftById(Integer id);
	
	/**
     * 批量删除礼物
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdGiftByIds(String[] ids);
	
}