package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    //新增分类
    @Insert("insert into category (type, name, sort, create_time, update_time, create_user, update_user, status) " +
            "values " +
            "(#{type}, #{name}, #{sort}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{status})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Category category);
    //分页查询
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
    //删除分类
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);
    //修改分类
    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);
    //查询分类
    List<Category> list(Integer type);
}
