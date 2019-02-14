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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.model.WorkflowDefinitionLinkModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

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
 * The base model implementation for the WorkflowDefinitionLink service. Represents a row in the &quot;WorkflowDefinitionLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>WorkflowDefinitionLinkModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkflowDefinitionLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowDefinitionLinkImpl
 * @generated
 */
@ProviderType
public class WorkflowDefinitionLinkModelImpl extends BaseModelImpl<WorkflowDefinitionLink>
	implements WorkflowDefinitionLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a workflow definition link model instance should use the <code>WorkflowDefinitionLink</code> interface instead.
	 */
	public static final String TABLE_NAME = "WorkflowDefinitionLink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "workflowDefinitionLinkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "typePK", Types.BIGINT },
			{ "workflowDefinitionName", Types.VARCHAR },
			{ "workflowDefinitionVersion", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workflowDefinitionLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("typePK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workflowDefinitionName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("workflowDefinitionVersion", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table WorkflowDefinitionLink (mvccVersion LONG default 0 not null,workflowDefinitionLinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,typePK LONG,workflowDefinitionName VARCHAR(75) null,workflowDefinitionVersion INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table WorkflowDefinitionLink";
	public static final String ORDER_BY_JPQL = " ORDER BY workflowDefinitionLink.workflowDefinitionName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WorkflowDefinitionLink.workflowDefinitionName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.WorkflowDefinitionLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.WorkflowDefinitionLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.WorkflowDefinitionLink"),
			true);
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static final long CLASSPK_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long TYPEPK_COLUMN_BITMASK = 16L;
	public static final long WORKFLOWDEFINITIONNAME_COLUMN_BITMASK = 32L;
	public static final long WORKFLOWDEFINITIONVERSION_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.kernel.model.WorkflowDefinitionLink"));

	public WorkflowDefinitionLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _workflowDefinitionLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowDefinitionLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowDefinitionLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowDefinitionLink.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowDefinitionLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<WorkflowDefinitionLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<WorkflowDefinitionLink, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<WorkflowDefinitionLink, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((WorkflowDefinitionLink)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<WorkflowDefinitionLink, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<WorkflowDefinitionLink, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((WorkflowDefinitionLink)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<WorkflowDefinitionLink, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<WorkflowDefinitionLink, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<WorkflowDefinitionLink, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<WorkflowDefinitionLink, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<WorkflowDefinitionLink, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<WorkflowDefinitionLink, Object>>();
		Map<String, BiConsumer<WorkflowDefinitionLink, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<WorkflowDefinitionLink, ?>>();


		attributeGetterFunctions.put(
			"mvccVersion",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getMvccVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"mvccVersion",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object mvccVersion) {
					workflowDefinitionLink.setMvccVersion((Long)mvccVersion);
				}

			});
		attributeGetterFunctions.put(
			"workflowDefinitionLinkId",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getWorkflowDefinitionLinkId();
				}

			});
		attributeSetterBiConsumers.put(
			"workflowDefinitionLinkId",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object workflowDefinitionLinkId) {
					workflowDefinitionLink.setWorkflowDefinitionLinkId((Long)workflowDefinitionLinkId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object groupId) {
					workflowDefinitionLink.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object companyId) {
					workflowDefinitionLink.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object userId) {
					workflowDefinitionLink.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object userName) {
					workflowDefinitionLink.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object createDate) {
					workflowDefinitionLink.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object modifiedDate) {
					workflowDefinitionLink.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"classNameId",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getClassNameId();
				}

			});
		attributeSetterBiConsumers.put(
			"classNameId",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object classNameId) {
					workflowDefinitionLink.setClassNameId((Long)classNameId);
				}

			});
		attributeGetterFunctions.put(
			"classPK",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"classPK",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object classPK) {
					workflowDefinitionLink.setClassPK((Long)classPK);
				}

			});
		attributeGetterFunctions.put(
			"typePK",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getTypePK();
				}

			});
		attributeSetterBiConsumers.put(
			"typePK",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object typePK) {
					workflowDefinitionLink.setTypePK((Long)typePK);
				}

			});
		attributeGetterFunctions.put(
			"workflowDefinitionName",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getWorkflowDefinitionName();
				}

			});
		attributeSetterBiConsumers.put(
			"workflowDefinitionName",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object workflowDefinitionName) {
					workflowDefinitionLink.setWorkflowDefinitionName((String)workflowDefinitionName);
				}

			});
		attributeGetterFunctions.put(
			"workflowDefinitionVersion",
			new Function<WorkflowDefinitionLink, Object>() {

				@Override
				public Object apply(WorkflowDefinitionLink workflowDefinitionLink) {
					return workflowDefinitionLink.getWorkflowDefinitionVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"workflowDefinitionVersion",
			new BiConsumer<WorkflowDefinitionLink, Object>() {

				@Override
				public void accept(WorkflowDefinitionLink workflowDefinitionLink, Object workflowDefinitionVersion) {
					workflowDefinitionLink.setWorkflowDefinitionVersion((Integer)workflowDefinitionVersion);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getWorkflowDefinitionLinkId() {
		return _workflowDefinitionLinkId;
	}

	@Override
	public void setWorkflowDefinitionLinkId(long workflowDefinitionLinkId) {
		_workflowDefinitionLinkId = workflowDefinitionLinkId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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

	@Override
	public long getTypePK() {
		return _typePK;
	}

	@Override
	public void setTypePK(long typePK) {
		_columnBitmask |= TYPEPK_COLUMN_BITMASK;

		if (!_setOriginalTypePK) {
			_setOriginalTypePK = true;

			_originalTypePK = _typePK;
		}

		_typePK = typePK;
	}

	public long getOriginalTypePK() {
		return _originalTypePK;
	}

	@Override
	public String getWorkflowDefinitionName() {
		if (_workflowDefinitionName == null) {
			return "";
		}
		else {
			return _workflowDefinitionName;
		}
	}

	@Override
	public void setWorkflowDefinitionName(String workflowDefinitionName) {
		_columnBitmask = -1L;

		if (_originalWorkflowDefinitionName == null) {
			_originalWorkflowDefinitionName = _workflowDefinitionName;
		}

		_workflowDefinitionName = workflowDefinitionName;
	}

	public String getOriginalWorkflowDefinitionName() {
		return GetterUtil.getString(_originalWorkflowDefinitionName);
	}

	@Override
	public int getWorkflowDefinitionVersion() {
		return _workflowDefinitionVersion;
	}

	@Override
	public void setWorkflowDefinitionVersion(int workflowDefinitionVersion) {
		_columnBitmask |= WORKFLOWDEFINITIONVERSION_COLUMN_BITMASK;

		if (!_setOriginalWorkflowDefinitionVersion) {
			_setOriginalWorkflowDefinitionVersion = true;

			_originalWorkflowDefinitionVersion = _workflowDefinitionVersion;
		}

		_workflowDefinitionVersion = workflowDefinitionVersion;
	}

	public int getOriginalWorkflowDefinitionVersion() {
		return _originalWorkflowDefinitionVersion;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			WorkflowDefinitionLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WorkflowDefinitionLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WorkflowDefinitionLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WorkflowDefinitionLinkImpl workflowDefinitionLinkImpl = new WorkflowDefinitionLinkImpl();

		workflowDefinitionLinkImpl.setMvccVersion(getMvccVersion());
		workflowDefinitionLinkImpl.setWorkflowDefinitionLinkId(getWorkflowDefinitionLinkId());
		workflowDefinitionLinkImpl.setGroupId(getGroupId());
		workflowDefinitionLinkImpl.setCompanyId(getCompanyId());
		workflowDefinitionLinkImpl.setUserId(getUserId());
		workflowDefinitionLinkImpl.setUserName(getUserName());
		workflowDefinitionLinkImpl.setCreateDate(getCreateDate());
		workflowDefinitionLinkImpl.setModifiedDate(getModifiedDate());
		workflowDefinitionLinkImpl.setClassNameId(getClassNameId());
		workflowDefinitionLinkImpl.setClassPK(getClassPK());
		workflowDefinitionLinkImpl.setTypePK(getTypePK());
		workflowDefinitionLinkImpl.setWorkflowDefinitionName(getWorkflowDefinitionName());
		workflowDefinitionLinkImpl.setWorkflowDefinitionVersion(getWorkflowDefinitionVersion());

		workflowDefinitionLinkImpl.resetOriginalValues();

		return workflowDefinitionLinkImpl;
	}

	@Override
	public int compareTo(WorkflowDefinitionLink workflowDefinitionLink) {
		int value = 0;

		value = getWorkflowDefinitionName()
					.compareTo(workflowDefinitionLink.getWorkflowDefinitionName());

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

		if (!(obj instanceof WorkflowDefinitionLink)) {
			return false;
		}

		WorkflowDefinitionLink workflowDefinitionLink = (WorkflowDefinitionLink)obj;

		long primaryKey = workflowDefinitionLink.getPrimaryKey();

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
		WorkflowDefinitionLinkModelImpl workflowDefinitionLinkModelImpl = this;

		workflowDefinitionLinkModelImpl._originalGroupId = workflowDefinitionLinkModelImpl._groupId;

		workflowDefinitionLinkModelImpl._setOriginalGroupId = false;

		workflowDefinitionLinkModelImpl._originalCompanyId = workflowDefinitionLinkModelImpl._companyId;

		workflowDefinitionLinkModelImpl._setOriginalCompanyId = false;

		workflowDefinitionLinkModelImpl._setModifiedDate = false;

		workflowDefinitionLinkModelImpl._originalClassNameId = workflowDefinitionLinkModelImpl._classNameId;

		workflowDefinitionLinkModelImpl._setOriginalClassNameId = false;

		workflowDefinitionLinkModelImpl._originalClassPK = workflowDefinitionLinkModelImpl._classPK;

		workflowDefinitionLinkModelImpl._setOriginalClassPK = false;

		workflowDefinitionLinkModelImpl._originalTypePK = workflowDefinitionLinkModelImpl._typePK;

		workflowDefinitionLinkModelImpl._setOriginalTypePK = false;

		workflowDefinitionLinkModelImpl._originalWorkflowDefinitionName = workflowDefinitionLinkModelImpl._workflowDefinitionName;

		workflowDefinitionLinkModelImpl._originalWorkflowDefinitionVersion = workflowDefinitionLinkModelImpl._workflowDefinitionVersion;

		workflowDefinitionLinkModelImpl._setOriginalWorkflowDefinitionVersion = false;

		workflowDefinitionLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WorkflowDefinitionLink> toCacheModel() {
		WorkflowDefinitionLinkCacheModel workflowDefinitionLinkCacheModel = new WorkflowDefinitionLinkCacheModel();

		workflowDefinitionLinkCacheModel.mvccVersion = getMvccVersion();

		workflowDefinitionLinkCacheModel.workflowDefinitionLinkId = getWorkflowDefinitionLinkId();

		workflowDefinitionLinkCacheModel.groupId = getGroupId();

		workflowDefinitionLinkCacheModel.companyId = getCompanyId();

		workflowDefinitionLinkCacheModel.userId = getUserId();

		workflowDefinitionLinkCacheModel.userName = getUserName();

		String userName = workflowDefinitionLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			workflowDefinitionLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			workflowDefinitionLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			workflowDefinitionLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			workflowDefinitionLinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			workflowDefinitionLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		workflowDefinitionLinkCacheModel.classNameId = getClassNameId();

		workflowDefinitionLinkCacheModel.classPK = getClassPK();

		workflowDefinitionLinkCacheModel.typePK = getTypePK();

		workflowDefinitionLinkCacheModel.workflowDefinitionName = getWorkflowDefinitionName();

		String workflowDefinitionName = workflowDefinitionLinkCacheModel.workflowDefinitionName;

		if ((workflowDefinitionName != null) &&
				(workflowDefinitionName.length() == 0)) {
			workflowDefinitionLinkCacheModel.workflowDefinitionName = null;
		}

		workflowDefinitionLinkCacheModel.workflowDefinitionVersion = getWorkflowDefinitionVersion();

		return workflowDefinitionLinkCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<WorkflowDefinitionLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<WorkflowDefinitionLink, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<WorkflowDefinitionLink, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply(
					(WorkflowDefinitionLink)this));
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
		Map<String, Function<WorkflowDefinitionLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<WorkflowDefinitionLink, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<WorkflowDefinitionLink, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply(
					(WorkflowDefinitionLink)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = WorkflowDefinitionLink.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			WorkflowDefinitionLink.class, ModelWrapper.class
		};
	private long _mvccVersion;
	private long _workflowDefinitionLinkId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _typePK;
	private long _originalTypePK;
	private boolean _setOriginalTypePK;
	private String _workflowDefinitionName;
	private String _originalWorkflowDefinitionName;
	private int _workflowDefinitionVersion;
	private int _originalWorkflowDefinitionVersion;
	private boolean _setOriginalWorkflowDefinitionVersion;
	private long _columnBitmask;
	private WorkflowDefinitionLink _escapedModel;
}