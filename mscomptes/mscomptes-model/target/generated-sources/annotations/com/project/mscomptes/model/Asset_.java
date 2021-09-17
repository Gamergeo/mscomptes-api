package com.project.mscomptes.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Asset.class)
public abstract class Asset_ {

	public static volatile SingularAttribute<Asset, String> code;
	public static volatile SingularAttribute<Asset, String> name;
	public static volatile SingularAttribute<Asset, Integer> id;
	public static volatile SingularAttribute<Asset, AssetType> type;

	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

