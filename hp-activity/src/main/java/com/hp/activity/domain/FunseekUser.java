package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 注册用户表 funseek_user
 * 
 * @author hp
 * @date 2019-06-28
 */
public class FunseekUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键，使用bigint，不使用自增长，避免分布式同步问题，同时使用雪花算法生成主键值 */
	@Id
	private Long id;
	/** 注册账号：手机号，固定，不允许采用其他账号形式 */
	private String userAccount;
	/** 登录密码，MD5或RAS加密 */
	private String userPassword;
	/** 用户昵称（允许用户使用昵称） */
	private String nickname;
	/** 用户的微信账号（仅限微信小程序使用） */
	private String wechatAccount;
	/** 用户的微信昵称（仅限微信小程序使用） */
	private String wechatNickname;
	/** 用户注册时的所在地（仅限小程序使用） */
	private String registAddress;
	/** 用户账户余额（采用整数形式，直接存储到分，比如1元，则存储为100，就是1元0角0分） */
	private Integer accountBalance;
	/** 账号状态（1：正常，2：暂时禁用，指定禁用时长，3：永久禁用，4：用户已销户 */
	private String accountState;
	/** 如果账号被禁用，需要输入禁用原因，如用户发布不良信息，注水，肆意打广告等等 */
	private String accountLimitReason;
	/** 如果账号被禁用，且不是永久禁用或注销，则需要指定禁用时长 */
	private Date accountLimitTime;
	/** 最后登录时间 */
	private Date lastLoginTime;
	/** 最后登录地址 */
	private String lastLoginAddress;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 扩展字段 */
	private String extend1;
	/** 扩展字段2 */
	private String extend2;
	/** 扩展字段3 */
	private String extend3;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setUserAccount(String userAccount) 
	{
		this.userAccount = userAccount;
	}

	public String getUserAccount() 
	{
		return userAccount;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}

	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}

	public String getNickname() 
	{
		return nickname;
	}
	public void setWechatAccount(String wechatAccount) 
	{
		this.wechatAccount = wechatAccount;
	}

	public String getWechatAccount() 
	{
		return wechatAccount;
	}
	public void setWechatNickname(String wechatNickname) 
	{
		this.wechatNickname = wechatNickname;
	}

	public String getWechatNickname() 
	{
		return wechatNickname;
	}
	public void setRegistAddress(String registAddress) 
	{
		this.registAddress = registAddress;
	}

	public String getRegistAddress() 
	{
		return registAddress;
	}
	public void setAccountBalance(Integer accountBalance) 
	{
		this.accountBalance = accountBalance;
	}

	public Integer getAccountBalance() 
	{
		return accountBalance;
	}
	public void setAccountState(String accountState) 
	{
		this.accountState = accountState;
	}

	public String getAccountState() 
	{
		return accountState;
	}
	public void setAccountLimitReason(String accountLimitReason) 
	{
		this.accountLimitReason = accountLimitReason;
	}

	public String getAccountLimitReason() 
	{
		return accountLimitReason;
	}
	public void setAccountLimitTime(Date accountLimitTime) 
	{
		this.accountLimitTime = accountLimitTime;
	}

	public Date getAccountLimitTime() 
	{
		return accountLimitTime;
	}
	public void setLastLoginTime(Date lastLoginTime) 
	{
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginTime() 
	{
		return lastLoginTime;
	}
	public void setLastLoginAddress(String lastLoginAddress) 
	{
		this.lastLoginAddress = lastLoginAddress;
	}

	public String getLastLoginAddress() 
	{
		return lastLoginAddress;
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
            .append("userAccount", getUserAccount())
            .append("userPassword", getUserPassword())
            .append("nickname", getNickname())
            .append("wechatAccount", getWechatAccount())
            .append("wechatNickname", getWechatNickname())
            .append("registAddress", getRegistAddress())
            .append("accountBalance", getAccountBalance())
            .append("accountState", getAccountState())
            .append("accountLimitReason", getAccountLimitReason())
            .append("accountLimitTime", getAccountLimitTime())
            .append("lastLoginTime", getLastLoginTime())
            .append("lastLoginAddress", getLastLoginAddress())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .toString();
    }
}
