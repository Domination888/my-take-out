package com.sky.service;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {

    //保存套餐
    void save(SetmealVO setmealVO);

    //分页查询
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    //根据id查询套餐
    SetmealVO getById(Long id);

    //修改套餐
    void update(SetmealVO setmealVO);

    //批量删除套餐
    void startOrStop(Integer status, Long id);

    //批量删除套餐
    void deleteBatch(List<Long> ids);
}
