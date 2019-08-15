package com.hp.activity.service;

import com.hp.activity.domain.HdQuestionnaire;
import java.util.List;

/**
 * 问卷 服务层
 * 
 * @author hp
 * @date 2019-07-11
 */
public interface IHdQuestionnaireService 
{
	/**
     * 查询问卷信息
     * 
     * @param id 问卷ID
     * @return 问卷信息
     */
	public HdQuestionnaire selectHdQuestionnaireById(Long id);
	
	/**
     * 查询问卷列表
     * 
     * @param hdQuestionnaire 问卷信息
     * @return 问卷集合
     */
	public List<HdQuestionnaire> selectHdQuestionnaireList(HdQuestionnaire hdQuestionnaire);
	
	/**
     * 新增问卷
     * 
     * @param hdQuestionnaire 问卷信息
     * @return 结果
     */
	public int insertHdQuestionnaire(HdQuestionnaire hdQuestionnaire);
	
	/**
     * 修改问卷
     * 
     * @param hdQuestionnaire 问卷信息
     * @return 结果
     */
	public int updateHdQuestionnaire(HdQuestionnaire hdQuestionnaire);
		
	/**
     * 删除问卷信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdQuestionnaireByIds(String ids);
	
}
