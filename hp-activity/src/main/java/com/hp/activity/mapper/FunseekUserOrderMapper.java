package com.hp.activity.mapper;

import com.hp.activity.domain.FunseekUserOrder;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import com.hp.common.base.BaseMapper;

/**
 * 用户支付订单记录 数据层
 * 集成BaseMapper 长用的方式可以共用
 * @author hp
 * @date 2019-06-28
 */
@MapperScan
public interface FunseekUserOrderMapper  extends BaseMapper<FunseekUserOrder>
{
	/**
     * 查询用户支付订单记录信息
     * 
     * @param id 用户支付订单记录ID
     * @return 用户支付订单记录信息
     */
	public FunseekUserOrder selectFunseekUserOrderById(Long id);
	
	/**
     * 查询用户支付订单记录列表
     * 
     * @param funseekUserOrder 用户支付订单记录信息
     * @return 用户支付订单记录集合
     */
	public List<FunseekUserOrder> selectFunseekUserOrderList(FunseekUserOrder funseekUserOrder);
	
	/**
     * 新增用户支付订单记录
     * 
     * @param funseekUserOrder 用户支付订单记录信息
     * @return 结果
     */
	public int insertFunseekUserOrder(FunseekUserOrder funseekUserOrder);
	
	/**
     * 修改用户支付订单记录
     * 
     * @param funseekUserOrder 用户支付订单记录信息
     * @return 结果
     */
	public int updateFunseekUserOrder(FunseekUserOrder funseekUserOrder);
	
	/**
     * 删除用户支付订单记录
     * 
     * @param id 用户支付订单记录ID
     * @return 结果
     */
	public int deleteFunseekUserOrderById(Long id);
	
	/**
     * 批量删除用户支付订单记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFunseekUserOrderByIds(String[] ids);
	
}