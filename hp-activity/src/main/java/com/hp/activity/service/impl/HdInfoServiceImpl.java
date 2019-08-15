package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdInfoMapper;
import com.hp.activity.domain.HdInfo;
import com.hp.activity.service.IHdInfoService;
import com.hp.common.support.Convert;

/**
 * 学员调查问卷内容 服务层实现
 * 
 * @author hp
 * @date 2019-07-16
 */
@Service
public class HdInfoServiceImpl implements IHdInfoService 
{
	@Autowired
	private HdInfoMapper hdInfoMapper;

	/**
     * 查询学员调查问卷内容信息
     * 
     * @param id 学员调查问卷内容ID
     * @return 学员调查问卷内容信息
     */
    @Override
	public HdInfo selectHdInfoById(Long id)
	{
	    return hdInfoMapper.selectHdInfoById(id);
	}
	
	/**
     * 查询学员调查问卷内容列表
     * 
     * @param hdInfo 学员调查问卷内容信息
     * @return 学员调查问卷内容集合
     */
	@Override
	public List<HdInfo> selectHdInfoList(HdInfo hdInfo)
	{
	    return hdInfoMapper.selectHdInfoList(hdInfo);
	}
	
    /**
     * 新增学员调查问卷内容
     * 
     * @param hdInfo 学员调查问卷内容信息
     * @return 结果
     */
	@Override
	public int insertHdInfo(HdInfo hdInfo)
	{
	    return hdInfoMapper.insertHdInfo(hdInfo);
	}
	
	/**
     * 修改学员调查问卷内容
     * 
     * @param hdInfo 学员调查问卷内容信息
     * @return 结果
     */
	@Override
	public int updateHdInfo(HdInfo hdInfo)
	{
	    return hdInfoMapper.updateHdInfo(hdInfo);
	}

	/**
     * 删除学员调查问卷内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHdInfoByIds(String ids)
	{
		return hdInfoMapper.deleteHdInfoByIds(Convert.toStrArray(ids));
	}

	@Override
	public int selectCount(HdInfo hdInfo){
		return hdInfoMapper.selectCount(hdInfo);
	}
	
}
