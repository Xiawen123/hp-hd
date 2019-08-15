package com.hp.activity.service;

import com.hp.activity.domain.HdPlayerImg;
import java.util.List;

/**
 * 选手图片 服务层
 * 
 * @author hp
 * @date 2019-05-31
 */
public interface IHdPlayerImgService 
{
	/**
     * 查询选手图片信息
     * 
     * @param id 选手图片ID
     * @return 选手图片信息
     */
	public HdPlayerImg selectHdPlayerImgById(Integer id);
	
	/**
     * 查询选手图片列表
     * 
     * @param hdPlayerImg 选手图片信息
     * @return 选手图片集合
     */
	public List<HdPlayerImg> selectHdPlayerImgList(HdPlayerImg hdPlayerImg);
	
	/**
     * 新增选手图片
     * 
     * @param hdPlayerImg 选手图片信息
     * @return 结果
     */
	public int insertHdPlayerImg(HdPlayerImg hdPlayerImg);
	
	/**
     * 修改选手图片
     * 
     * @param hdPlayerImg 选手图片信息
     * @return 结果
     */
	public int updateHdPlayerImg(HdPlayerImg hdPlayerImg);
		
	/**
     * 删除选手图片信息
     * 
     * @return 结果
     */
	public int deleteHdPlayerImgByIds(HdPlayerImg hdPlayerImg);
	
}
