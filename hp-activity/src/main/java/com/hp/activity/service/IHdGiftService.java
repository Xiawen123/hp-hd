package com.hp.activity.service;

import com.hp.activity.domain.HdGift;
import java.util.List;

/**
 * 礼物 服务层
 * 
 * @author hp
 * @date 2019-05-31
 */
public interface IHdGiftService 
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
     * 删除礼物信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdGiftByIds(String ids);

	String loginByWeixin(String code);

	String getAccctoken();
}
