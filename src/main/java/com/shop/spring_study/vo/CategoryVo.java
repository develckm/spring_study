package com.shop.spring_study.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.JoinFormula;

//cate_num | int(11)
//name     | varchar(255)
//sub      | int(11)
@Entity
@Table(name="category")
public class CategoryVo {
	@Id
	private int cate_num;
	private String name;
	private Integer sub;
	@OneToOne()
	@JoinColumn(name = "sub",referencedColumnName = "cate_num", insertable = false, updatable = false)
	private CategoryVo sub_cate;
	
	public CategoryVo getSub_cate() {
		return sub_cate;
	}
	public void setSub_cate(CategoryVo sub_cate) {
		this.sub_cate = sub_cate;
	}
	public int getCate_num() {
		return cate_num;
	}
	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSub() {
		return sub;
	}
	public void setSub(Integer sub) {
		this.sub = sub;
	}
	public String toString() {
		return "CategoryVo [cate_num=" + cate_num + ", name=" + name + ", sub=" + sub + "]";
	}
}
