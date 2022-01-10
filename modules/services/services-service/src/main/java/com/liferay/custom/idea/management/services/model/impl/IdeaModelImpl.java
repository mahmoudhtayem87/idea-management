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

package com.liferay.custom.idea.management.services.model.impl;

import com.liferay.custom.idea.management.services.model.Idea;
import com.liferay.custom.idea.management.services.model.IdeaModel;
import com.liferay.custom.idea.management.services.model.IdeaSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Idea service. Represents a row in the &quot;IdeaManagement_Idea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>IdeaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IdeaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IdeaImpl
 * @generated
 */
@JSON(strict = true)
public class IdeaModelImpl extends BaseModelImpl<Idea> implements IdeaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a idea model instance should use the <code>Idea</code> interface instead.
	 */
	public static final String TABLE_NAME = "IdeaManagement_Idea";

	public static final Object[][] TABLE_COLUMNS = {
		{"ideaId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"title", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"content", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ideaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table IdeaManagement_Idea (ideaId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,description VARCHAR(75) null,content TEXT null)";

	public static final String TABLE_SQL_DROP =
		"drop table IdeaManagement_Idea";

	public static final String ORDER_BY_JPQL = " ORDER BY idea.ideaId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY IdeaManagement_Idea.ideaId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long IDEAID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Idea toModel(IdeaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Idea model = new IdeaImpl();

		model.setIdeaId(soapModel.getIdeaId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setContent(soapModel.getContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Idea> toModels(IdeaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Idea> models = new ArrayList<Idea>(soapModels.length);

		for (IdeaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public IdeaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ideaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdeaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ideaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Idea.class;
	}

	@Override
	public String getModelClassName() {
		return Idea.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Idea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Idea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Idea, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Idea)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Idea, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Idea, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Idea)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Idea, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Idea, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Idea>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Idea.class.getClassLoader(), Idea.class, ModelWrapper.class);

		try {
			Constructor<Idea> constructor =
				(Constructor<Idea>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Idea, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Idea, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Idea, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Idea, Object>>();
		Map<String, BiConsumer<Idea, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Idea, ?>>();

		attributeGetterFunctions.put("ideaId", Idea::getIdeaId);
		attributeSetterBiConsumers.put(
			"ideaId", (BiConsumer<Idea, Long>)Idea::setIdeaId);
		attributeGetterFunctions.put("groupId", Idea::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Idea, Long>)Idea::setGroupId);
		attributeGetterFunctions.put("companyId", Idea::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Idea, Long>)Idea::setCompanyId);
		attributeGetterFunctions.put("userId", Idea::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Idea, Long>)Idea::setUserId);
		attributeGetterFunctions.put("userName", Idea::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Idea, String>)Idea::setUserName);
		attributeGetterFunctions.put("createDate", Idea::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Idea, Date>)Idea::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Idea::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Idea, Date>)Idea::setModifiedDate);
		attributeGetterFunctions.put("title", Idea::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<Idea, String>)Idea::setTitle);
		attributeGetterFunctions.put("description", Idea::getDescription);
		attributeSetterBiConsumers.put(
			"description", (BiConsumer<Idea, String>)Idea::setDescription);
		attributeGetterFunctions.put("content", Idea::getContent);
		attributeSetterBiConsumers.put(
			"content", (BiConsumer<Idea, String>)Idea::setContent);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getIdeaId() {
		return _ideaId;
	}

	@Override
	public void setIdeaId(long ideaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ideaId = ideaId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_content = content;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Idea.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Idea toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Idea>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		IdeaImpl ideaImpl = new IdeaImpl();

		ideaImpl.setIdeaId(getIdeaId());
		ideaImpl.setGroupId(getGroupId());
		ideaImpl.setCompanyId(getCompanyId());
		ideaImpl.setUserId(getUserId());
		ideaImpl.setUserName(getUserName());
		ideaImpl.setCreateDate(getCreateDate());
		ideaImpl.setModifiedDate(getModifiedDate());
		ideaImpl.setTitle(getTitle());
		ideaImpl.setDescription(getDescription());
		ideaImpl.setContent(getContent());

		ideaImpl.resetOriginalValues();

		return ideaImpl;
	}

	@Override
	public Idea cloneWithOriginalValues() {
		IdeaImpl ideaImpl = new IdeaImpl();

		ideaImpl.setIdeaId(this.<Long>getColumnOriginalValue("ideaId"));
		ideaImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		ideaImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		ideaImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		ideaImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		ideaImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		ideaImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		ideaImpl.setTitle(this.<String>getColumnOriginalValue("title"));
		ideaImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		ideaImpl.setContent(this.<String>getColumnOriginalValue("content"));

		return ideaImpl;
	}

	@Override
	public int compareTo(Idea idea) {
		long primaryKey = idea.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Idea)) {
			return false;
		}

		Idea idea = (Idea)object;

		long primaryKey = idea.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Idea> toCacheModel() {
		IdeaCacheModel ideaCacheModel = new IdeaCacheModel();

		ideaCacheModel.ideaId = getIdeaId();

		ideaCacheModel.groupId = getGroupId();

		ideaCacheModel.companyId = getCompanyId();

		ideaCacheModel.userId = getUserId();

		ideaCacheModel.userName = getUserName();

		String userName = ideaCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ideaCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ideaCacheModel.createDate = createDate.getTime();
		}
		else {
			ideaCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ideaCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ideaCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ideaCacheModel.title = getTitle();

		String title = ideaCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			ideaCacheModel.title = null;
		}

		ideaCacheModel.description = getDescription();

		String description = ideaCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			ideaCacheModel.description = null;
		}

		ideaCacheModel.content = getContent();

		String content = ideaCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			ideaCacheModel.content = null;
		}

		return ideaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Idea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Idea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Idea, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Idea)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

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
		Map<String, Function<Idea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Idea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Idea, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Idea)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Idea>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _ideaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _title;
	private String _description;
	private String _content;

	public <T> T getColumnValue(String columnName) {
		Function<Idea, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Idea)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("ideaId", _ideaId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("content", _content);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("ideaId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("title", 128L);

		columnBitmasks.put("description", 256L);

		columnBitmasks.put("content", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Idea _escapedModel;

}