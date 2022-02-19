package com.example.LotusacademyBackend.model;

import java.util.Collection;

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
public class KhoaHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int khoaHocID;
	
	@Column
	@Size(max = 50)
	private String tenKhoaHoc;
	
	@Column
	private int thoiGianHoc;
	
	@Column
	private String gioiThieu;
	
	@Column
	private String noiDung;
	
	@Column
	private float hocPhi;
	
	@Column 
	private int soHocVien;
	
	@Column
	private int soLuongMon;
	
	@Column
	private String hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "loaiKhoaHocID")
	@JsonIgnoreProperties("khoaHocs")
	private LoaiKhoaHoc loaiKhoaHoc;
	
	@OneToMany(mappedBy = "khoaHoc", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("khoaHoc")
	//@JsonManagedReference
	private Collection<DangKyHoc> dangKyHocs;

	public int getKhoaHocID() {
		return khoaHocID;
	}

	public void setKhoaHocID(int khoaHocID) {
		this.khoaHocID = khoaHocID;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public int getThoiGianHoc() {
		return thoiGianHoc;
	}

	public void setThoiGianHoc(int thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public float getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(float hocPhi) {
		this.hocPhi = hocPhi;
	}

	public int getSoHocVien() {
		return soHocVien;
	}

	public void setSoHocVien(int soHocVien) {
		this.soHocVien = soHocVien;
	}

	public int getSoLuongMon() {
		return soLuongMon;
	}

	public void setSoLuongMon(int soLuongMon) {
		this.soLuongMon = soLuongMon;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public LoaiKhoaHoc getLoaiKhoaHoc() {
		return loaiKhoaHoc;
	}

	public void setLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
		this.loaiKhoaHoc = loaiKhoaHoc;
	}

	public Collection<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(Collection<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}
	
	
}
