package com.hp.activity.service;

import com.hp.activity.domain.HdInfo;
import java.util.List;

/**
 * 学员调查问卷内容 服务层
 * 
 * @author hp
 * @date 2019-07-16
 */
public interface IHdInfoService 
{
	/**
     * 查询学员调查问卷内容信息
     * 
     * @param id 学员调查问卷内容ID
     * @return 学员调查问卷内容信息
     */
	public HdInfo selectHdInfoById(Long id);
	
	/**
     * 查询学员调查问卷内容列表
     * 
     * @param hdInfo 学员调查问卷内容信息
     * @return 学员调查问卷内容集合
     */
	public List<HdInfo> selectHdInfoList(HdInfo hdInfo);
	
	/**
     * 新增学员调查问卷内容
     * 
     * @param hdInfo 学员调查问卷内容信息
     * @return 结果
     */
	public int insertHdInfo(HdInfo hdInfo);
	
	/**
     * 修改学员调查问卷内容
     * 
     * @param hdInfo 学员调查问卷内容信息
     * @return 结果
     */
	public int updateHdInfo(HdInfo hdInfo);
		
	/**
     * 删除学员调查问卷内容信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdInfoByIds(String ids);

	int selectCount(HdInfo hdInfo);
}
