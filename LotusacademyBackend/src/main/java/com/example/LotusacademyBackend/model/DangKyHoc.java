package com.example.LotusacademyBackend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class DangKyHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dangKyHocID;
	
	@Column
	private Date ngayDangKy;
	
	@Column
	private Date ngayBatDau;
	
	@Column
	private Date ngayKetThuc;

	@ManyToOne
	@JoinColumn(name = "khoaHocID")
	@JsonIgnoreProperties("dangKyHocs")
	//@JsonBackReference
	private KhoaHoc khoaHoc;
	
	@ManyToOne
	@JoinColumn(name = "hocVienID")
	@JsonIgnoreProperties("dangKyHocs")
	//@JsonBackReference
	private HocVien hocVien;
	
	@ManyToOne
	@JoinColumn(name = "taiKhoanID")
	@JsonIgnoreProperties("dangKyHocs")
	//@JsonBackReference
	private TaiKhoan taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "tinhTrangHocID")
	@JsonIgnoreProperties("dangKyHocs")
	//@JsonBackReference
	private TinhTrangHoc tinhTrangHoc;

	public int getDangKyHocID() {
		return dangKyHocID;
	}

	public void setDangKyHocID(int dangKyHocID) {
		this.dangKyHocID = dangKyHocID;
	}

	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public KhoaHoc getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public HocVien getHocVien() {
		return hocVien;
	}

	public void setHocVien(HocVien hocVien) {
		this.hocVien = hocVien;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public TinhTrangHoc getTinhTrangHoc() {
		return tinhTrangHoc;
	}

	public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
		this.tinhTrangHoc = tinhTrangHoc;
	}

	
	
	
}
