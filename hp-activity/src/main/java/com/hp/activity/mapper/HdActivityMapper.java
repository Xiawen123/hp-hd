package com.hp.activity.mapper;

import com.hp.activity.domain.HdActivity;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 活动 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-05-31
 */
@MapperScan
public interface HdActivityMapper  extends BaseMapper<HdActivity>
{
	/**
     * 查询活动信息
     * 
     * @param id 活动ID
     * @return 活动信息
     */
	public HdActivity selectHdActivityById(Integer id);
	
	/**
     * 查询活动列表
     * 
     * @param hdActivity 活动信息
     * @return 活动集合
     */
	public List<HdActivity> selectHdActivityList(HdActivity hdActivity);

	List<HdActivity> selectHotActivity();
	
	/**
     * 新增活动
     * 
     * @param hdActivity 活动信息
     * @return 结果
     */
	public int insertHdActivity(HdActivity hdActivity);
	
	/**
     * 修改活动
     * 
     * @param hdActivity 活动信息
     * @return 结果
     */
	public int updateHdActivity(HdActivity hdActivity);
	
	/**
     * 删除活动
     * 
     * @param id 活动ID
     * @return 结果
     */
	public int deleteHdActivityById(Integer id);
	
	/**
     * 批量删除活动
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdActivityByIds(String[] ids);

	int selectMaxId();

	int updateTicket(Integer id);

	int getHotActivity();
	
}