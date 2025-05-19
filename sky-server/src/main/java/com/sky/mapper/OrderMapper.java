package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersRejectionDTO;
import com.sky.entity.Orders;
import com.sky.vo.OrderVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {
    //保存订单
    void insert(Orders orders);

    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 用于替换微信支付更新数据库状态的问题
     * @param orderStatus
     * @param orderPaidStatus
     */
    @Update("update orders set status = #{orderStatus},pay_status = #{orderPaidStatus} ,checkout_time = #{check_out_time} " +
            "where number = #{orderNumber}")
    void updateStatus(Integer orderStatus, Integer orderPaidStatus, LocalDateTime check_out_time, String orderNumber);

    /**
     * 订单分页查询
     * @param ordersPageQueryDTO
     * @return
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    OrderVO getOrderDetail(Long id);

    /**
     * 用户取消订单
     * @param id
     */
    @Update("update orders set status = 6 where id = #{id}")
    void cancel(Long id);

    /**
     * 统计各状态的订单数量
     * @return
     */
    @Select("select count(id) from orders where status = #{status}")
    Integer countByStatus(Integer status);

    /**
     * 接单
     * @param id
     */
    @Update("update orders set status = 3 where id = #{id}")
    void confirm(Long id);

    /**
     * 拒单
     * @param ordersRejectionDTO
     */
    @Update("update orders set status = 6, rejection_reason = #{rejectionReason} where id = #{id}")
    void rejection(OrdersRejectionDTO ordersRejectionDTO);

    /**
     * 取消订单带原因
     * @param ordersCancelDTO
     */
    @Update("update orders set status = 6, cancel_reason = #{cancelReason} where id = #{id}")
    void cancelWithReason(OrdersCancelDTO ordersCancelDTO);

    /**
     * 派送订单
     * @param id
     */
    @Update("update orders set status = 4 where id = #{id}")
    void delivery(Long id);

    /**
     * 完成订单
     * @param id
     */
    @Update("update orders set status = 5 where id = #{id}")
    void complete(Long id);

    /**
     * 条件搜索
     * @param ordersPageQueryDTO
     * @return
     */
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status, LocalDateTime orderTime);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);
}
