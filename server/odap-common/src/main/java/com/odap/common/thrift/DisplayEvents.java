/* 
 *   This file is part of the Open Database Audit Project (ODAP).
 *
 *   ODAP is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Foobar is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   The code was developed by Rob Williams
 */
/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.odap.common.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayEvents {

  public interface Iface {

    public List<DisplayEvent> getEventsByRowID(short server_id, String row_id, String database_type) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void getEventsByRowID(short server_id, String row_id, String database_type, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.getEventsByRowID_call> resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public List<DisplayEvent> getEventsByRowID(short server_id, String row_id, String database_type) throws org.apache.thrift.TException
    {
      send_getEventsByRowID(server_id, row_id, database_type);
      return recv_getEventsByRowID();
    }

    public void send_getEventsByRowID(short server_id, String row_id, String database_type) throws org.apache.thrift.TException
    {
      getEventsByRowID_args args = new getEventsByRowID_args();
      args.setServer_id(server_id);
      args.setRow_id(row_id);
      args.setDatabase_type(database_type);
      sendBase("getEventsByRowID", args);
    }

    public List<DisplayEvent> recv_getEventsByRowID() throws org.apache.thrift.TException
    {
      getEventsByRowID_result result = new getEventsByRowID_result();
      receiveBase(result, "getEventsByRowID");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getEventsByRowID failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void getEventsByRowID(short server_id, String row_id, String database_type, org.apache.thrift.async.AsyncMethodCallback<getEventsByRowID_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      getEventsByRowID_call method_call = new getEventsByRowID_call(server_id, row_id, database_type, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class getEventsByRowID_call extends org.apache.thrift.async.TAsyncMethodCall {
      private short server_id;
      private String row_id;
      private String database_type;
      public getEventsByRowID_call(short server_id, String row_id, String database_type, org.apache.thrift.async.AsyncMethodCallback<getEventsByRowID_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.server_id = server_id;
        this.row_id = row_id;
        this.database_type = database_type;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getEventsByRowID", org.apache.thrift.protocol.TMessageType.CALL, 0));
        getEventsByRowID_args args = new getEventsByRowID_args();
        args.setServer_id(server_id);
        args.setRow_id(row_id);
        args.setDatabase_type(database_type);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public List<DisplayEvent> getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_getEventsByRowID();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("getEventsByRowID", new getEventsByRowID());
      return processMap;
    }

    private static class getEventsByRowID<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getEventsByRowID_args> {
      public getEventsByRowID() {
        super("getEventsByRowID");
      }

      protected getEventsByRowID_args getEmptyArgsInstance() {
        return new getEventsByRowID_args();
      }

      protected getEventsByRowID_result getResult(I iface, getEventsByRowID_args args) throws org.apache.thrift.TException {
        getEventsByRowID_result result = new getEventsByRowID_result();
        result.success = iface.getEventsByRowID(args.server_id, args.row_id, args.database_type);
        return result;
      }
    }

  }

  public static class getEventsByRowID_args implements org.apache.thrift.TBase<getEventsByRowID_args, getEventsByRowID_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getEventsByRowID_args");

    private static final org.apache.thrift.protocol.TField SERVER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("server_id", org.apache.thrift.protocol.TType.I16, (short)1);
    private static final org.apache.thrift.protocol.TField ROW_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("row_id", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField DATABASE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("database_type", org.apache.thrift.protocol.TType.STRING, (short)3);

    public short server_id; // required
    public String row_id; // required
    public String database_type; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SERVER_ID((short)1, "server_id"),
      ROW_ID((short)2, "row_id"),
      DATABASE_TYPE((short)3, "database_type");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // SERVER_ID
            return SERVER_ID;
          case 2: // ROW_ID
            return ROW_ID;
          case 3: // DATABASE_TYPE
            return DATABASE_TYPE;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __SERVER_ID_ISSET_ID = 0;
    private BitSet __isset_bit_vector = new BitSet(1);

    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SERVER_ID, new org.apache.thrift.meta_data.FieldMetaData("server_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
      tmpMap.put(_Fields.ROW_ID, new org.apache.thrift.meta_data.FieldMetaData("row_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.DATABASE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("database_type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getEventsByRowID_args.class, metaDataMap);
    }

    public getEventsByRowID_args() {
    }

    public getEventsByRowID_args(
      short server_id,
      String row_id,
      String database_type)
    {
      this();
      this.server_id = server_id;
      setServer_idIsSet(true);
      this.row_id = row_id;
      this.database_type = database_type;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getEventsByRowID_args(getEventsByRowID_args other) {
      __isset_bit_vector.clear();
      __isset_bit_vector.or(other.__isset_bit_vector);
      this.server_id = other.server_id;
      if (other.isSetRow_id()) {
        this.row_id = other.row_id;
      }
      if (other.isSetDatabase_type()) {
        this.database_type = other.database_type;
      }
    }

    public getEventsByRowID_args deepCopy() {
      return new getEventsByRowID_args(this);
    }

    @Override
    public void clear() {
      setServer_idIsSet(false);
      this.server_id = 0;
      this.row_id = null;
      this.database_type = null;
    }

    public short getServer_id() {
      return this.server_id;
    }

    public getEventsByRowID_args setServer_id(short server_id) {
      this.server_id = server_id;
      setServer_idIsSet(true);
      return this;
    }

    public void unsetServer_id() {
      __isset_bit_vector.clear(__SERVER_ID_ISSET_ID);
    }

    /** Returns true if field server_id is set (has been assigned a value) and false otherwise */
    public boolean isSetServer_id() {
      return __isset_bit_vector.get(__SERVER_ID_ISSET_ID);
    }

    public void setServer_idIsSet(boolean value) {
      __isset_bit_vector.set(__SERVER_ID_ISSET_ID, value);
    }

    public String getRow_id() {
      return this.row_id;
    }

    public getEventsByRowID_args setRow_id(String row_id) {
      this.row_id = row_id;
      return this;
    }

    public void unsetRow_id() {
      this.row_id = null;
    }

    /** Returns true if field row_id is set (has been assigned a value) and false otherwise */
    public boolean isSetRow_id() {
      return this.row_id != null;
    }

    public void setRow_idIsSet(boolean value) {
      if (!value) {
        this.row_id = null;
      }
    }

    public String getDatabase_type() {
      return this.database_type;
    }

    public getEventsByRowID_args setDatabase_type(String database_type) {
      this.database_type = database_type;
      return this;
    }

    public void unsetDatabase_type() {
      this.database_type = null;
    }

    /** Returns true if field database_type is set (has been assigned a value) and false otherwise */
    public boolean isSetDatabase_type() {
      return this.database_type != null;
    }

    public void setDatabase_typeIsSet(boolean value) {
      if (!value) {
        this.database_type = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SERVER_ID:
        if (value == null) {
          unsetServer_id();
        } else {
          setServer_id((Short)value);
        }
        break;

      case ROW_ID:
        if (value == null) {
          unsetRow_id();
        } else {
          setRow_id((String)value);
        }
        break;

      case DATABASE_TYPE:
        if (value == null) {
          unsetDatabase_type();
        } else {
          setDatabase_type((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SERVER_ID:
        return Short.valueOf(getServer_id());

      case ROW_ID:
        return getRow_id();

      case DATABASE_TYPE:
        return getDatabase_type();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SERVER_ID:
        return isSetServer_id();
      case ROW_ID:
        return isSetRow_id();
      case DATABASE_TYPE:
        return isSetDatabase_type();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getEventsByRowID_args)
        return this.equals((getEventsByRowID_args)that);
      return false;
    }

    public boolean equals(getEventsByRowID_args that) {
      if (that == null)
        return false;

      boolean this_present_server_id = true;
      boolean that_present_server_id = true;
      if (this_present_server_id || that_present_server_id) {
        if (!(this_present_server_id && that_present_server_id))
          return false;
        if (this.server_id != that.server_id)
          return false;
      }

      boolean this_present_row_id = true && this.isSetRow_id();
      boolean that_present_row_id = true && that.isSetRow_id();
      if (this_present_row_id || that_present_row_id) {
        if (!(this_present_row_id && that_present_row_id))
          return false;
        if (!this.row_id.equals(that.row_id))
          return false;
      }

      boolean this_present_database_type = true && this.isSetDatabase_type();
      boolean that_present_database_type = true && that.isSetDatabase_type();
      if (this_present_database_type || that_present_database_type) {
        if (!(this_present_database_type && that_present_database_type))
          return false;
        if (!this.database_type.equals(that.database_type))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(getEventsByRowID_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getEventsByRowID_args typedOther = (getEventsByRowID_args)other;

      lastComparison = Boolean.valueOf(isSetServer_id()).compareTo(typedOther.isSetServer_id());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetServer_id()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.server_id, typedOther.server_id);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetRow_id()).compareTo(typedOther.isSetRow_id());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetRow_id()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.row_id, typedOther.row_id);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetDatabase_type()).compareTo(typedOther.isSetDatabase_type());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetDatabase_type()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database_type, typedOther.database_type);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (field.id) {
          case 1: // SERVER_ID
            if (field.type == org.apache.thrift.protocol.TType.I16) {
              this.server_id = iprot.readI16();
              setServer_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case 2: // ROW_ID
            if (field.type == org.apache.thrift.protocol.TType.STRING) {
              this.row_id = iprot.readString();
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case 3: // DATABASE_TYPE
            if (field.type == org.apache.thrift.protocol.TType.STRING) {
              this.database_type = iprot.readString();
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SERVER_ID_FIELD_DESC);
      oprot.writeI16(this.server_id);
      oprot.writeFieldEnd();
      if (this.row_id != null) {
        oprot.writeFieldBegin(ROW_ID_FIELD_DESC);
        oprot.writeString(this.row_id);
        oprot.writeFieldEnd();
      }
      if (this.database_type != null) {
        oprot.writeFieldBegin(DATABASE_TYPE_FIELD_DESC);
        oprot.writeString(this.database_type);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getEventsByRowID_args(");
      boolean first = true;

      sb.append("server_id:");
      sb.append(this.server_id);
      first = false;
      if (!first) sb.append(", ");
      sb.append("row_id:");
      if (this.row_id == null) {
        sb.append("null");
      } else {
        sb.append(this.row_id);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("database_type:");
      if (this.database_type == null) {
        sb.append("null");
      } else {
        sb.append(this.database_type);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bit_vector = new BitSet(1);
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

  }

  public static class getEventsByRowID_result implements org.apache.thrift.TBase<getEventsByRowID_result, getEventsByRowID_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getEventsByRowID_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.LIST, (short)0);

    public List<DisplayEvent> success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments

    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
              new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DisplayEvent.class))));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getEventsByRowID_result.class, metaDataMap);
    }

    public getEventsByRowID_result() {
    }

    public getEventsByRowID_result(
      List<DisplayEvent> success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getEventsByRowID_result(getEventsByRowID_result other) {
      if (other.isSetSuccess()) {
        List<DisplayEvent> __this__success = new ArrayList<DisplayEvent>();
        for (DisplayEvent other_element : other.success) {
          __this__success.add(new DisplayEvent(other_element));
        }
        this.success = __this__success;
      }
    }

    public getEventsByRowID_result deepCopy() {
      return new getEventsByRowID_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public int getSuccessSize() {
      return (this.success == null) ? 0 : this.success.size();
    }

    public java.util.Iterator<DisplayEvent> getSuccessIterator() {
      return (this.success == null) ? null : this.success.iterator();
    }

    public void addToSuccess(DisplayEvent elem) {
      if (this.success == null) {
        this.success = new ArrayList<DisplayEvent>();
      }
      this.success.add(elem);
    }

    public List<DisplayEvent> getSuccess() {
      return this.success;
    }

    public getEventsByRowID_result setSuccess(List<DisplayEvent> success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((List<DisplayEvent>)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getEventsByRowID_result)
        return this.equals((getEventsByRowID_result)that);
      return false;
    }

    public boolean equals(getEventsByRowID_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(getEventsByRowID_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getEventsByRowID_result typedOther = (getEventsByRowID_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (field.id) {
          case 0: // SUCCESS
            if (field.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                this.success = new ArrayList<DisplayEvent>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  DisplayEvent _elem2; // required
                  _elem2 = new DisplayEvent();
                  _elem2.read(iprot);
                  this.success.add(_elem2);
                }
                iprot.readListEnd();
              }
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      oprot.writeStructBegin(STRUCT_DESC);

      if (this.isSetSuccess()) {
        oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.success.size()));
          for (DisplayEvent _iter3 : this.success)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getEventsByRowID_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

  }

}
