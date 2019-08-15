package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 活动表 hd_activity
 * 
 * @author hp
 * @date 2019-05-31
 */
public class HdActivity extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 活动名称 */
	private String name;
	/** 活动开始时间 */
	private String start;
	/** 活动结束时间 */
	private String end;
	/** 活动介绍 */
	private String introduction;
	/** 活动封面（1图片，2视频） */
	private Integer cover;
	/** 页面样式主题 */
	private Integer theme;
	/** 是否允许报名（0否1是） */
	private Integer apply;
	/** 是否有分组（0否1是） */
	private Integer grouping;
	/** 排序规则 */
	private Integer sort;
	/** 背景音乐是否为外链（0否1是） */
	private Integer outsideChain;
	/** 音乐地址 */
	private String music;
	/** 是否启用活动公告 */
	private Integer isAnnouncement;
	/** 活动公告内容 */
	private String announcement;
	/** 报名审核（0否1需要） */
	private Integer audit;
	/** 投票设置 */
	private Integer sett;
	/** 一个微信号每天能投票数 */
	private Integer vote;
	/** 一个微信号该活动最多投票数 */
	private Integer maxVote;
	/** 防刷票（0不开启，1开启） */
	private Integer ballotRigging;
	/** 选手每小时最高得票数 */
	private Integer hourMax;
	/** 选手每天最高得票数 */
	private Integer dayMax;
	/** 投票时是否有验证码（0否1是） */
	private Integer verificationCode;
	/** 浏览量 */
	private Integer browse;
	/** 投票数 */
	private Integer sumVote;
	/** 报名数 */
	private Integer enroll;
	/** 创建人员编号 */
	private Integer createUser;
	/** 创建时间 */
	private Date createTime;
	/** 修改人员编号 */
	private Integer updateUser;
	/** 修改时间 */
	private Date updateTime;
	/**  */
	private Integer extend1;
	/**  */
	private Integer extend2;
	/**  */
	private Integer extend3;
	/**  */
	private String extend4;
	/**  */
	private String extend5;
	/** 选手数量 */
	private Integer players;
	/** 封面图片集合 */
	private  Object pics;
	/** 分组数据 */
	private Object groups;

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
	public void setStart(String start)
	{
		this.start = start;
	}

	public String getStart()
	{
		return start;
	}
	public void setEnd(String end)
	{
		this.end = end;
	}

	public String getEnd()
	{
		return end;
	}
	public void setIntroduction(String introduction) 
	{
		this.introduction = introduction;
	}

	public String getIntroduction() 
	{
		return introduction;
	}
	public void setCover(Integer cover) 
	{
		this.cover = cover;
	}

	public Integer getCover() 
	{
		return cover;
	}
	public void setTheme(Integer theme) 
	{
		this.theme = theme;
	}

	public Integer getTheme() 
	{
		return theme;
	}
	public void setApply(Integer apply) 
	{
		this.apply = apply;
	}

	public Integer getApply() 
	{
		return apply;
	}
	public void setGrouping(Integer grouping) 
	{
		this.grouping = grouping;
	}

	public Integer getGrouping() 
	{
		return grouping;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setOutsideChain(Integer outsideChain) 
	{
		this.outsideChain = outsideChain;
	}

	public Integer getOutsideChain() 
	{
		return outsideChain;
	}
	public void setMusic(String music) 
	{
		this.music = music;
	}

	public String getMusic() 
	{
		return music;
	}
	public void setIsAnnouncement(Integer isAnnouncement) 
	{
		this.isAnnouncement = isAnnouncement;
	}

	public Integer getIsAnnouncement() 
	{
		return isAnnouncement;
	}
	public void setAnnouncement(String announcement) 
	{
		this.announcement = announcement;
	}

	public String getAnnouncement() 
	{
		return announcement;
	}
	public void setAudit(Integer audit) 
	{
		this.audit = audit;
	}

	public Integer getAudit() 
	{
		return audit;
	}
	public void setSett(Integer sett)
	{
		this.sett = sett;
	}

	public Integer getSett()
	{
		return sett;
	}
	public void setVote(Integer vote) 
	{
		this.vote = vote;
	}

	public Integer getVote() 
	{
		return vote;
	}
	public void setMaxVote(Integer maxVote) 
	{
		this.maxVote = maxVote;
	}

	public Integer getMaxVote() 
	{
		return maxVote;
	}
	public void setBallotRigging(Integer ballotRigging) 
	{
		this.ballotRigging = ballotRigging;
	}

	public Integer getBallotRigging() 
	{
		return ballotRigging;
	}
	public void setHourMax(Integer hourMax) 
	{
		this.hourMax = hourMax;
	}

	public Integer getHourMax() 
	{
		return hourMax;
	}
	public void setDayMax(Integer dayMax) 
	{
		this.dayMax = dayMax;
	}

	public Integer getDayMax() 
	{
		return dayMax;
	}
	public void setVerificationCode(Integer verificationCode) 
	{
		this.verificationCode = verificationCode;
	}

	public Integer getVerificationCode() 
	{
		return verificationCode;
	}
	public void setBrowse(Integer browse) 
	{
		this.browse = browse;
	}

	public Integer getBrowse() 
	{
		return browse;
	}
	public void setSumVote(Integer sumVote) 
	{
		this.sumVote = sumVote;
	}

	public Integer getSumVote() 
	{
		return sumVote;
	}
	public void setEnroll(Integer enroll) 
	{
		this.enroll = enroll;
	}

	public Integer getEnroll() 
	{
		return enroll;
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
	public void setExtend1(Integer extend1)
	{
		this.extend1 = extend1;
	}

	public Integer getExtend1()
	{
		return extend1;
	}
	public void setExtend2(Integer extend2)
	{
		this.extend2 = extend2;
	}

	public Integer getExtend2()
	{
		return extend2;
	}
	public void setExtend3(Integer extend3)
	{
		this.extend3 = extend3;
	}

	public Integer getExtend3()
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
            .append("start", getStart())
            .append("end", getEnd())
            .append("introduction", getIntroduction())
            .append("cover", getCover())
            .append("theme", getTheme())
            .append("apply", getApply())
            .append("grouping", getGrouping())
            .append("sort", getSort())
            .append("outsideChain", getOutsideChain())
            .append("music", getMusic())
            .append("isAnnouncement", getIsAnnouncement())
            .append("announcement", getAnnouncement())
            .append("audit", getAudit())
            .append("sett", getSett())
            .append("vote", getVote())
            .append("maxVote", getMaxVote())
            .append("ballotRigging", getBallotRigging())
            .append("hourMax", getHourMax())
            .append("dayMax", getDayMax())
            .append("verificationCode", getVerificationCode())
            .append("browse", getBrowse())
            .append("sumVote", getSumVote())
            .append("enroll", getEnroll())
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

	public Integer getPlayers() {
		return players;
	}

	public void setPlayers(Integer players) {
		this.players = players;
	}

	public Object getPics() {
		return pics;
	}

	public void setPics(Object pics) {
		this.pics = pics;
	}

	public Object getGroups() {
		return groups;
	}

	public void setGroups(Object groups) {
		this.groups = groups;
	}
}
