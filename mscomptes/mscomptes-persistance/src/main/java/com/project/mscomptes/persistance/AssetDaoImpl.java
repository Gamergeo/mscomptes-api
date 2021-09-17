package com.project.mscomptes.persistance;

import org.springframework.stereotype.Repository;

import com.project.mscomptes.model.Asset;

@Repository("assetDao")
public class AssetDaoImpl extends AbstractDAO<Asset> implements AssetDao {

	@Override
	protected void setTypeParameterClass() {
		typeParameterClass = Asset.class;
	}
}
