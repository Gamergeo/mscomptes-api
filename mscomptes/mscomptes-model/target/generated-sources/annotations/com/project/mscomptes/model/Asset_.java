package com.project.mscomptes.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Asset.class)
public abstract class Asset_ {

	public static volatile SingularAttribute<Asset, String> market;
	public static volatile SingularAttribute<Asset, String> symbol;
	public static volatile SingularAttribute<Asset, Boolean> managed;
	public static volatile SingularAttribute<Asset, String> name;
	public static volatile SingularAttribute<Asset, String> link;
	public static volatile SingularAttribute<Asset, Asset> dependence;
	public static volatile SingularAttribute<Asset, Integer> id;
	public static volatile SingularAttribute<Asset, AssetType> type;
	public static volatile SingularAttribute<Asset, String> isin;

	public static final String MARKET = "market";
	public static final String SYMBOL = "symbol";
	public static final String MANAGED = "managed";
	public static final String NAME = "name";
	public static final String LINK = "link";
	public static final String DEPENDENCE = "dependence";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String ISIN = "isin";

}

