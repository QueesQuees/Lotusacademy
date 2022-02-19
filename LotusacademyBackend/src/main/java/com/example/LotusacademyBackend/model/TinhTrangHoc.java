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
public class TinhTrangHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tinhTrangHocID;
	
	@Column
	@Size(max = 40)
	private String tenTinhTrang;
	
	@OneToMany(mappedBy = "tinhTrangHoc",cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "tinhTrangHoc")
	//@JsonManagedReference
	private Collection<DangKyHoc> dangKyHocs;

	public int getTinhTrangHocID() {
		return tinhTrangHocID;
	}

	public void setTinhTrangHocID(int tinhTrangHocID) {
		this.tinhTrangHocID = tinhTrangHocID;
	}

	public String getTenTinhTrang() {
		return tenTinhTrang;
	}

	public void setTenTinhTrang(String tenTinhTrang) {
		this.tenTinhTrang = tenTinhTrang;
	}

	public Collection<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(Collection<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}
	
	
}
