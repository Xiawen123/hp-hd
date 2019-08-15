package com.hp.activity.service;

import com.hp.activity.domain.HdQuestionnaireGift;
import java.util.List;

/**
 * 问卷礼物 服务层
 * 
 * @author hp
 * @date 2019-07-18
 */
public interface IHdQuestionnaireGiftService 
{
	/**
     * 查询问卷礼物信息
     * 
     * @param id 问卷礼物ID
     * @return 问卷礼物信息
     */
	public HdQuestionnaireGift selectHdQuestionnaireGiftById(Long id);
	
	/**
     * 查询问卷礼物列表
     * 
     * @param hdQuestionnaireGift 问卷礼物信息
     * @return 问卷礼物集合
     */
	public List<HdQuestionnaireGift> selectHdQuestionnaireGiftList(HdQuestionnaireGift hdQuestionnaireGift);
	
	/**
     * 新增问卷礼物
     * 
     * @param hdQuestionnaireGift 问卷礼物信息
     * @return 结果
     */
	public int insertHdQuestionnaireGift(HdQuestionnaireGift hdQuestionnaireGift);
	
	/**
     * 修改问卷礼物
     * 
     * @param hdQuestionnaireGift 问卷礼物信息
     * @return 结果
     */
	public int updateHdQuestionnaireGift(HdQuestionnaireGift hdQuestionnaireGift);
		
	/**
     * 删除问卷礼物信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdQuestionnaireGiftByIds(String ids);
	
}
