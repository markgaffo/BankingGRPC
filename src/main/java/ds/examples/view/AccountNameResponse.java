// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: view.proto

package ds.examples.view;

/**
 * Protobuf type {@code view.AccountNameResponse}
 */
public  final class AccountNameResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:view.AccountNameResponse)
    AccountNameResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AccountNameResponse.newBuilder() to construct.
  private AccountNameResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AccountNameResponse() {
    accName_ = "";
    accAge_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AccountNameResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            accName_ = s;
            break;
          }
          case 16: {

            accAge_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.examples.view.ViewServiceImpl.internal_static_view_AccountNameResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.examples.view.ViewServiceImpl.internal_static_view_AccountNameResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.examples.view.AccountNameResponse.class, ds.examples.view.AccountNameResponse.Builder.class);
  }

  public static final int ACCNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object accName_;
  /**
   * <code>string accName = 1;</code>
   */
  public java.lang.String getAccName() {
    java.lang.Object ref = accName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      accName_ = s;
      return s;
    }
  }
  /**
   * <code>string accName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAccNameBytes() {
    java.lang.Object ref = accName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      accName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACCAGE_FIELD_NUMBER = 2;
  private int accAge_;
  /**
   * <code>int32 accAge = 2;</code>
   */
  public int getAccAge() {
    return accAge_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getAccNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, accName_);
    }
    if (accAge_ != 0) {
      output.writeInt32(2, accAge_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAccNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, accName_);
    }
    if (accAge_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, accAge_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.examples.view.AccountNameResponse)) {
      return super.equals(obj);
    }
    ds.examples.view.AccountNameResponse other = (ds.examples.view.AccountNameResponse) obj;

    boolean result = true;
    result = result && getAccName()
        .equals(other.getAccName());
    result = result && (getAccAge()
        == other.getAccAge());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ACCNAME_FIELD_NUMBER;
    hash = (53 * hash) + getAccName().hashCode();
    hash = (37 * hash) + ACCAGE_FIELD_NUMBER;
    hash = (53 * hash) + getAccAge();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.examples.view.AccountNameResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.examples.view.AccountNameResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.examples.view.AccountNameResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.examples.view.AccountNameResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.examples.view.AccountNameResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code view.AccountNameResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:view.AccountNameResponse)
      ds.examples.view.AccountNameResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.examples.view.ViewServiceImpl.internal_static_view_AccountNameResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.examples.view.ViewServiceImpl.internal_static_view_AccountNameResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.examples.view.AccountNameResponse.class, ds.examples.view.AccountNameResponse.Builder.class);
    }

    // Construct using ds.examples.view.AccountNameResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      accName_ = "";

      accAge_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.examples.view.ViewServiceImpl.internal_static_view_AccountNameResponse_descriptor;
    }

    @java.lang.Override
    public ds.examples.view.AccountNameResponse getDefaultInstanceForType() {
      return ds.examples.view.AccountNameResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.examples.view.AccountNameResponse build() {
      ds.examples.view.AccountNameResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.examples.view.AccountNameResponse buildPartial() {
      ds.examples.view.AccountNameResponse result = new ds.examples.view.AccountNameResponse(this);
      result.accName_ = accName_;
      result.accAge_ = accAge_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.examples.view.AccountNameResponse) {
        return mergeFrom((ds.examples.view.AccountNameResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.examples.view.AccountNameResponse other) {
      if (other == ds.examples.view.AccountNameResponse.getDefaultInstance()) return this;
      if (!other.getAccName().isEmpty()) {
        accName_ = other.accName_;
        onChanged();
      }
      if (other.getAccAge() != 0) {
        setAccAge(other.getAccAge());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.examples.view.AccountNameResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.examples.view.AccountNameResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object accName_ = "";
    /**
     * <code>string accName = 1;</code>
     */
    public java.lang.String getAccName() {
      java.lang.Object ref = accName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        accName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string accName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAccNameBytes() {
      java.lang.Object ref = accName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        accName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string accName = 1;</code>
     */
    public Builder setAccName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      accName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string accName = 1;</code>
     */
    public Builder clearAccName() {
      
      accName_ = getDefaultInstance().getAccName();
      onChanged();
      return this;
    }
    /**
     * <code>string accName = 1;</code>
     */
    public Builder setAccNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      accName_ = value;
      onChanged();
      return this;
    }

    private int accAge_ ;
    /**
     * <code>int32 accAge = 2;</code>
     */
    public int getAccAge() {
      return accAge_;
    }
    /**
     * <code>int32 accAge = 2;</code>
     */
    public Builder setAccAge(int value) {
      
      accAge_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 accAge = 2;</code>
     */
    public Builder clearAccAge() {
      
      accAge_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:view.AccountNameResponse)
  }

  // @@protoc_insertion_point(class_scope:view.AccountNameResponse)
  private static final ds.examples.view.AccountNameResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.examples.view.AccountNameResponse();
  }

  public static ds.examples.view.AccountNameResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AccountNameResponse>
      PARSER = new com.google.protobuf.AbstractParser<AccountNameResponse>() {
    @java.lang.Override
    public AccountNameResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AccountNameResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AccountNameResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AccountNameResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.examples.view.AccountNameResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

