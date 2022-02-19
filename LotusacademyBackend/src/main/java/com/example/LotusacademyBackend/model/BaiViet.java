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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class BaiViet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int baiVietID;
	
	@Column(length = 50)
	private String tenBaiViet;
	
	@Column(length = 50)
	private String tenTacGia;
	
	@Column
	private String noiDung;
	
	@Column
	@Size(max = 1000)
	private String noiDungNgan;
	
	@Column
	private Date thoiGianTao;
	
	@Column
	private String hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "chuDeID")
	@JsonIgnoreProperties("baiViets")
	private ChuDe chuDe;
	
	@ManyToOne()
	@JoinColumn(name = "taiKhoanID")
	@JsonIgnoreProperties("baiViets")
	private TaiKhoan taiKhoan;

	public int getBaiVietID() {
		return baiVietID;
	}

	public void setBaiVietID(int baiVietID) {
		this.baiVietID = baiVietID;
	}

	public String getTenBaiViet() {
		return tenBaiViet;
	}

	public void setTenBaiViet(String tenBaiViet) {
		this.tenBaiViet = tenBaiViet;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getNoiDungNgan() {
		return noiDungNgan;
	}

	public void setNoiDungNgan(String noiDungNgan) {
		this.noiDungNgan = noiDungNgan;
	}

	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public ChuDe getChuDe() {
		return chuDe;
	}

	public void setChuDe(ChuDe chuDe) {
		this.chuDe = chuDe;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}



	
}
