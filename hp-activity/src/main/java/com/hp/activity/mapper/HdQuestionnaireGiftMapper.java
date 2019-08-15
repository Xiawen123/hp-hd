package com.hp.activity.mapper;

import com.hp.activity.domain.HdQuestionnaireGift;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 问卷礼物 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-07-18
 */
@MapperScan
public interface HdQuestionnaireGiftMapper  extends BaseMapper<HdQuestionnaireGift>
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
     * 删除问卷礼物
     * 
     * @param id 问卷礼物ID
     * @return 结果
     */
	public int deleteHdQuestionnaireGiftById(Long id);
	
	/**
     * 批量删除问卷礼物
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdQuestionnaireGiftByIds(String[] ids);
	
}