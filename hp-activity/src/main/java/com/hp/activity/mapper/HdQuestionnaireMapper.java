package com.hp.activity.mapper;

import com.hp.activity.domain.HdQuestionnaire;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 问卷 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-07-11
 */
@MapperScan
public interface HdQuestionnaireMapper  extends BaseMapper<HdQuestionnaire>
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
     * 删除问卷
     * 
     * @param id 问卷ID
     * @return 结果
     */
	public int deleteHdQuestionnaireById(Long id);
	
	/**
     * 批量删除问卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdQuestionnaireByIds(String[] ids);
	
}