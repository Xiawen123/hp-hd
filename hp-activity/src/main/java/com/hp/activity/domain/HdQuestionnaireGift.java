package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 问卷礼物表 hd_questionnaire_gift
 * 
 * @author hp
 * @date 2019-07-18
 */
public class HdQuestionnaireGift extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Long id;
	/** 礼物名称 */
	private String name;
	/** 礼物图标 */
	private String icon;
	/** 问卷编号 */
	private Long questionnaireId;
	/** 删除标识（0已删除1未删除） */
	private Integer extend1;
	/**  */
	private String extend2;
	/**  */
	private String extend3;
	/**  */
	private String extend4;
	/**  */
	private String extend5;

	private Boolean isBack;

	private Boolean isMove;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setIcon(String icon) 
	{
		this.icon = icon;
	}

	public String getIcon() 
	{
		return icon;
	}
	public void setQuestionnaireId(Long questionnaireId) 
	{
		this.questionnaireId = questionnaireId;
	}

	public Long getQuestionnaireId() 
	{
		return questionnaireId;
	}
	public void setExtend1(Integer extend1) 
	{
		this.extend1 = extend1;
	}

	public Integer getExtend1() 
	{
		return extend1;
	}
	public void setExtend2(String extend2) 
	{
		this.extend2 = extend2;
	}

	public String getExtend2() 
	{
		return extend2;
	}
	public void setExtend3(String extend3) 
	{
		this.extend3 = extend3;
	}

	public String getExtend3() 
	{
		return extend3;
	}
	public void setExtend4(String extend4) 
	{
		this.extend4 = extend4;
	}

	public String getExtend4() 
	{
		return extend4;
	}
	public void setExtend5(String extend5) 
	{
		this.extend5 = extend5;
	}

	public String getExtend5() 
	{
		return extend5;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("icon", getIcon())
            .append("questionnaireId", getQuestionnaireId())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .toString();
    }

	public Boolean getBack() {
		return isBack;
	}

	public void setBack(Boolean back) {
		isBack = back;
	}

	public Boolean getMove() {
		return isMove;
	}

	public void setMove(Boolean move) {
		isMove = move;
	}
}
