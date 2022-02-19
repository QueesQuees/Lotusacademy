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
public class LoaiBaiViet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loaiBaiVietID;
	
	@Column
	@Size(max = 50)
	private String tenLoai;
	
	@OneToMany(mappedBy = "loaiBaiViet", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("loaiBaiViet")
	private Collection<ChuDe> chuDes;

	public int getLoaiBaiVietID() {
		return loaiBaiVietID;
	}

	public void setLoaiBaiVietID(int loaiBaiVietID) {
		this.loaiBaiVietID = loaiBaiVietID;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public Collection<ChuDe> getChuDes() {
		return chuDes;
	}

	public void setChuDes(Collection<ChuDe> chuDes) {
		this.chuDes = chuDes;
	}

	
	
}
