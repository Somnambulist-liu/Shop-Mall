package com.edu.shopapi.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.edu.shopapi.entity.Product;

/**
 * 商品表(Product)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Mapper
public interface ProductDao extends BaseMapper<Product> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<Product> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<Product> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<Product> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<Product> entities);

}

