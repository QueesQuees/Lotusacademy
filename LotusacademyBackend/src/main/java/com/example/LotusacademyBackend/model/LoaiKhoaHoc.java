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

@Entity
@Table
public class LoaiKhoaHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loaiKhoaHocID;
	
	@Column
	@Size(max = 30)
	private String tenLoai;
	
	@OneToMany(mappedBy = "loaiKhoaHoc", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("loaiKhoaHoc")
	private Collection<KhoaHoc> khoaHocs;

	public int getLoaiKhoaHocID() {
		return loaiKhoaHocID;
	}

	public void setLoaiKhoaHocID(int loaiKhoaHocID) {
		this.loaiKhoaHocID = loaiKhoaHocID;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public Collection<KhoaHoc> getKhoaHocs() {
		return khoaHocs;
	}

	public void setKhoaHocs(Collection<KhoaHoc> khoaHocs) {
		this.khoaHocs = khoaHocs;
	}
	
	
}
