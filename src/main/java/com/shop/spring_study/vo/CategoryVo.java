package com.shop.spring_study.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//cate_num | int(11)
//name     | varchar(255)
//sub      | int(11)
@Entity
@Table(name="category")
public class CategoryVo {
	@Id
	private int cate_num;
	private String name;
	@Column( insertable = false, updatable = false)
	private Integer sub;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub",referencedColumnName = "cate_num", insertable = false, updatable = false)
	private CategoryVo sub_cate;
//	@OneToOne(mappedBy = "sub_cate",fetch = FetchType.LAZY)
//	@JoinColumn(table="sub_cate",name = "sub",referencedColumnName = "cate_num", insertable = false, updatable = false)
//	private CategoryVo detail_cate;
//
//	public CategoryVo getDetail_cate() {
//		return detail_cate;
//	}
//	public void setDetail_cate(CategoryVo detail_cate) {
//		this.detail_cate = detail_cate;
//	}
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
