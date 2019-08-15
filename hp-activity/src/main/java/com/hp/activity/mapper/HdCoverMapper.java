package com.hp.activity.mapper;

import com.hp.activity.domain.HdCover;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 活动封面 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-05-31
 */
@MapperScan
public interface HdCoverMapper  extends BaseMapper<HdCover>
{
	/**
     * 查询活动封面信息
     * 
     * @param id 活动封面ID
     * @return 活动封面信息
     */
	public HdCover selectHdCoverById(Integer id);
	
	/**
     * 查询活动封面列表
     * 
     * @param hdCover 活动封面信息
     * @return 活动封面集合
     */
	public List<HdCover> selectHdCoverList(HdCover hdCover);
	
	/**
     * 新增活动封面
     * 
     * @param hdCover 活动封面信息
     * @return 结果
     */
	public int insertHdCover(HdCover hdCover);
	
	/**
     * 修改活动封面
     * 
     * @param hdCover 活动封面信息
     * @return 结果
     */
	public int updateHdCover(HdCover hdCover);
	
	/**
     * 删除活动封面
     * 
     * @param id 活动封面ID
     * @return 结果
     */
	public int deleteHdCoverById(Integer id);
	
	/**
     * 批量删除活动封面
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHdCoverByIds(HdCover hdCover);
	
}