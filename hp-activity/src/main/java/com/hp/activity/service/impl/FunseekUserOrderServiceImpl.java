package com.hp.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.FunseekUserOrderMapper;
import com.hp.activity.domain.FunseekUserOrder;
import com.hp.activity.service.IFunseekUserOrderService;
import com.hp.common.support.Convert;

/**
 * 用户支付订单记录 服务层实现
 * 
 * @author hp
 * @date 2019-06-28
 */
@Service
public class FunseekUserOrderServiceImpl implements IFunseekUserOrderService 
{
	@Autowired
	private FunseekUserOrderMapper funseekUserOrderMapper;

	/**
     * 查询用户支付订单记录信息
     * 
     * @param id 用户支付订单记录ID
     * @return 用户支付订单记录信息
     */
    @Override
	public FunseekUserOrder selectFunseekUserOrderById(Long id)
	{
	    return funseekUserOrderMapper.selectFunseekUserOrderById(id);
	}
	
	/**
     * 查询用户支付订单记录列表
     * 
     * @param funseekUserOrder 用户支付订单记录信息
     * @return 用户支付订单记录集合
     */
	@Override
	public List<FunseekUserOrder> selectFunseekUserOrderList(FunseekUserOrder funseekUserOrder)
	{
	    return funseekUserOrderMapper.selectFunseekUserOrderList(funseekUserOrder);
	}
	
    /**
     * 新增用户支付订单记录
     * 
     * @param funseekUserOrder 用户支付订单记录信息
     * @return 结果
     */
	@Override
	public int insertFunseekUserOrder(FunseekUserOrder funseekUserOrder)
	{
	    return funseekUserOrderMapper.insertFunseekUserOrder(funseekUserOrder);
	}
	
	/**
     * 修改用户支付订单记录
     * 
     * @param funseekUserOrder 用户支付订单记录信息
     * @return 结果
     */
	@Override
	public int updateFunseekUserOrder(FunseekUserOrder funseekUserOrder)
	{
	    return funseekUserOrderMapper.updateFunseekUserOrder(funseekUserOrder);
	}

	/**
     * 删除用户支付订单记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFunseekUserOrderByIds(String ids)
	{
		return funseekUserOrderMapper.deleteFunseekUserOrderByIds(Convert.toStrArray(ids));
	}
	
}
