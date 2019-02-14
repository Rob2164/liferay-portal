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

package com.liferay.counter.kernel.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CounterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CounterLocalService
 * @generated
 */
@ProviderType
public class CounterLocalServiceWrapper implements CounterLocalService,
	ServiceWrapper<CounterLocalService> {
	public CounterLocalServiceWrapper(CounterLocalService counterLocalService) {
		_counterLocalService = counterLocalService;
	}

	/**
	* Adds the counter to the database. Also notifies the appropriate model listeners.
	*
	* @param counter the counter
	* @return the counter that was added
	*/
	@Override
	public com.liferay.counter.kernel.model.Counter addCounter(
		com.liferay.counter.kernel.model.Counter counter) {
		return _counterLocalService.addCounter(counter);
	}

	/**
	* Creates a new counter with the primary key. Does not add the counter to the database.
	*
	* @param name the primary key for the new counter
	* @return the new counter
	*/
	@Override
	public com.liferay.counter.kernel.model.Counter createCounter(String name) {
		return _counterLocalService.createCounter(name);
	}

	/**
	* Deletes the counter from the database. Also notifies the appropriate model listeners.
	*
	* @param counter the counter
	* @return the counter that was removed
	*/
	@Override
	public com.liferay.counter.kernel.model.Counter deleteCounter(
		com.liferay.counter.kernel.model.Counter counter) {
		return _counterLocalService.deleteCounter(counter);
	}

	/**
	* Deletes the counter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param name the primary key of the counter
	* @return the counter that was removed
	* @throws PortalException if a counter with the primary key could not be found
	*/
	@Override
	public com.liferay.counter.kernel.model.Counter deleteCounter(String name)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _counterLocalService.deleteCounter(name);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _counterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _counterLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _counterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.counter.model.impl.CounterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _counterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.counter.model.impl.CounterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _counterLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _counterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _counterLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.counter.kernel.model.Counter fetchCounter(String name) {
		return _counterLocalService.fetchCounter(name);
	}

	/**
	* Returns the counter with the primary key.
	*
	* @param name the primary key of the counter
	* @return the counter
	* @throws PortalException if a counter with the primary key could not be found
	*/
	@Override
	public com.liferay.counter.kernel.model.Counter getCounter(String name)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _counterLocalService.getCounter(name);
	}

	/**
	* Returns a range of all the counters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.counter.model.impl.CounterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of counters
	* @param end the upper bound of the range of counters (not inclusive)
	* @return the range of counters
	*/
	@Override
	public java.util.List<com.liferay.counter.kernel.model.Counter> getCounters(
		int start, int end) {
		return _counterLocalService.getCounters(start, end);
	}

	/**
	* Returns the number of counters.
	*
	* @return the number of counters
	*/
	@Override
	public int getCountersCount() {
		return _counterLocalService.getCountersCount();
	}

	@Override
	public java.util.List<String> getNames() {
		return _counterLocalService.getNames();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _counterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _counterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public long increment() {
		return _counterLocalService.increment();
	}

	@Override
	public long increment(String name) {
		return _counterLocalService.increment(name);
	}

	@Override
	public long increment(String name, int size) {
		return _counterLocalService.increment(name, size);
	}

	@Override
	public void rename(String oldName, String newName) {
		_counterLocalService.rename(oldName, newName);
	}

	@Override
	public void reset(String name) {
		_counterLocalService.reset(name);
	}

	@Override
	public void reset(String name, long size) {
		_counterLocalService.reset(name, size);
	}

	/**
	* Updates the counter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param counter the counter
	* @return the counter that was updated
	*/
	@Override
	public com.liferay.counter.kernel.model.Counter updateCounter(
		com.liferay.counter.kernel.model.Counter counter) {
		return _counterLocalService.updateCounter(counter);
	}

	@Override
	public CounterLocalService getWrappedService() {
		return _counterLocalService;
	}

	@Override
	public void setWrappedService(CounterLocalService counterLocalService) {
		_counterLocalService = counterLocalService;
	}

	private CounterLocalService _counterLocalService;
}