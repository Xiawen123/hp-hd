package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdPlayerImgMapper;
import com.hp.activity.domain.HdPlayerImg;
import com.hp.activity.service.IHdPlayerImgService;
import com.hp.common.support.Convert;

/**
 * 选手图片 服务层实现
 * 
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdPlayerImgServiceImpl implements IHdPlayerImgService 
{
	@Autowired
	private HdPlayerImgMapper hdPlayerImgMapper;

	/**
     * 查询选手图片信息
     * 
     * @param id 选手图片ID
     * @return 选手图片信息
     */
    @Override
	public HdPlayerImg selectHdPlayerImgById(Integer id)
	{
	    return hdPlayerImgMapper.selectHdPlayerImgById(id);
	}
	
	/**
     * 查询选手图片列表
     * 
     * @param hdPlayerImg 选手图片信息
     * @return 选手图片集合
     */
	@Override
	public List<HdPlayerImg> selectHdPlayerImgList(HdPlayerImg hdPlayerImg)
	{
	    return hdPlayerImgMapper.selectHdPlayerImgList(hdPlayerImg);
	}
	
    /**
     * 新增选手图片
     * 
     * @param hdPlayerImg 选手图片信息
     * @return 结果
     */
	@Override
	public int insertHdPlayerImg(HdPlayerImg hdPlayerImg)
	{
	    return hdPlayerImgMapper.insertHdPlayerImg(hdPlayerImg);
	}
	
	/**
     * 修改选手图片
     * 
     * @param hdPlayerImg 选手图片信息
     * @return 结果
     */
	@Override
	public int updateHdPlayerImg(HdPlayerImg hdPlayerImg)
	{
	    return hdPlayerImgMapper.updateHdPlayerImg(hdPlayerImg);
	}

	/**
     * 删除选手图片对象
     * 
     * @return 结果
     */
	@Override
	public int deleteHdPlayerImgByIds(HdPlayerImg hdPlayerImg)
	{
		return hdPlayerImgMapper.deleteHdPlayerImgByIds(hdPlayerImg);
	}
	
}
