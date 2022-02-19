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
public class ChuDe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chuDeID;
	
	@Column
	@Size(max = 50)
	private String tenChuDe;
	
	@Column
	private String noiDung;
	
	@OneToMany(mappedBy = "chuDe" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("chuDe")
	//@JsonManagedReference
	private Collection<BaiViet> baiViets;
	
	@ManyToOne
	@JoinColumn(name = "loaiBaiVietID")
	@JsonIgnoreProperties("chuDes")
	private LoaiBaiViet loaiBaiViet;

	public int getChuDeID() {
		return chuDeID;
	}

	public void setChuDeID(int chuDeID) {
		this.chuDeID = chuDeID;
	}

	public String getTenChuDe() {
		return tenChuDe;
	}

	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	
	public Collection<BaiViet> getBaiViets() {
		return baiViets;
	}

	public void setBaiViets(Collection<BaiViet> baiViets) {
		this.baiViets = baiViets;
	}

	public LoaiBaiViet getLoaiBaiViet() {
		return loaiBaiViet;
	}

	public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
		this.loaiBaiViet = loaiBaiViet;
	}

	
	
}
