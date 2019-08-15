package com.hp.activity.domain;

import com.hp.common.annotation.Excel;
import com.hp.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 选手表 hd_player
 * 
 * @author hp
 * @date 2019-05-31
 */
public class HdPlayer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	private Integer i;
	/** 选手名称 */
	private String name;
	/** 活动表id */
	private Integer activityId;
	/** 选手联系电话 */
	private String tel;
	/** 分组表id */
	private String groupId;
	/** 分组名称 */
	private String groupName;
	/** 头像 */
	private String headIcon;
	/** 封面 */
	private String coverImg;
	/** 视频 */
	private String video;
	/** 音频 */
	private String voice;
	/** 选手描述 */
	private String describes;
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
	/** 票数 */
	private Integer ticket;
	/** 礼物数量 */
	private Integer gift;
	/** 浏览量 */
	private Integer browse;
	/** 选手照片集合 */
	private  Object pics;

	private Integer sort;

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
	public void setActivityId(Integer activityId) 
	{
		this.activityId = activityId;
	}

	public Integer getActivityId() 
	{
		return activityId;
	}
	public void setTel(String tel) 
	{
		this.tel = tel;
	}

	public String getTel() 
	{
		return tel;
	}
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}

	public String getGroupId()
	{
		return groupId;
	}
	public void setHeadIcon(String headIcon) 
	{
		this.headIcon = headIcon;
	}

	public String getHeadIcon() 
	{
		return headIcon;
	}
	public void setCoverImg(String coverImg) 
	{
		this.coverImg = coverImg;
	}

	public String getCoverImg() 
	{
		return coverImg;
	}
	public void setVideo(String video) 
	{
		this.video = video;
	}

	public String getVideo() 
	{
		return video;
	}
	public void setVoice(String voice) 
	{
		this.voice = voice;
	}

	public String getVoice() 
	{
		return voice;
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
	public void setTicket(Integer ticket) 
	{
		this.ticket = ticket;
	}

	public Integer getTicket() 
	{
		return ticket;
	}
	public void setGift(Integer gift) 
	{
		this.gift = gift;
	}

	public Integer getGift() 
	{
		return gift;
	}
	public void setBrowse(Integer browse) 
	{
		this.browse = browse;
	}

	public Integer getBrowse() 
	{
		return browse;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("activityId", getActivityId())
            .append("tel", getTel())
            .append("groupId", getGroupId())
            .append("headIcon", getHeadIcon())
            .append("coverImg", getCoverImg())
            .append("video", getVideo())
            .append("voice", getVoice())
            .append("describes", getDescribes())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .append("ticket", getTicket())
            .append("gift", getGift())
            .append("browse", getBrowse())
            .toString();
    }

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public Object getPics() {
		return pics;
	}

	public void setPics(Object pics) {
		this.pics = pics;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
