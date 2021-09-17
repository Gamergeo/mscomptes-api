package com.project.mscomptes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "asset")
@Table(name = "asset")
public class Asset implements Serializable {

	private static final long serialVersionUID = -1864542003746307771L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;

	@Column
	private String name;
	
	@Column
	@Enumerated(EnumType.STRING)
	private AssetType type;
	
	@Column
	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AssetType getType() {
		return type;
	}

	public void setType(AssetType type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
