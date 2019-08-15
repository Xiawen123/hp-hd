package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdQuestionnaireGiftMapper;
import com.hp.activity.domain.HdQuestionnaireGift;
import com.hp.activity.service.IHdQuestionnaireGiftService;
import com.hp.common.support.Convert;

/**
 * 问卷礼物 服务层实现
 * 
 * @author hp
 * @date 2019-07-18
 */
@Service
public class HdQuestionnaireGiftServiceImpl implements IHdQuestionnaireGiftService 
{
	@Autowired
	private HdQuestionnaireGiftMapper hdQuestionnaireGiftMapper;

	/**
     * 查询问卷礼物信息
     * 
     * @param id 问卷礼物ID
     * @return 问卷礼物信息
     */
    @Override
	public HdQuestionnaireGift selectHdQuestionnaireGiftById(Long id)
	{
	    return hdQuestionnaireGiftMapper.selectHdQuestionnaireGiftById(id);
	}
	
	/**
     * 查询问卷礼物列表
     * 
     * @param hdQuestionnaireGift 问卷礼物信息
     * @return 问卷礼物集合
     */
	@Override
	public List<HdQuestionnaireGift> selectHdQuestionnaireGiftList(HdQuestionnaireGift hdQuestionnaireGift)
	{
	    return hdQuestionnaireGiftMapper.selectHdQuestionnaireGiftList(hdQuestionnaireGift);
	}
	
    /**
     * 新增问卷礼物
     * 
     * @param hdQuestionnaireGift 问卷礼物信息
     * @return 结果
     */
	@Override
	public int insertHdQuestionnaireGift(HdQuestionnaireGift hdQuestionnaireGift)
	{
	    return hdQuestionnaireGiftMapper.insertHdQuestionnaireGift(hdQuestionnaireGift);
	}
	
	/**
     * 修改问卷礼物
     * 
     * @param hdQuestionnaireGift 问卷礼物信息
     * @return 结果
     */
	@Override
	public int updateHdQuestionnaireGift(HdQuestionnaireGift hdQuestionnaireGift)
	{
	    return hdQuestionnaireGiftMapper.updateHdQuestionnaireGift(hdQuestionnaireGift);
	}

	/**
     * 删除问卷礼物对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdQuestionnaireGiftByIds(String ids)
	{
		return hdQuestionnaireGiftMapper.deleteHdQuestionnaireGiftByIds(Convert.toStrArray(ids));
	}
	
}
