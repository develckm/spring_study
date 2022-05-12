package com.shop.spring_study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shop.spring_study.vo.CategoryVo;

public interface CateRepository extends CrudRepository<CategoryVo, Integer>{
	@Query(value = "SELECT cate FROM CategoryVo cate")
	public List<CategoryVo> selectAllJPQL();
}
