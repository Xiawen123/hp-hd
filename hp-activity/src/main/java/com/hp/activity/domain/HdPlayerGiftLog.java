package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 礼物记录表 hd_player_gift_log
 * 
 * @author hp
 * @date 2019-05-31
 */
public class HdPlayerGiftLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 选手名称 */
	private String playerName;
	/** 选手编号 */
	private Integer playerId;
	/** 创建人员编号 */
	private Integer createUser;
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
	/** 礼物编号 */
	private Integer giftId;
	/** 礼物名称 */
	private String giftName;
	/** 礼物数量 */
	private Integer quantity;
	/** 礼物总价值 */
	private Double amount;
	/** 礼物总票数 */
	private Integer ticket;
	/** 活动表id */
	private Integer activityId;
	private Integer zps;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setPlayerId(Integer playerId) 
	{
		this.playerId = playerId;
	}

	public Integer getPlayerId() 
	{
		return playerId;
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
	public void setGiftId(Integer giftId) 
	{
		this.giftId = giftId;
	}

	public Integer getGiftId() 
	{
		return giftId;
	}
	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}
	public void setAmount(Double amount) 
	{
		this.amount = amount;
	}

	public Double getAmount() 
	{
		return amount;
	}
	public void setTicket(Integer ticket) 
	{
		this.ticket = ticket;
	}

	public Integer getTicket() 
	{
		return ticket;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("playerId", getPlayerId())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .append("giftId", getGiftId())
            .append("quantity", getQuantity())
            .append("amount", getAmount())
            .append("ticket", getTicket())
            .toString();
    }

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getZps() {
		return zps;
	}

	public void setZps(Integer zps) {
		this.zps = zps;
	}
}
