package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 中奖记录表 hd_infogiftlog
 * 
 * @author hp
 * @date 2019-07-18
 */
public class HdInfogiftlog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Long id;
	/** 中奖人编号 */
	private Long infoId;
	/** 奖品名称 */
	private String giftName;
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
	/** 中奖人名称 */
	private String name;
	/** 开始时间 */
	private String start;
	/** 结束时间 */
	private String end;
	private String time;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setInfoId(Long infoId) 
	{
		this.infoId = infoId;
	}

	public Long getInfoId() 
	{
		return infoId;
	}
	public void setGiftName(String giftName) 
	{
		this.giftName = giftName;
	}

	public String getGiftName() 
	{
		return giftName;
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
            .append("infoId", getInfoId())
            .append("giftName", getGiftName())
            .append("createTime", getCreateTime())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .toString();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
