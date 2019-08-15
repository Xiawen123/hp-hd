package com.hp.activity.service;

import com.hp.activity.domain.HdActivity;
import java.util.List;

/**
 * 活动 服务层
 * 
 * @author hp
 * @date 2019-05-31
 */
public interface IHdActivityService 
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
     * 删除活动信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdActivityByIds(String ids);

	int selectCount(HdActivity hdActivity);

	int selectMaxId();

	int updateTicket(Integer id);

	int getHotActivity();
}
