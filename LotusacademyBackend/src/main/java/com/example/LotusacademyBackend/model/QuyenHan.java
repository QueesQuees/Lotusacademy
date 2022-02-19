package com.example.LotusacademyBackend.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class QuyenHan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quyenHanID;
	
	@Column
	@Size(max = 50)
	private String tenQuyenHan;
	
	@OneToMany(mappedBy = "quyenHan", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("quyenHan")
	private Collection<TaiKhoan> taiKhoans;

	public int getQuyenHanID() {
		return quyenHanID;
	}

	public void setQuyenHanID(int quyenHanID) {
		this.quyenHanID = quyenHanID;
	}

	public String getTenQuyenHan() {
		return tenQuyenHan;
	}

	public void setTenQuyenHan(String tenQuyenHan) {
		this.tenQuyenHan = tenQuyenHan;
	}

	public Collection<TaiKhoan> getTaiKhoans() {
		return taiKhoans;
	}

	public void setTaiKhoans(Collection<TaiKhoan> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}	
	
}
