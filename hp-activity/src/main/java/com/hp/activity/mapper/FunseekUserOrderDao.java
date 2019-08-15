package com.hp.activity.mapper;


import com.hp.activity.domain.FunseekUserOrder;
import com.hp.common.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

@MapperScan
public interface FunseekUserOrderDao extends BaseMapper<FunseekUserOrder> {

    /**
     * 查询出所有的数据
     *
     * @return 分页数据
     */
    List<Map<String,Object>> list(Page<Map<String, Object>> page, Map<String, Object> params);

    /**
     * 根据订单号查询信息
     *
     * @param order_id 订单号
     * @return 结果
     */
    FunseekUserOrder getByOrderId(@Param("order_id") String order_id);

    /**
     * 写入实体
     *
     * @param funseekUserOrder 订单实体
     * @return 写入的行数
     */
    Integer insertEntity(FunseekUserOrder funseekUserOrder);
}