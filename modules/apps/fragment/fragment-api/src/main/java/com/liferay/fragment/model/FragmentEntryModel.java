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

package com.liferay.fragment.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FragmentEntry service. Represents a row in the &quot;FragmentEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.fragment.model.impl.FragmentEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.fragment.model.impl.FragmentEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FragmentEntry
 * @generated
 */
@ProviderType
public interface FragmentEntryModel extends BaseModel<FragmentEntry>,
	ShardedModel, StagedGroupedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fragment entry model instance should use the {@link FragmentEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this fragment entry.
	 *
	 * @return the primary key of this fragment entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fragment entry.
	 *
	 * @param primaryKey the primary key of this fragment entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this fragment entry.
	 *
	 * @return the uuid of this fragment entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this fragment entry.
	 *
	 * @param uuid the uuid of this fragment entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the fragment entry ID of this fragment entry.
	 *
	 * @return the fragment entry ID of this fragment entry
	 */
	public long getFragmentEntryId();

	/**
	 * Sets the fragment entry ID of this fragment entry.
	 *
	 * @param fragmentEntryId the fragment entry ID of this fragment entry
	 */
	public void setFragmentEntryId(long fragmentEntryId);

	/**
	 * Returns the group ID of this fragment entry.
	 *
	 * @return the group ID of this fragment entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this fragment entry.
	 *
	 * @param groupId the group ID of this fragment entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this fragment entry.
	 *
	 * @return the company ID of this fragment entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this fragment entry.
	 *
	 * @param companyId the company ID of this fragment entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this fragment entry.
	 *
	 * @return the user ID of this fragment entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this fragment entry.
	 *
	 * @param userId the user ID of this fragment entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fragment entry.
	 *
	 * @return the user uuid of this fragment entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this fragment entry.
	 *
	 * @param userUuid the user uuid of this fragment entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fragment entry.
	 *
	 * @return the user name of this fragment entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this fragment entry.
	 *
	 * @param userName the user name of this fragment entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fragment entry.
	 *
	 * @return the create date of this fragment entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this fragment entry.
	 *
	 * @param createDate the create date of this fragment entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this fragment entry.
	 *
	 * @return the modified date of this fragment entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this fragment entry.
	 *
	 * @param modifiedDate the modified date of this fragment entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fragment collection ID of this fragment entry.
	 *
	 * @return the fragment collection ID of this fragment entry
	 */
	public long getFragmentCollectionId();

	/**
	 * Sets the fragment collection ID of this fragment entry.
	 *
	 * @param fragmentCollectionId the fragment collection ID of this fragment entry
	 */
	public void setFragmentCollectionId(long fragmentCollectionId);

	/**
	 * Returns the fragment entry key of this fragment entry.
	 *
	 * @return the fragment entry key of this fragment entry
	 */
	@AutoEscape
	public String getFragmentEntryKey();

	/**
	 * Sets the fragment entry key of this fragment entry.
	 *
	 * @param fragmentEntryKey the fragment entry key of this fragment entry
	 */
	public void setFragmentEntryKey(String fragmentEntryKey);

	/**
	 * Returns the name of this fragment entry.
	 *
	 * @return the name of this fragment entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this fragment entry.
	 *
	 * @param name the name of this fragment entry
	 */
	public void setName(String name);

	/**
	 * Returns the css of this fragment entry.
	 *
	 * @return the css of this fragment entry
	 */
	@AutoEscape
	public String getCss();

	/**
	 * Sets the css of this fragment entry.
	 *
	 * @param css the css of this fragment entry
	 */
	public void setCss(String css);

	/**
	 * Returns the html of this fragment entry.
	 *
	 * @return the html of this fragment entry
	 */
	@AutoEscape
	public String getHtml();

	/**
	 * Sets the html of this fragment entry.
	 *
	 * @param html the html of this fragment entry
	 */
	public void setHtml(String html);

	/**
	 * Returns the js of this fragment entry.
	 *
	 * @return the js of this fragment entry
	 */
	@AutoEscape
	public String getJs();

	/**
	 * Sets the js of this fragment entry.
	 *
	 * @param js the js of this fragment entry
	 */
	public void setJs(String js);

	/**
	 * Returns the preview file entry ID of this fragment entry.
	 *
	 * @return the preview file entry ID of this fragment entry
	 */
	public long getPreviewFileEntryId();

	/**
	 * Sets the preview file entry ID of this fragment entry.
	 *
	 * @param previewFileEntryId the preview file entry ID of this fragment entry
	 */
	public void setPreviewFileEntryId(long previewFileEntryId);

	/**
	 * Returns the last publish date of this fragment entry.
	 *
	 * @return the last publish date of this fragment entry
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this fragment entry.
	 *
	 * @param lastPublishDate the last publish date of this fragment entry
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this fragment entry.
	 *
	 * @return the status of this fragment entry
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this fragment entry.
	 *
	 * @param status the status of this fragment entry
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this fragment entry.
	 *
	 * @return the status by user ID of this fragment entry
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this fragment entry.
	 *
	 * @param statusByUserId the status by user ID of this fragment entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this fragment entry.
	 *
	 * @return the status by user uuid of this fragment entry
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this fragment entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this fragment entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this fragment entry.
	 *
	 * @return the status by user name of this fragment entry
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this fragment entry.
	 *
	 * @param statusByUserName the status by user name of this fragment entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this fragment entry.
	 *
	 * @return the status date of this fragment entry
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this fragment entry.
	 *
	 * @param statusDate the status date of this fragment entry
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this fragment entry is approved.
	 *
	 * @return <code>true</code> if this fragment entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this fragment entry is denied.
	 *
	 * @return <code>true</code> if this fragment entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this fragment entry is a draft.
	 *
	 * @return <code>true</code> if this fragment entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this fragment entry is expired.
	 *
	 * @return <code>true</code> if this fragment entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this fragment entry is inactive.
	 *
	 * @return <code>true</code> if this fragment entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this fragment entry is incomplete.
	 *
	 * @return <code>true</code> if this fragment entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this fragment entry is pending.
	 *
	 * @return <code>true</code> if this fragment entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this fragment entry is scheduled.
	 *
	 * @return <code>true</code> if this fragment entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(FragmentEntry fragmentEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<FragmentEntry> toCacheModel();

	@Override
	public FragmentEntry toEscapedModel();

	@Override
	public FragmentEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}