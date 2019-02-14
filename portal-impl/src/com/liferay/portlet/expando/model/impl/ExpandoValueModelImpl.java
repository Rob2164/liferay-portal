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

package com.liferay.portlet.expando.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.model.ExpandoValueModel;
import com.liferay.expando.kernel.model.ExpandoValueSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

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
 * The base model implementation for the ExpandoValue service. Represents a row in the &quot;ExpandoValue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ExpandoValueModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExpandoValueImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoValueImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ExpandoValueModelImpl extends BaseModelImpl<ExpandoValue>
	implements ExpandoValueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a expando value model instance should use the <code>ExpandoValue</code> interface instead.
	 */
	public static final String TABLE_NAME = "ExpandoValue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "valueId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "tableId", Types.BIGINT },
			{ "columnId", Types.BIGINT },
			{ "rowId_", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "data_", Types.CLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("valueId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tableId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("columnId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rowId_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("data_", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table ExpandoValue (valueId LONG not null primary key,companyId LONG,tableId LONG,columnId LONG,rowId_ LONG,classNameId LONG,classPK LONG,data_ TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table ExpandoValue";
	public static final String ORDER_BY_JPQL = " ORDER BY expandoValue.tableId ASC, expandoValue.rowId ASC, expandoValue.columnId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ExpandoValue.tableId ASC, ExpandoValue.rowId_ ASC, ExpandoValue.columnId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.expando.kernel.model.ExpandoValue"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.expando.kernel.model.ExpandoValue"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.expando.kernel.model.ExpandoValue"),
			true);
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static final long CLASSPK_COLUMN_BITMASK = 2L;
	public static final long COLUMNID_COLUMN_BITMASK = 4L;
	public static final long DATA_COLUMN_BITMASK = 8L;
	public static final long ROWID_COLUMN_BITMASK = 16L;
	public static final long TABLEID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ExpandoValue toModel(ExpandoValueSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ExpandoValue model = new ExpandoValueImpl();

		model.setValueId(soapModel.getValueId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setTableId(soapModel.getTableId());
		model.setColumnId(soapModel.getColumnId());
		model.setRowId(soapModel.getRowId());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setData(soapModel.getData());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ExpandoValue> toModels(ExpandoValueSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ExpandoValue> models = new ArrayList<ExpandoValue>(soapModels.length);

		for (ExpandoValueSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.expando.kernel.model.ExpandoValue"));

	public ExpandoValueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _valueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _valueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ExpandoValue.class;
	}

	@Override
	public String getModelClassName() {
		return ExpandoValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ExpandoValue, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ExpandoValue, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ExpandoValue, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((ExpandoValue)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ExpandoValue, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ExpandoValue, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((ExpandoValue)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<ExpandoValue, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ExpandoValue, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ExpandoValue, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<ExpandoValue, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<ExpandoValue, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<ExpandoValue, Object>>();
		Map<String, BiConsumer<ExpandoValue, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<ExpandoValue, ?>>();


		attributeGetterFunctions.put(
			"valueId",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getValueId();
				}

			});
		attributeSetterBiConsumers.put(
			"valueId",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object valueId) {
					expandoValue.setValueId((Long)valueId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object companyId) {
					expandoValue.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"tableId",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getTableId();
				}

			});
		attributeSetterBiConsumers.put(
			"tableId",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object tableId) {
					expandoValue.setTableId((Long)tableId);
				}

			});
		attributeGetterFunctions.put(
			"columnId",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getColumnId();
				}

			});
		attributeSetterBiConsumers.put(
			"columnId",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object columnId) {
					expandoValue.setColumnId((Long)columnId);
				}

			});
		attributeGetterFunctions.put(
			"rowId",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getRowId();
				}

			});
		attributeSetterBiConsumers.put(
			"rowId",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object rowId) {
					expandoValue.setRowId((Long)rowId);
				}

			});
		attributeGetterFunctions.put(
			"classNameId",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getClassNameId();
				}

			});
		attributeSetterBiConsumers.put(
			"classNameId",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object classNameId) {
					expandoValue.setClassNameId((Long)classNameId);
				}

			});
		attributeGetterFunctions.put(
			"classPK",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"classPK",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object classPK) {
					expandoValue.setClassPK((Long)classPK);
				}

			});
		attributeGetterFunctions.put(
			"data",
			new Function<ExpandoValue, Object>() {

				@Override
				public Object apply(ExpandoValue expandoValue) {
					return expandoValue.getData();
				}

			});
		attributeSetterBiConsumers.put(
			"data",
			new BiConsumer<ExpandoValue, Object>() {

				@Override
				public void accept(ExpandoValue expandoValue, Object data) {
					expandoValue.setData((String)data);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getValueId() {
		return _valueId;
	}

	@Override
	public void setValueId(long valueId) {
		_valueId = valueId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getTableId() {
		return _tableId;
	}

	@Override
	public void setTableId(long tableId) {
		_columnBitmask = -1L;

		if (!_setOriginalTableId) {
			_setOriginalTableId = true;

			_originalTableId = _tableId;
		}

		_tableId = tableId;
	}

	public long getOriginalTableId() {
		return _originalTableId;
	}

	@JSON
	@Override
	public long getColumnId() {
		return _columnId;
	}

	@Override
	public void setColumnId(long columnId) {
		_columnBitmask = -1L;

		if (!_setOriginalColumnId) {
			_setOriginalColumnId = true;

			_originalColumnId = _columnId;
		}

		_columnId = columnId;
	}

	public long getOriginalColumnId() {
		return _originalColumnId;
	}

	@JSON
	@Override
	public long getRowId() {
		return _rowId;
	}

	@Override
	public void setRowId(long rowId) {
		_columnBitmask = -1L;

		if (!_setOriginalRowId) {
			_setOriginalRowId = true;

			_originalRowId = _rowId;
		}

		_rowId = rowId;
	}

	public long getOriginalRowId() {
		return _originalRowId;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public String getData() {
		if (_data == null) {
			return "";
		}
		else {
			return _data;
		}
	}

	@Override
	public void setData(String data) {
		_columnBitmask |= DATA_COLUMN_BITMASK;

		if (_originalData == null) {
			_originalData = _data;
		}

		_data = data;
	}

	public String getOriginalData() {
		return GetterUtil.getString(_originalData);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoValue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ExpandoValue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ExpandoValueImpl expandoValueImpl = new ExpandoValueImpl();

		expandoValueImpl.setValueId(getValueId());
		expandoValueImpl.setCompanyId(getCompanyId());
		expandoValueImpl.setTableId(getTableId());
		expandoValueImpl.setColumnId(getColumnId());
		expandoValueImpl.setRowId(getRowId());
		expandoValueImpl.setClassNameId(getClassNameId());
		expandoValueImpl.setClassPK(getClassPK());
		expandoValueImpl.setData(getData());

		expandoValueImpl.resetOriginalValues();

		return expandoValueImpl;
	}

	@Override
	public int compareTo(ExpandoValue expandoValue) {
		int value = 0;

		if (getTableId() < expandoValue.getTableId()) {
			value = -1;
		}
		else if (getTableId() > expandoValue.getTableId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getRowId() < expandoValue.getRowId()) {
			value = -1;
		}
		else if (getRowId() > expandoValue.getRowId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getColumnId() < expandoValue.getColumnId()) {
			value = -1;
		}
		else if (getColumnId() > expandoValue.getColumnId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ExpandoValue)) {
			return false;
		}

		ExpandoValue expandoValue = (ExpandoValue)obj;

		long primaryKey = expandoValue.getPrimaryKey();

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
		ExpandoValueModelImpl expandoValueModelImpl = this;

		expandoValueModelImpl._originalTableId = expandoValueModelImpl._tableId;

		expandoValueModelImpl._setOriginalTableId = false;

		expandoValueModelImpl._originalColumnId = expandoValueModelImpl._columnId;

		expandoValueModelImpl._setOriginalColumnId = false;

		expandoValueModelImpl._originalRowId = expandoValueModelImpl._rowId;

		expandoValueModelImpl._setOriginalRowId = false;

		expandoValueModelImpl._originalClassNameId = expandoValueModelImpl._classNameId;

		expandoValueModelImpl._setOriginalClassNameId = false;

		expandoValueModelImpl._originalClassPK = expandoValueModelImpl._classPK;

		expandoValueModelImpl._setOriginalClassPK = false;

		expandoValueModelImpl._originalData = expandoValueModelImpl._data;

		expandoValueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ExpandoValue> toCacheModel() {
		ExpandoValueCacheModel expandoValueCacheModel = new ExpandoValueCacheModel();

		expandoValueCacheModel.valueId = getValueId();

		expandoValueCacheModel.companyId = getCompanyId();

		expandoValueCacheModel.tableId = getTableId();

		expandoValueCacheModel.columnId = getColumnId();

		expandoValueCacheModel.rowId = getRowId();

		expandoValueCacheModel.classNameId = getClassNameId();

		expandoValueCacheModel.classPK = getClassPK();

		expandoValueCacheModel.data = getData();

		String data = expandoValueCacheModel.data;

		if ((data != null) && (data.length() == 0)) {
			expandoValueCacheModel.data = null;
		}

		return expandoValueCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ExpandoValue, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<ExpandoValue, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ExpandoValue, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ExpandoValue)this));
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
		Map<String, Function<ExpandoValue, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ExpandoValue, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ExpandoValue, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ExpandoValue)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ExpandoValue.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ExpandoValue.class, ModelWrapper.class
		};
	private long _valueId;
	private long _companyId;
	private long _tableId;
	private long _originalTableId;
	private boolean _setOriginalTableId;
	private long _columnId;
	private long _originalColumnId;
	private boolean _setOriginalColumnId;
	private long _rowId;
	private long _originalRowId;
	private boolean _setOriginalRowId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _data;
	private String _originalData;
	private long _columnBitmask;
	private ExpandoValue _escapedModel;
}