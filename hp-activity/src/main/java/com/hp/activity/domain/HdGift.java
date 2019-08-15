package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 礼物表 hd_gift
 * 
 * @author hp
 * @date 2019-05-31
 */
public class HdGift extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 礼物名称 */
	private String name;
	/** 礼物图标 */
	private String icon;
	/** 礼物价格 */
	private Double price;
	/** 票数 */
	private Integer ticket;
	/** 创建人员编号 */
	private Integer createUser;
	private String userName;
	/** 创建时间 */
	private Date createTime;
	/** 修改人员编号 */
	private Integer updateUser;
	/** 修改时间 */
	private Date updateTime;
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

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
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
	public void setPrice(Double price) 
	{
		this.price = price;
	}

	public Double getPrice() 
	{
		return price;
	}
	public void setTicket(Integer ticket) 
	{
		this.ticket = ticket;
	}

	public Integer getTicket() 
	{
		return ticket;
	}
	public void setCreateUser(Integer createUser) 
	{
		this.createUser = createUser;
	}

	public Integer getCreateUser() 
	{
		return createUser;
	}
	@Override
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	@Override
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setUpdateUser(Integer updateUser) 
	{
		this.updateUser = updateUser;
	}

	public Integer getUpdateUser() 
	{
		return updateUser;
	}
	@Override
	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	@Override
	public Date getUpdateTime()
	{
		return updateTime;
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
            .append("name", getName())
            .append("icon", getIcon())
            .append("price", getPrice())
            .append("ticket", getTicket())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .toString();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
