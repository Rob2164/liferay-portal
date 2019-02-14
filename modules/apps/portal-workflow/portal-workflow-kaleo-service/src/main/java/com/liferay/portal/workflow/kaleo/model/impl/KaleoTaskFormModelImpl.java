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

package com.liferay.portal.workflow.kaleo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskForm;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskFormModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the KaleoTaskForm service. Represents a row in the &quot;KaleoTaskForm&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>KaleoTaskFormModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoTaskFormImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTaskFormImpl
 * @generated
 */
@ProviderType
public class KaleoTaskFormModelImpl extends BaseModelImpl<KaleoTaskForm>
	implements KaleoTaskFormModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo task form model instance should use the <code>KaleoTaskForm</code> interface instead.
	 */
	public static final String TABLE_NAME = "KaleoTaskForm";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoTaskFormId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoDefinitionVersionId", Types.BIGINT },
			{ "kaleoNodeId", Types.BIGINT },
			{ "kaleoTaskId", Types.BIGINT },
			{ "kaleoTaskName", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "formCompanyId", Types.BIGINT },
			{ "formDefinition", Types.VARCHAR },
			{ "formGroupId", Types.BIGINT },
			{ "formId", Types.BIGINT },
			{ "formUuid", Types.VARCHAR },
			{ "metadata", Types.VARCHAR },
			{ "priority", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("kaleoTaskFormId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("kaleoDefinitionVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoNodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoTaskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoTaskName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formCompanyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("formDefinition", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("formId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("formUuid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("metadata", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priority", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table KaleoTaskForm (kaleoTaskFormId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,kaleoDefinitionVersionId LONG,kaleoNodeId LONG,kaleoTaskId LONG,kaleoTaskName VARCHAR(200) null,name VARCHAR(200) null,description STRING null,formCompanyId LONG,formDefinition STRING null,formGroupId LONG,formId LONG,formUuid VARCHAR(75) null,metadata STRING null,priority INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table KaleoTaskForm";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoTaskForm.priority ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoTaskForm.priority ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTaskForm"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTaskForm"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTaskForm"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long FORMUUID_COLUMN_BITMASK = 2L;
	public static final long KALEODEFINITIONVERSIONID_COLUMN_BITMASK = 4L;
	public static final long KALEONODEID_COLUMN_BITMASK = 8L;
	public static final long KALEOTASKID_COLUMN_BITMASK = 16L;
	public static final long PRIORITY_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoTaskForm"));

	public KaleoTaskFormModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kaleoTaskFormId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKaleoTaskFormId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kaleoTaskFormId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KaleoTaskForm.class;
	}

	@Override
	public String getModelClassName() {
		return KaleoTaskForm.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<KaleoTaskForm, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<KaleoTaskForm, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<KaleoTaskForm, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((KaleoTaskForm)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<KaleoTaskForm, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<KaleoTaskForm, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((KaleoTaskForm)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<KaleoTaskForm, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<KaleoTaskForm, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<KaleoTaskForm, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<KaleoTaskForm, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<KaleoTaskForm, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<KaleoTaskForm, Object>>();
		Map<String, BiConsumer<KaleoTaskForm, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<KaleoTaskForm, ?>>();


		attributeGetterFunctions.put(
			"kaleoTaskFormId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getKaleoTaskFormId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoTaskFormId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object kaleoTaskFormId) {
					kaleoTaskForm.setKaleoTaskFormId((Long)kaleoTaskFormId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object groupId) {
					kaleoTaskForm.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object companyId) {
					kaleoTaskForm.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object userId) {
					kaleoTaskForm.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object userName) {
					kaleoTaskForm.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object createDate) {
					kaleoTaskForm.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object modifiedDate) {
					kaleoTaskForm.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"kaleoDefinitionVersionId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getKaleoDefinitionVersionId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoDefinitionVersionId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object kaleoDefinitionVersionId) {
					kaleoTaskForm.setKaleoDefinitionVersionId((Long)kaleoDefinitionVersionId);
				}

			});
		attributeGetterFunctions.put(
			"kaleoNodeId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getKaleoNodeId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoNodeId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object kaleoNodeId) {
					kaleoTaskForm.setKaleoNodeId((Long)kaleoNodeId);
				}

			});
		attributeGetterFunctions.put(
			"kaleoTaskId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getKaleoTaskId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoTaskId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object kaleoTaskId) {
					kaleoTaskForm.setKaleoTaskId((Long)kaleoTaskId);
				}

			});
		attributeGetterFunctions.put(
			"kaleoTaskName",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getKaleoTaskName();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoTaskName",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object kaleoTaskName) {
					kaleoTaskForm.setKaleoTaskName((String)kaleoTaskName);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object name) {
					kaleoTaskForm.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object description) {
					kaleoTaskForm.setDescription((String)description);
				}

			});
		attributeGetterFunctions.put(
			"formCompanyId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getFormCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"formCompanyId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object formCompanyId) {
					kaleoTaskForm.setFormCompanyId((Long)formCompanyId);
				}

			});
		attributeGetterFunctions.put(
			"formDefinition",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getFormDefinition();
				}

			});
		attributeSetterBiConsumers.put(
			"formDefinition",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object formDefinition) {
					kaleoTaskForm.setFormDefinition((String)formDefinition);
				}

			});
		attributeGetterFunctions.put(
			"formGroupId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getFormGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"formGroupId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object formGroupId) {
					kaleoTaskForm.setFormGroupId((Long)formGroupId);
				}

			});
		attributeGetterFunctions.put(
			"formId",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getFormId();
				}

			});
		attributeSetterBiConsumers.put(
			"formId",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object formId) {
					kaleoTaskForm.setFormId((Long)formId);
				}

			});
		attributeGetterFunctions.put(
			"formUuid",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getFormUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"formUuid",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object formUuid) {
					kaleoTaskForm.setFormUuid((String)formUuid);
				}

			});
		attributeGetterFunctions.put(
			"metadata",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getMetadata();
				}

			});
		attributeSetterBiConsumers.put(
			"metadata",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object metadata) {
					kaleoTaskForm.setMetadata((String)metadata);
				}

			});
		attributeGetterFunctions.put(
			"priority",
			new Function<KaleoTaskForm, Object>() {

				@Override
				public Object apply(KaleoTaskForm kaleoTaskForm) {
					return kaleoTaskForm.getPriority();
				}

			});
		attributeSetterBiConsumers.put(
			"priority",
			new BiConsumer<KaleoTaskForm, Object>() {

				@Override
				public void accept(KaleoTaskForm kaleoTaskForm, Object priority) {
					kaleoTaskForm.setPriority((Integer)priority);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getKaleoTaskFormId() {
		return _kaleoTaskFormId;
	}

	@Override
	public void setKaleoTaskFormId(long kaleoTaskFormId) {
		_kaleoTaskFormId = kaleoTaskFormId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getKaleoDefinitionVersionId() {
		return _kaleoDefinitionVersionId;
	}

	@Override
	public void setKaleoDefinitionVersionId(long kaleoDefinitionVersionId) {
		_columnBitmask |= KALEODEFINITIONVERSIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionVersionId) {
			_setOriginalKaleoDefinitionVersionId = true;

			_originalKaleoDefinitionVersionId = _kaleoDefinitionVersionId;
		}

		_kaleoDefinitionVersionId = kaleoDefinitionVersionId;
	}

	public long getOriginalKaleoDefinitionVersionId() {
		return _originalKaleoDefinitionVersionId;
	}

	@Override
	public long getKaleoNodeId() {
		return _kaleoNodeId;
	}

	@Override
	public void setKaleoNodeId(long kaleoNodeId) {
		_columnBitmask |= KALEONODEID_COLUMN_BITMASK;

		if (!_setOriginalKaleoNodeId) {
			_setOriginalKaleoNodeId = true;

			_originalKaleoNodeId = _kaleoNodeId;
		}

		_kaleoNodeId = kaleoNodeId;
	}

	public long getOriginalKaleoNodeId() {
		return _originalKaleoNodeId;
	}

	@Override
	public long getKaleoTaskId() {
		return _kaleoTaskId;
	}

	@Override
	public void setKaleoTaskId(long kaleoTaskId) {
		_columnBitmask |= KALEOTASKID_COLUMN_BITMASK;

		if (!_setOriginalKaleoTaskId) {
			_setOriginalKaleoTaskId = true;

			_originalKaleoTaskId = _kaleoTaskId;
		}

		_kaleoTaskId = kaleoTaskId;
	}

	public long getOriginalKaleoTaskId() {
		return _originalKaleoTaskId;
	}

	@Override
	public String getKaleoTaskName() {
		if (_kaleoTaskName == null) {
			return "";
		}
		else {
			return _kaleoTaskName;
		}
	}

	@Override
	public void setKaleoTaskName(String kaleoTaskName) {
		_kaleoTaskName = kaleoTaskName;
	}

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
		_name = name;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public long getFormCompanyId() {
		return _formCompanyId;
	}

	@Override
	public void setFormCompanyId(long formCompanyId) {
		_formCompanyId = formCompanyId;
	}

	@Override
	public String getFormDefinition() {
		if (_formDefinition == null) {
			return "";
		}
		else {
			return _formDefinition;
		}
	}

	@Override
	public void setFormDefinition(String formDefinition) {
		_formDefinition = formDefinition;
	}

	@Override
	public long getFormGroupId() {
		return _formGroupId;
	}

	@Override
	public void setFormGroupId(long formGroupId) {
		_formGroupId = formGroupId;
	}

	@Override
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		_formId = formId;
	}

	@Override
	public String getFormUuid() {
		if (_formUuid == null) {
			return "";
		}
		else {
			return _formUuid;
		}
	}

	@Override
	public void setFormUuid(String formUuid) {
		_columnBitmask |= FORMUUID_COLUMN_BITMASK;

		if (_originalFormUuid == null) {
			_originalFormUuid = _formUuid;
		}

		_formUuid = formUuid;
	}

	public String getOriginalFormUuid() {
		return GetterUtil.getString(_originalFormUuid);
	}

	@Override
	public String getMetadata() {
		if (_metadata == null) {
			return "";
		}
		else {
			return _metadata;
		}
	}

	@Override
	public void setMetadata(String metadata) {
		_metadata = metadata;
	}

	@Override
	public int getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(int priority) {
		_columnBitmask = -1L;

		_priority = priority;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoTaskForm.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KaleoTaskForm toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoTaskForm)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KaleoTaskFormImpl kaleoTaskFormImpl = new KaleoTaskFormImpl();

		kaleoTaskFormImpl.setKaleoTaskFormId(getKaleoTaskFormId());
		kaleoTaskFormImpl.setGroupId(getGroupId());
		kaleoTaskFormImpl.setCompanyId(getCompanyId());
		kaleoTaskFormImpl.setUserId(getUserId());
		kaleoTaskFormImpl.setUserName(getUserName());
		kaleoTaskFormImpl.setCreateDate(getCreateDate());
		kaleoTaskFormImpl.setModifiedDate(getModifiedDate());
		kaleoTaskFormImpl.setKaleoDefinitionVersionId(getKaleoDefinitionVersionId());
		kaleoTaskFormImpl.setKaleoNodeId(getKaleoNodeId());
		kaleoTaskFormImpl.setKaleoTaskId(getKaleoTaskId());
		kaleoTaskFormImpl.setKaleoTaskName(getKaleoTaskName());
		kaleoTaskFormImpl.setName(getName());
		kaleoTaskFormImpl.setDescription(getDescription());
		kaleoTaskFormImpl.setFormCompanyId(getFormCompanyId());
		kaleoTaskFormImpl.setFormDefinition(getFormDefinition());
		kaleoTaskFormImpl.setFormGroupId(getFormGroupId());
		kaleoTaskFormImpl.setFormId(getFormId());
		kaleoTaskFormImpl.setFormUuid(getFormUuid());
		kaleoTaskFormImpl.setMetadata(getMetadata());
		kaleoTaskFormImpl.setPriority(getPriority());

		kaleoTaskFormImpl.resetOriginalValues();

		return kaleoTaskFormImpl;
	}

	@Override
	public int compareTo(KaleoTaskForm kaleoTaskForm) {
		int value = 0;

		if (getPriority() < kaleoTaskForm.getPriority()) {
			value = -1;
		}
		else if (getPriority() > kaleoTaskForm.getPriority()) {
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

		if (!(obj instanceof KaleoTaskForm)) {
			return false;
		}

		KaleoTaskForm kaleoTaskForm = (KaleoTaskForm)obj;

		long primaryKey = kaleoTaskForm.getPrimaryKey();

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
		KaleoTaskFormModelImpl kaleoTaskFormModelImpl = this;

		kaleoTaskFormModelImpl._originalCompanyId = kaleoTaskFormModelImpl._companyId;

		kaleoTaskFormModelImpl._setOriginalCompanyId = false;

		kaleoTaskFormModelImpl._setModifiedDate = false;

		kaleoTaskFormModelImpl._originalKaleoDefinitionVersionId = kaleoTaskFormModelImpl._kaleoDefinitionVersionId;

		kaleoTaskFormModelImpl._setOriginalKaleoDefinitionVersionId = false;

		kaleoTaskFormModelImpl._originalKaleoNodeId = kaleoTaskFormModelImpl._kaleoNodeId;

		kaleoTaskFormModelImpl._setOriginalKaleoNodeId = false;

		kaleoTaskFormModelImpl._originalKaleoTaskId = kaleoTaskFormModelImpl._kaleoTaskId;

		kaleoTaskFormModelImpl._setOriginalKaleoTaskId = false;

		kaleoTaskFormModelImpl._originalFormUuid = kaleoTaskFormModelImpl._formUuid;

		kaleoTaskFormModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoTaskForm> toCacheModel() {
		KaleoTaskFormCacheModel kaleoTaskFormCacheModel = new KaleoTaskFormCacheModel();

		kaleoTaskFormCacheModel.kaleoTaskFormId = getKaleoTaskFormId();

		kaleoTaskFormCacheModel.groupId = getGroupId();

		kaleoTaskFormCacheModel.companyId = getCompanyId();

		kaleoTaskFormCacheModel.userId = getUserId();

		kaleoTaskFormCacheModel.userName = getUserName();

		String userName = kaleoTaskFormCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoTaskFormCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoTaskFormCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoTaskFormCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoTaskFormCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoTaskFormCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoTaskFormCacheModel.kaleoDefinitionVersionId = getKaleoDefinitionVersionId();

		kaleoTaskFormCacheModel.kaleoNodeId = getKaleoNodeId();

		kaleoTaskFormCacheModel.kaleoTaskId = getKaleoTaskId();

		kaleoTaskFormCacheModel.kaleoTaskName = getKaleoTaskName();

		String kaleoTaskName = kaleoTaskFormCacheModel.kaleoTaskName;

		if ((kaleoTaskName != null) && (kaleoTaskName.length() == 0)) {
			kaleoTaskFormCacheModel.kaleoTaskName = null;
		}

		kaleoTaskFormCacheModel.name = getName();

		String name = kaleoTaskFormCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoTaskFormCacheModel.name = null;
		}

		kaleoTaskFormCacheModel.description = getDescription();

		String description = kaleoTaskFormCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoTaskFormCacheModel.description = null;
		}

		kaleoTaskFormCacheModel.formCompanyId = getFormCompanyId();

		kaleoTaskFormCacheModel.formDefinition = getFormDefinition();

		String formDefinition = kaleoTaskFormCacheModel.formDefinition;

		if ((formDefinition != null) && (formDefinition.length() == 0)) {
			kaleoTaskFormCacheModel.formDefinition = null;
		}

		kaleoTaskFormCacheModel.formGroupId = getFormGroupId();

		kaleoTaskFormCacheModel.formId = getFormId();

		kaleoTaskFormCacheModel.formUuid = getFormUuid();

		String formUuid = kaleoTaskFormCacheModel.formUuid;

		if ((formUuid != null) && (formUuid.length() == 0)) {
			kaleoTaskFormCacheModel.formUuid = null;
		}

		kaleoTaskFormCacheModel.metadata = getMetadata();

		String metadata = kaleoTaskFormCacheModel.metadata;

		if ((metadata != null) && (metadata.length() == 0)) {
			kaleoTaskFormCacheModel.metadata = null;
		}

		kaleoTaskFormCacheModel.priority = getPriority();

		return kaleoTaskFormCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<KaleoTaskForm, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<KaleoTaskForm, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<KaleoTaskForm, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((KaleoTaskForm)this));
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
		Map<String, Function<KaleoTaskForm, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<KaleoTaskForm, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<KaleoTaskForm, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((KaleoTaskForm)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = KaleoTaskForm.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoTaskForm.class, ModelWrapper.class
		};
	private long _kaleoTaskFormId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _kaleoDefinitionVersionId;
	private long _originalKaleoDefinitionVersionId;
	private boolean _setOriginalKaleoDefinitionVersionId;
	private long _kaleoNodeId;
	private long _originalKaleoNodeId;
	private boolean _setOriginalKaleoNodeId;
	private long _kaleoTaskId;
	private long _originalKaleoTaskId;
	private boolean _setOriginalKaleoTaskId;
	private String _kaleoTaskName;
	private String _name;
	private String _description;
	private long _formCompanyId;
	private String _formDefinition;
	private long _formGroupId;
	private long _formId;
	private String _formUuid;
	private String _originalFormUuid;
	private String _metadata;
	private int _priority;
	private long _columnBitmask;
	private KaleoTaskForm _escapedModel;
}