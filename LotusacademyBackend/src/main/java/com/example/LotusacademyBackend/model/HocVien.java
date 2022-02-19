package com.example.LotusacademyBackend.model;

import java.sql.Date;
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
public class HocVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int hocVienID;
	
	@Column
	private String hinhAnh;
	
	@Column
	@Size(max = 50)
	private String hoTen;
	
	@Column
	private Date ngaySinh;
	
	@Column
	@Size(max = 11)
	private String soDienThoai;
	
	@Column
	@Size(max = 40)
	private String email;
	
	@Column
	@Size(max = 50)
	private String tinhThanh;
	
	@Column
	@Size(max = 50)
	private String quanHuyen;
	
	@Column
	@Size(max = 50)
	private String phuongXa;
	
	@Column
	@Size(max = 50)
	private String soNha;
	
	@OneToMany(mappedBy = "hocVien",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("hocVien")
	//@JsonManagedReference
	private Collection<DangKyHoc> dangKyHocs;

	public int getHocVienID() {
		return hocVienID;
	}

	public void setHocVienID(int hocVienID) {
		this.hocVienID = hocVienID;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public Collection<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(Collection<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}

	public String getPhuongXa() {
		return phuongXa;
	}

	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}
	
	
}
