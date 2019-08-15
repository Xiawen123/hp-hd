package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 用户支付订单记录表 funseek_user_order
 * 
 * @author hp
 * @date 2019-06-28
 */
public class FunseekUserOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	@Id
	private Long id;
	/** 本系统订单号（对应微信支付系统商户订单号） */
	private String orderId;
	/** 用户ID，关联ID，不关联用户账号 */
	private Long userId;
	/** 支付总额：精确到分，保存整数 */
	private Integer totalFee;
	/** 支付方式：对应三种 1微信支付，2支付宝支付 3银联支付 */
	private String payWay;
	/** 订单状态：0 已作废 1 正常 */
	private String orderState;
	/** 用户支付状态：0 未支付 1 已支付 */
	private String payState;
	/** 支付平台回调确认：0 未确认 1 已确认成功 2 已确认失败 */
	private String notifyState;
	/** 回调失败时的错误信息 */
	private String notifyError;
	/** 退款状态：0 未发起 1 退款中 2 退款成功 3 退款失败 */
	private String refundState;
	/** 退款失败时的错误信息 */
	private String refundError;
	/** 下单时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/**  */
	private String extend1;
	/**  */
	private String extend2;
	/**  */
	private String extend3;

	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setOrderId(String orderId) 
	{
		this.orderId = orderId;
	}

	public String getOrderId() 
	{
		return orderId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setTotalFee(Integer totalFee) 
	{
		this.totalFee = totalFee;
	}

	public Integer getTotalFee() 
	{
		return totalFee;
	}
	public void setPayWay(String payWay) 
	{
		this.payWay = payWay;
	}

	public String getPayWay() 
	{
		return payWay;
	}
	public void setOrderState(String orderState) 
	{
		this.orderState = orderState;
	}

	public String getOrderState() 
	{
		return orderState;
	}
	public void setPayState(String payState) 
	{
		this.payState = payState;
	}

	public String getPayState() 
	{
		return payState;
	}
	public void setNotifyState(String notifyState) 
	{
		this.notifyState = notifyState;
	}

	public String getNotifyState() 
	{
		return notifyState;
	}
	public void setNotifyError(String notifyError) 
	{
		this.notifyError = notifyError;
	}

	public String getNotifyError() 
	{
		return notifyError;
	}
	public void setRefundState(String refundState) 
	{
		this.refundState = refundState;
	}

	public String getRefundState() 
	{
		return refundState;
	}
	public void setRefundError(String refundError) 
	{
		this.refundError = refundError;
	}

	public String getRefundError() 
	{
		return refundError;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("userId", getUserId())
            .append("totalFee", getTotalFee())
            .append("payWay", getPayWay())
            .append("orderState", getOrderState())
            .append("payState", getPayState())
            .append("notifyState", getNotifyState())
            .append("notifyError", getNotifyError())
            .append("refundState", getRefundState())
            .append("refundError", getRefundError())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .toString();
    }
}
