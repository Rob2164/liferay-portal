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

package com.liferay.fragment.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.fragment.model.FragmentEntryLinkModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
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
 * The base model implementation for the FragmentEntryLink service. Represents a row in the &quot;FragmentEntryLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>FragmentEntryLinkModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FragmentEntryLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FragmentEntryLinkImpl
 * @generated
 */
@ProviderType
public class FragmentEntryLinkModelImpl extends BaseModelImpl<FragmentEntryLink>
	implements FragmentEntryLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fragment entry link model instance should use the <code>FragmentEntryLink</code> interface instead.
	 */
	public static final String TABLE_NAME = "FragmentEntryLink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "fragmentEntryLinkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "originalFragmentEntryLinkId", Types.BIGINT },
			{ "fragmentEntryId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "css", Types.VARCHAR },
			{ "html", Types.VARCHAR },
			{ "js", Types.VARCHAR },
			{ "editableValues", Types.VARCHAR },
			{ "position", Types.INTEGER },
			{ "lastPropagationDate", Types.TIMESTAMP },
			{ "namespace", Types.VARCHAR },
			{ "lastPublishDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fragmentEntryLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("originalFragmentEntryLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fragmentEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("css", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("html", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("js", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("editableValues", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("position", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPropagationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("namespace", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table FragmentEntryLink (uuid_ VARCHAR(75) null,fragmentEntryLinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,originalFragmentEntryLinkId LONG,fragmentEntryId LONG,classNameId LONG,classPK LONG,css STRING null,html STRING null,js STRING null,editableValues STRING null,position INTEGER,lastPropagationDate DATE null,namespace VARCHAR(75) null,lastPublishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table FragmentEntryLink";
	public static final String ORDER_BY_JPQL = " ORDER BY fragmentEntryLink.classNameId ASC, fragmentEntryLink.classPK ASC, fragmentEntryLink.position ASC";
	public static final String ORDER_BY_SQL = " ORDER BY FragmentEntryLink.classNameId ASC, FragmentEntryLink.classPK ASC, FragmentEntryLink.position ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.fragment.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.fragment.model.FragmentEntryLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.fragment.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.fragment.model.FragmentEntryLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.fragment.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.fragment.model.FragmentEntryLink"),
			true);
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static final long CLASSPK_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long FRAGMENTENTRYID_COLUMN_BITMASK = 8L;
	public static final long GROUPID_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long POSITION_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.fragment.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.fragment.model.FragmentEntryLink"));

	public FragmentEntryLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fragmentEntryLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFragmentEntryLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fragmentEntryLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FragmentEntryLink.class;
	}

	@Override
	public String getModelClassName() {
		return FragmentEntryLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FragmentEntryLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FragmentEntryLink, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<FragmentEntryLink, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((FragmentEntryLink)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FragmentEntryLink, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FragmentEntryLink, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((FragmentEntryLink)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<FragmentEntryLink, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FragmentEntryLink, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<FragmentEntryLink, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<FragmentEntryLink, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<FragmentEntryLink, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<FragmentEntryLink, Object>>();
		Map<String, BiConsumer<FragmentEntryLink, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<FragmentEntryLink, ?>>();


		attributeGetterFunctions.put(
			"uuid",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object uuid) {
					fragmentEntryLink.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"fragmentEntryLinkId",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getFragmentEntryLinkId();
				}

			});
		attributeSetterBiConsumers.put(
			"fragmentEntryLinkId",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object fragmentEntryLinkId) {
					fragmentEntryLink.setFragmentEntryLinkId((Long)fragmentEntryLinkId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object groupId) {
					fragmentEntryLink.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object companyId) {
					fragmentEntryLink.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object userId) {
					fragmentEntryLink.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object userName) {
					fragmentEntryLink.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object createDate) {
					fragmentEntryLink.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object modifiedDate) {
					fragmentEntryLink.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"originalFragmentEntryLinkId",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getOriginalFragmentEntryLinkId();
				}

			});
		attributeSetterBiConsumers.put(
			"originalFragmentEntryLinkId",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object originalFragmentEntryLinkId) {
					fragmentEntryLink.setOriginalFragmentEntryLinkId((Long)originalFragmentEntryLinkId);
				}

			});
		attributeGetterFunctions.put(
			"fragmentEntryId",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getFragmentEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"fragmentEntryId",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object fragmentEntryId) {
					fragmentEntryLink.setFragmentEntryId((Long)fragmentEntryId);
				}

			});
		attributeGetterFunctions.put(
			"classNameId",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getClassNameId();
				}

			});
		attributeSetterBiConsumers.put(
			"classNameId",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object classNameId) {
					fragmentEntryLink.setClassNameId((Long)classNameId);
				}

			});
		attributeGetterFunctions.put(
			"classPK",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"classPK",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object classPK) {
					fragmentEntryLink.setClassPK((Long)classPK);
				}

			});
		attributeGetterFunctions.put(
			"css",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getCss();
				}

			});
		attributeSetterBiConsumers.put(
			"css",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object css) {
					fragmentEntryLink.setCss((String)css);
				}

			});
		attributeGetterFunctions.put(
			"html",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getHtml();
				}

			});
		attributeSetterBiConsumers.put(
			"html",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object html) {
					fragmentEntryLink.setHtml((String)html);
				}

			});
		attributeGetterFunctions.put(
			"js",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getJs();
				}

			});
		attributeSetterBiConsumers.put(
			"js",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object js) {
					fragmentEntryLink.setJs((String)js);
				}

			});
		attributeGetterFunctions.put(
			"editableValues",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getEditableValues();
				}

			});
		attributeSetterBiConsumers.put(
			"editableValues",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object editableValues) {
					fragmentEntryLink.setEditableValues((String)editableValues);
				}

			});
		attributeGetterFunctions.put(
			"position",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getPosition();
				}

			});
		attributeSetterBiConsumers.put(
			"position",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object position) {
					fragmentEntryLink.setPosition((Integer)position);
				}

			});
		attributeGetterFunctions.put(
			"lastPropagationDate",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getLastPropagationDate();
				}

			});
		attributeSetterBiConsumers.put(
			"lastPropagationDate",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object lastPropagationDate) {
					fragmentEntryLink.setLastPropagationDate((Date)lastPropagationDate);
				}

			});
		attributeGetterFunctions.put(
			"namespace",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getNamespace();
				}

			});
		attributeSetterBiConsumers.put(
			"namespace",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object namespace) {
					fragmentEntryLink.setNamespace((String)namespace);
				}

			});
		attributeGetterFunctions.put(
			"lastPublishDate",
			new Function<FragmentEntryLink, Object>() {

				@Override
				public Object apply(FragmentEntryLink fragmentEntryLink) {
					return fragmentEntryLink.getLastPublishDate();
				}

			});
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			new BiConsumer<FragmentEntryLink, Object>() {

				@Override
				public void accept(FragmentEntryLink fragmentEntryLink, Object lastPublishDate) {
					fragmentEntryLink.setLastPublishDate((Date)lastPublishDate);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getFragmentEntryLinkId() {
		return _fragmentEntryLinkId;
	}

	@Override
	public void setFragmentEntryLinkId(long fragmentEntryLinkId) {
		_fragmentEntryLinkId = fragmentEntryLinkId;
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
	public long getOriginalFragmentEntryLinkId() {
		return _originalFragmentEntryLinkId;
	}

	@Override
	public void setOriginalFragmentEntryLinkId(long originalFragmentEntryLinkId) {
		_originalFragmentEntryLinkId = originalFragmentEntryLinkId;
	}

	@Override
	public long getFragmentEntryId() {
		return _fragmentEntryId;
	}

	@Override
	public void setFragmentEntryId(long fragmentEntryId) {
		_columnBitmask |= FRAGMENTENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFragmentEntryId) {
			_setOriginalFragmentEntryId = true;

			_originalFragmentEntryId = _fragmentEntryId;
		}

		_fragmentEntryId = fragmentEntryId;
	}

	public long getOriginalFragmentEntryId() {
		return _originalFragmentEntryId;
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
		_columnBitmask = -1L;

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
		_columnBitmask = -1L;

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
	public String getCss() {
		if (_css == null) {
			return "";
		}
		else {
			return _css;
		}
	}

	@Override
	public void setCss(String css) {
		_css = css;
	}

	@Override
	public String getHtml() {
		if (_html == null) {
			return "";
		}
		else {
			return _html;
		}
	}

	@Override
	public void setHtml(String html) {
		_html = html;
	}

	@Override
	public String getJs() {
		if (_js == null) {
			return "";
		}
		else {
			return _js;
		}
	}

	@Override
	public void setJs(String js) {
		_js = js;
	}

	@Override
	public String getEditableValues() {
		if (_editableValues == null) {
			return "";
		}
		else {
			return _editableValues;
		}
	}

	@Override
	public void setEditableValues(String editableValues) {
		_editableValues = editableValues;
	}

	@Override
	public int getPosition() {
		return _position;
	}

	@Override
	public void setPosition(int position) {
		_columnBitmask = -1L;

		_position = position;
	}

	@Override
	public Date getLastPropagationDate() {
		return _lastPropagationDate;
	}

	@Override
	public void setLastPropagationDate(Date lastPropagationDate) {
		_lastPropagationDate = lastPropagationDate;
	}

	@Override
	public String getNamespace() {
		if (_namespace == null) {
			return "";
		}
		else {
			return _namespace;
		}
	}

	@Override
	public void setNamespace(String namespace) {
		_namespace = namespace;
	}

	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				FragmentEntryLink.class.getName()), getClassNameId());
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			FragmentEntryLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FragmentEntryLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FragmentEntryLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FragmentEntryLinkImpl fragmentEntryLinkImpl = new FragmentEntryLinkImpl();

		fragmentEntryLinkImpl.setUuid(getUuid());
		fragmentEntryLinkImpl.setFragmentEntryLinkId(getFragmentEntryLinkId());
		fragmentEntryLinkImpl.setGroupId(getGroupId());
		fragmentEntryLinkImpl.setCompanyId(getCompanyId());
		fragmentEntryLinkImpl.setUserId(getUserId());
		fragmentEntryLinkImpl.setUserName(getUserName());
		fragmentEntryLinkImpl.setCreateDate(getCreateDate());
		fragmentEntryLinkImpl.setModifiedDate(getModifiedDate());
		fragmentEntryLinkImpl.setOriginalFragmentEntryLinkId(getOriginalFragmentEntryLinkId());
		fragmentEntryLinkImpl.setFragmentEntryId(getFragmentEntryId());
		fragmentEntryLinkImpl.setClassNameId(getClassNameId());
		fragmentEntryLinkImpl.setClassPK(getClassPK());
		fragmentEntryLinkImpl.setCss(getCss());
		fragmentEntryLinkImpl.setHtml(getHtml());
		fragmentEntryLinkImpl.setJs(getJs());
		fragmentEntryLinkImpl.setEditableValues(getEditableValues());
		fragmentEntryLinkImpl.setPosition(getPosition());
		fragmentEntryLinkImpl.setLastPropagationDate(getLastPropagationDate());
		fragmentEntryLinkImpl.setNamespace(getNamespace());
		fragmentEntryLinkImpl.setLastPublishDate(getLastPublishDate());

		fragmentEntryLinkImpl.resetOriginalValues();

		return fragmentEntryLinkImpl;
	}

	@Override
	public int compareTo(FragmentEntryLink fragmentEntryLink) {
		int value = 0;

		if (getClassNameId() < fragmentEntryLink.getClassNameId()) {
			value = -1;
		}
		else if (getClassNameId() > fragmentEntryLink.getClassNameId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getClassPK() < fragmentEntryLink.getClassPK()) {
			value = -1;
		}
		else if (getClassPK() > fragmentEntryLink.getClassPK()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getPosition() < fragmentEntryLink.getPosition()) {
			value = -1;
		}
		else if (getPosition() > fragmentEntryLink.getPosition()) {
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

		if (!(obj instanceof FragmentEntryLink)) {
			return false;
		}

		FragmentEntryLink fragmentEntryLink = (FragmentEntryLink)obj;

		long primaryKey = fragmentEntryLink.getPrimaryKey();

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
		FragmentEntryLinkModelImpl fragmentEntryLinkModelImpl = this;

		fragmentEntryLinkModelImpl._originalUuid = fragmentEntryLinkModelImpl._uuid;

		fragmentEntryLinkModelImpl._originalGroupId = fragmentEntryLinkModelImpl._groupId;

		fragmentEntryLinkModelImpl._setOriginalGroupId = false;

		fragmentEntryLinkModelImpl._originalCompanyId = fragmentEntryLinkModelImpl._companyId;

		fragmentEntryLinkModelImpl._setOriginalCompanyId = false;

		fragmentEntryLinkModelImpl._setModifiedDate = false;

		fragmentEntryLinkModelImpl._originalFragmentEntryId = fragmentEntryLinkModelImpl._fragmentEntryId;

		fragmentEntryLinkModelImpl._setOriginalFragmentEntryId = false;

		fragmentEntryLinkModelImpl._originalClassNameId = fragmentEntryLinkModelImpl._classNameId;

		fragmentEntryLinkModelImpl._setOriginalClassNameId = false;

		fragmentEntryLinkModelImpl._originalClassPK = fragmentEntryLinkModelImpl._classPK;

		fragmentEntryLinkModelImpl._setOriginalClassPK = false;

		fragmentEntryLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FragmentEntryLink> toCacheModel() {
		FragmentEntryLinkCacheModel fragmentEntryLinkCacheModel = new FragmentEntryLinkCacheModel();

		fragmentEntryLinkCacheModel.uuid = getUuid();

		String uuid = fragmentEntryLinkCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			fragmentEntryLinkCacheModel.uuid = null;
		}

		fragmentEntryLinkCacheModel.fragmentEntryLinkId = getFragmentEntryLinkId();

		fragmentEntryLinkCacheModel.groupId = getGroupId();

		fragmentEntryLinkCacheModel.companyId = getCompanyId();

		fragmentEntryLinkCacheModel.userId = getUserId();

		fragmentEntryLinkCacheModel.userName = getUserName();

		String userName = fragmentEntryLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			fragmentEntryLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			fragmentEntryLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			fragmentEntryLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fragmentEntryLinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fragmentEntryLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fragmentEntryLinkCacheModel.originalFragmentEntryLinkId = getOriginalFragmentEntryLinkId();

		fragmentEntryLinkCacheModel.fragmentEntryId = getFragmentEntryId();

		fragmentEntryLinkCacheModel.classNameId = getClassNameId();

		fragmentEntryLinkCacheModel.classPK = getClassPK();

		fragmentEntryLinkCacheModel.css = getCss();

		String css = fragmentEntryLinkCacheModel.css;

		if ((css != null) && (css.length() == 0)) {
			fragmentEntryLinkCacheModel.css = null;
		}

		fragmentEntryLinkCacheModel.html = getHtml();

		String html = fragmentEntryLinkCacheModel.html;

		if ((html != null) && (html.length() == 0)) {
			fragmentEntryLinkCacheModel.html = null;
		}

		fragmentEntryLinkCacheModel.js = getJs();

		String js = fragmentEntryLinkCacheModel.js;

		if ((js != null) && (js.length() == 0)) {
			fragmentEntryLinkCacheModel.js = null;
		}

		fragmentEntryLinkCacheModel.editableValues = getEditableValues();

		String editableValues = fragmentEntryLinkCacheModel.editableValues;

		if ((editableValues != null) && (editableValues.length() == 0)) {
			fragmentEntryLinkCacheModel.editableValues = null;
		}

		fragmentEntryLinkCacheModel.position = getPosition();

		Date lastPropagationDate = getLastPropagationDate();

		if (lastPropagationDate != null) {
			fragmentEntryLinkCacheModel.lastPropagationDate = lastPropagationDate.getTime();
		}
		else {
			fragmentEntryLinkCacheModel.lastPropagationDate = Long.MIN_VALUE;
		}

		fragmentEntryLinkCacheModel.namespace = getNamespace();

		String namespace = fragmentEntryLinkCacheModel.namespace;

		if ((namespace != null) && (namespace.length() == 0)) {
			fragmentEntryLinkCacheModel.namespace = null;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			fragmentEntryLinkCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			fragmentEntryLinkCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return fragmentEntryLinkCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FragmentEntryLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<FragmentEntryLink, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<FragmentEntryLink, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((FragmentEntryLink)this));
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
		Map<String, Function<FragmentEntryLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FragmentEntryLink, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<FragmentEntryLink, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((FragmentEntryLink)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = FragmentEntryLink.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			FragmentEntryLink.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _fragmentEntryLinkId;
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
	private long _originalFragmentEntryLinkId;
	private long _fragmentEntryId;
	private long _originalFragmentEntryId;
	private boolean _setOriginalFragmentEntryId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _css;
	private String _html;
	private String _js;
	private String _editableValues;
	private int _position;
	private Date _lastPropagationDate;
	private String _namespace;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private FragmentEntryLink _escapedModel;
}