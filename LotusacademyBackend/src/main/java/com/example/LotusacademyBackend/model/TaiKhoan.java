package com.example.LotusacademyBackend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class TaiKhoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taiKhoanID;
	
	@Column
	@Size(max = 50)
	private String tenNguoiDung;
	
	@Column
	@Size(max = 50)
	private String tenDangNhap;
	
	@Column
	@Size(max = 50)
	private String matKhau;
	
	@ManyToOne
	@JoinColumn(name = "quyenHanID")
	@JsonIgnoreProperties("taiKhoans")
	private QuyenHan quyenHan;
	
	@OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "taiKhoan")
	//@JsonManagedReference
	private Set<BaiViet> baiViets;
	
	@OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "taiKhoan")
	//@JsonManagedReference
	private Set<DangKyHoc> dangKyHocs;

	public int getTaiKhoanID() {
		return taiKhoanID;
	}

	public void setTaiKhoanID(int taiKhoanID) {
		this.taiKhoanID = taiKhoanID;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public QuyenHan getQuyenHan() {
		return quyenHan;
	}

	public void setQuyenHan(QuyenHan quyenHan) {
		this.quyenHan = quyenHan;
	}

	public Set<BaiViet> getBaiViets() {
		return baiViets;
	}

	public void setBaiViets(Set<BaiViet> baiViets) {
		this.baiViets = baiViets;
	}

	public Set<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}

	
}
