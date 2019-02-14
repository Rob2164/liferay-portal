/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.CountryModel;
import com.liferay.portal.kernel.model.CountrySoap;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Country service. Represents a row in the &quot;Country&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CountryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CountryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CountryModelImpl extends BaseModelImpl<Country>
	implements CountryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a country model instance should use the <code>Country</code> interface instead.
	 */
	public static final String TABLE_NAME = "Country";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "countryId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "a2", Types.VARCHAR },
			{ "a3", Types.VARCHAR },
			{ "number_", Types.VARCHAR },
			{ "idd_", Types.VARCHAR },
			{ "zipRequired", Types.BOOLEAN },
			{ "active_", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("countryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("a2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("a3", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("number_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("idd_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zipRequired", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table Country (mvccVersion LONG default 0 not null,countryId LONG not null primary key,name VARCHAR(75) null,a2 VARCHAR(75) null,a3 VARCHAR(75) null,number_ VARCHAR(75) null,idd_ VARCHAR(75) null,zipRequired BOOLEAN,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Country";
	public static final String ORDER_BY_JPQL = " ORDER BY country.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Country.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.Country"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.Country"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.Country"),
			true);
	public static final long A2_COLUMN_BITMASK = 1L;
	public static final long A3_COLUMN_BITMASK = 2L;
	public static final long ACTIVE_COLUMN_BITMASK = 4L;
	public static final long NAME_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Country toModel(CountrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Country model = new CountryImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setCountryId(soapModel.getCountryId());
		model.setName(soapModel.getName());
		model.setA2(soapModel.getA2());
		model.setA3(soapModel.getA3());
		model.setNumber(soapModel.getNumber());
		model.setIdd(soapModel.getIdd());
		model.setZipRequired(soapModel.isZipRequired());
		model.setActive(soapModel.isActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Country> toModels(CountrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Country> models = new ArrayList<Country>(soapModels.length);

		for (CountrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.kernel.model.Country"));

	public CountryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _countryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCountryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _countryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Country.class;
	}

	@Override
	public String getModelClassName() {
		return Country.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Country, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Country, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((Country)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Country, Object>> attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Country, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Country)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Country, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Country, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Country, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<Country, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<Country, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<Country, Object>>();
		Map<String, BiConsumer<Country, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<Country, ?>>();


		attributeGetterFunctions.put(
			"mvccVersion",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getMvccVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"mvccVersion",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object mvccVersion) {
					country.setMvccVersion((Long)mvccVersion);
				}

			});
		attributeGetterFunctions.put(
			"countryId",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getCountryId();
				}

			});
		attributeSetterBiConsumers.put(
			"countryId",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object countryId) {
					country.setCountryId((Long)countryId);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object name) {
					country.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"a2",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getA2();
				}

			});
		attributeSetterBiConsumers.put(
			"a2",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object a2) {
					country.setA2((String)a2);
				}

			});
		attributeGetterFunctions.put(
			"a3",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getA3();
				}

			});
		attributeSetterBiConsumers.put(
			"a3",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object a3) {
					country.setA3((String)a3);
				}

			});
		attributeGetterFunctions.put(
			"number",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getNumber();
				}

			});
		attributeSetterBiConsumers.put(
			"number",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object number) {
					country.setNumber((String)number);
				}

			});
		attributeGetterFunctions.put(
			"idd",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getIdd();
				}

			});
		attributeSetterBiConsumers.put(
			"idd",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object idd) {
					country.setIdd((String)idd);
				}

			});
		attributeGetterFunctions.put(
			"zipRequired",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getZipRequired();
				}

			});
		attributeSetterBiConsumers.put(
			"zipRequired",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object zipRequired) {
					country.setZipRequired((Boolean)zipRequired);
				}

			});
		attributeGetterFunctions.put(
			"active",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getActive();
				}

			});
		attributeSetterBiConsumers.put(
			"active",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object active) {
					country.setActive((Boolean)active);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getA2() {
		if (_a2 == null) {
			return "";
		}
		else {
			return _a2;
		}
	}

	@Override
	public void setA2(String a2) {
		_columnBitmask |= A2_COLUMN_BITMASK;

		if (_originalA2 == null) {
			_originalA2 = _a2;
		}

		_a2 = a2;
	}

	public String getOriginalA2() {
		return GetterUtil.getString(_originalA2);
	}

	@JSON
	@Override
	public String getA3() {
		if (_a3 == null) {
			return "";
		}
		else {
			return _a3;
		}
	}

	@Override
	public void setA3(String a3) {
		_columnBitmask |= A3_COLUMN_BITMASK;

		if (_originalA3 == null) {
			_originalA3 = _a3;
		}

		_a3 = a3;
	}

	public String getOriginalA3() {
		return GetterUtil.getString(_originalA3);
	}

	@JSON
	@Override
	public String getNumber() {
		if (_number == null) {
			return "";
		}
		else {
			return _number;
		}
	}

	@Override
	public void setNumber(String number) {
		_number = number;
	}

	@JSON
	@Override
	public String getIdd() {
		if (_idd == null) {
			return "";
		}
		else {
			return _idd;
		}
	}

	@Override
	public void setIdd(String idd) {
		_idd = idd;
	}

	@JSON
	@Override
	public boolean getZipRequired() {
		return _zipRequired;
	}

	@JSON
	@Override
	public boolean isZipRequired() {
		return _zipRequired;
	}

	@Override
	public void setZipRequired(boolean zipRequired) {
		_zipRequired = zipRequired;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Country.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Country toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Country)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CountryImpl countryImpl = new CountryImpl();

		countryImpl.setMvccVersion(getMvccVersion());
		countryImpl.setCountryId(getCountryId());
		countryImpl.setName(getName());
		countryImpl.setA2(getA2());
		countryImpl.setA3(getA3());
		countryImpl.setNumber(getNumber());
		countryImpl.setIdd(getIdd());
		countryImpl.setZipRequired(isZipRequired());
		countryImpl.setActive(isActive());

		countryImpl.resetOriginalValues();

		return countryImpl;
	}

	@Override
	public int compareTo(Country country) {
		int value = 0;

		value = getName().compareTo(country.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Country)) {
			return false;
		}

		Country country = (Country)obj;

		long primaryKey = country.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CountryModelImpl countryModelImpl = this;

		countryModelImpl._originalName = countryModelImpl._name;

		countryModelImpl._originalA2 = countryModelImpl._a2;

		countryModelImpl._originalA3 = countryModelImpl._a3;

		countryModelImpl._originalActive = countryModelImpl._active;

		countryModelImpl._setOriginalActive = false;

		countryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Country> toCacheModel() {
		CountryCacheModel countryCacheModel = new CountryCacheModel();

		countryCacheModel.mvccVersion = getMvccVersion();

		countryCacheModel.countryId = getCountryId();

		countryCacheModel.name = getName();

		String name = countryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			countryCacheModel.name = null;
		}

		countryCacheModel.a2 = getA2();

		String a2 = countryCacheModel.a2;

		if ((a2 != null) && (a2.length() == 0)) {
			countryCacheModel.a2 = null;
		}

		countryCacheModel.a3 = getA3();

		String a3 = countryCacheModel.a3;

		if ((a3 != null) && (a3.length() == 0)) {
			countryCacheModel.a3 = null;
		}

		countryCacheModel.number = getNumber();

		String number = countryCacheModel.number;

		if ((number != null) && (number.length() == 0)) {
			countryCacheModel.number = null;
		}

		countryCacheModel.idd = getIdd();

		String idd = countryCacheModel.idd;

		if ((idd != null) && (idd.length() == 0)) {
			countryCacheModel.idd = null;
		}

		countryCacheModel.zipRequired = isZipRequired();

		countryCacheModel.active = isActive();

		return countryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Country, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<Country, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Country)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Country, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Country, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Country)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Country.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Country.class, ModelWrapper.class
		};
	private long _mvccVersion;
	private long _countryId;
	private String _name;
	private String _originalName;
	private String _a2;
	private String _originalA2;
	private String _a3;
	private String _originalA3;
	private String _number;
	private String _idd;
	private boolean _zipRequired;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _columnBitmask;
	private Country _escapedModel;
}