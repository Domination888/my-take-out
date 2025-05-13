package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return
     */
    List<Long> getmealIdsByDishIds(List<Long> dishIds);

    /**
     * 批量插入套餐菜品关系数据
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id查询套餐菜品关系
     * @param id
     * @return
     */
    List<SetmealDish> getBySetmealId(Long setmealId);

    // 根据套餐id删除套餐菜品关系数据
    @Delete("delete from setmeal_dish where setmeal_id = #{id}")
    void deleteBySetmealId(Long id);

    // 批量删除套餐菜品关系数据
    void deleteBySetmealIds(List<Long> ids);
}
