package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 学员调查问卷内容表 hd_info
 * 
 * @author hp
 * @date 2019-07-16
 */
public class HdInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Long id;
	/** 问卷ID */
	private Long questionnaireId;
	/** 姓名 */
	private String name;
	/** 年龄 */
	private Integer age;
	/** 原因 */
	private String cause;
	/** 有无其他同学考虑 */
	private Integer otherStudent;
	/** 为什么选择IT */
	private String whyChoose;
	/** 课外兴趣活动 */
	private String interest;
	/** 薪资期望 */
	private String compensation;
	/** 微信昵称 */
	private String wcName;
	/** 微信头像 */
	private String wcHeadicon;
	/** 微信id */
	private String wcId;
	/** 创建时间 */
	private Date createTime;
	/**  */
	private String extend1;
	/**  */
	private String extend2;
	/**  */
	private String extend3;
	/**  */
	private String extend4;
	/**  */
	private String extend5;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setQuestionnaireId(Long questionnaireId) 
	{
		this.questionnaireId = questionnaireId;
	}

	public Long getQuestionnaireId() 
	{
		return questionnaireId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setAge(Integer age) 
	{
		this.age = age;
	}

	public Integer getAge() 
	{
		return age;
	}
	public void setCause(String cause) 
	{
		this.cause = cause;
	}

	public String getCause() 
	{
		return cause;
	}
	public void setOtherStudent(Integer otherStudent) 
	{
		this.otherStudent = otherStudent;
	}

	public Integer getOtherStudent() 
	{
		return otherStudent;
	}
	public void setWhyChoose(String whyChoose) 
	{
		this.whyChoose = whyChoose;
	}

	public String getWhyChoose() 
	{
		return whyChoose;
	}
	public void setInterest(String interest) 
	{
		this.interest = interest;
	}

	public String getInterest() 
	{
		return interest;
	}
	public void setCompensation(String compensation) 
	{
		this.compensation = compensation;
	}

	public String getCompensation() 
	{
		return compensation;
	}
	public void setWcName(String wcName) 
	{
		this.wcName = wcName;
	}

	public String getWcName() 
	{
		return wcName;
	}
	public void setWcHeadicon(String wcHeadicon) 
	{
		this.wcHeadicon = wcHeadicon;
	}

	public String getWcHeadicon() 
	{
		return wcHeadicon;
	}
	public void setWcId(String wcId) 
	{
		this.wcId = wcId;
	}

	public String getWcId() 
	{
		return wcId;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setExtend1(String extend1) 
	{
		this.extend1 = extend1;
	}

	public String getExtend1() 
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
            .append("questionnaireId", getQuestionnaireId())
            .append("name", getName())
            .append("age", getAge())
            .append("cause", getCause())
            .append("otherStudent", getOtherStudent())
            .append("whyChoose", getWhyChoose())
            .append("interest", getInterest())
            .append("compensation", getCompensation())
            .append("wcName", getWcName())
            .append("wcHeadicon", getWcHeadicon())
            .append("wcId", getWcId())
            .append("createTime", getCreateTime())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .toString();
    }
}
