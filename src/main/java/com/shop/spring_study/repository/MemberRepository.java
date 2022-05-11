package com.shop.spring_study.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shop.spring_study.vo.MemberVo;

//CrudRepository를 상속하는 인터페이스를 생성해야 JAP가 query를 작성할 수 있다.  
public interface MemberRepository extends CrudRepository<MemberVo, String> {
	//함수명이 질의로 작성가능
	//return type이 Collection 이면 복수의 select 
	public List<MemberVo> findAllByOrderByIdAsc();
	public MemberVo findByIdAndPw(String id,String pw);
}




