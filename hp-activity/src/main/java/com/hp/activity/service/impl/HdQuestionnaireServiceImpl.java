package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdQuestionnaireMapper;
import com.hp.activity.domain.HdQuestionnaire;
import com.hp.activity.service.IHdQuestionnaireService;
import com.hp.common.support.Convert;

/**
 * 问卷 服务层实现
 * 
 * @author hp
 * @date 2019-07-11
 */
@Service
public class HdQuestionnaireServiceImpl implements IHdQuestionnaireService 
{
	@Autowired
	private HdQuestionnaireMapper hdQuestionnaireMapper;

	/**
     * 查询问卷信息
     * 
     * @param id 问卷ID
     * @return 问卷信息
     */
    @Override
	public HdQuestionnaire selectHdQuestionnaireById(Long id)
	{
	    return hdQuestionnaireMapper.selectHdQuestionnaireById(id);
	}
	
	/**
     * 查询问卷列表
     * 
     * @param hdQuestionnaire 问卷信息
     * @return 问卷集合
     */
	@Override
	public List<HdQuestionnaire> selectHdQuestionnaireList(HdQuestionnaire hdQuestionnaire)
	{
	    return hdQuestionnaireMapper.selectHdQuestionnaireList(hdQuestionnaire);
	}
	
    /**
     * 新增问卷
     * 
     * @param hdQuestionnaire 问卷信息
     * @return 结果
     */
	@Override
	public int insertHdQuestionnaire(HdQuestionnaire hdQuestionnaire)
	{
	    return hdQuestionnaireMapper.insertHdQuestionnaire(hdQuestionnaire);
	}
	
	/**
     * 修改问卷
     * 
     * @param hdQuestionnaire 问卷信息
     * @return 结果
     */
	@Override
	public int updateHdQuestionnaire(HdQuestionnaire hdQuestionnaire)
	{
	    return hdQuestionnaireMapper.updateHdQuestionnaire(hdQuestionnaire);
	}

	/**
     * 删除问卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdQuestionnaireByIds(String ids)
	{
		return hdQuestionnaireMapper.deleteHdQuestionnaireByIds(Convert.toStrArray(ids));
	}
	
}
