package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    //动态条件查询
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    //更新商品数量
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    //新增到购物车
    @Insert("insert into shopping_cart (name, image, dish_id, setmeal_id, dish_flavor, number, create_time, user_id, amount) " +
            "values (#{name}, #{image}, #{dishId}, #{setmealId}, #{dishFlavor}, #{number}, #{createTime}, #{userId}, #{amount})")
    void insert(ShoppingCart shoppingCart);

    //根据用户id删除
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);

    //根据id删除
    @Delete("delete from shopping_cart where id = #{id}")
    void deleteById(Long id);
}
