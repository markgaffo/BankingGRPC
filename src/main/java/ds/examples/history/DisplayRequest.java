// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: history.proto

package ds.examples.history;

/**
 * <pre>
 *user -&gt; 1 to 10 server -&gt; transnumber: 1, amount: 240£, 2 amount 300
 * </pre>
 *
 * Protobuf type {@code history.DisplayRequest}
 */
public  final class DisplayRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:history.DisplayRequest)
    DisplayRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DisplayRequest.newBuilder() to construct.
  private DisplayRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DisplayRequest() {
    transactionIdStart_ = 0;
    transactionIdEnd_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DisplayRequest(
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
          case 8: {

            transactionIdStart_ = input.readInt32();
            break;
          }
          case 16: {

            transactionIdEnd_ = input.readInt32();
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
    return ds.examples.history.TransferServiceImpl.internal_static_history_DisplayRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.examples.history.TransferServiceImpl.internal_static_history_DisplayRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.examples.history.DisplayRequest.class, ds.examples.history.DisplayRequest.Builder.class);
  }

  public static final int TRANSACTIONIDSTART_FIELD_NUMBER = 1;
  private int transactionIdStart_;
  /**
   * <code>int32 transactionIdStart = 1;</code>
   */
  public int getTransactionIdStart() {
    return transactionIdStart_;
  }

  public static final int TRANSACTIONIDEND_FIELD_NUMBER = 2;
  private int transactionIdEnd_;
  /**
   * <code>int32 transactionIdEnd = 2;</code>
   */
  public int getTransactionIdEnd() {
    return transactionIdEnd_;
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
    if (transactionIdStart_ != 0) {
      output.writeInt32(1, transactionIdStart_);
    }
    if (transactionIdEnd_ != 0) {
      output.writeInt32(2, transactionIdEnd_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (transactionIdStart_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, transactionIdStart_);
    }
    if (transactionIdEnd_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, transactionIdEnd_);
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
    if (!(obj instanceof ds.examples.history.DisplayRequest)) {
      return super.equals(obj);
    }
    ds.examples.history.DisplayRequest other = (ds.examples.history.DisplayRequest) obj;

    boolean result = true;
    result = result && (getTransactionIdStart()
        == other.getTransactionIdStart());
    result = result && (getTransactionIdEnd()
        == other.getTransactionIdEnd());
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
    hash = (37 * hash) + TRANSACTIONIDSTART_FIELD_NUMBER;
    hash = (53 * hash) + getTransactionIdStart();
    hash = (37 * hash) + TRANSACTIONIDEND_FIELD_NUMBER;
    hash = (53 * hash) + getTransactionIdEnd();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.examples.history.DisplayRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.examples.history.DisplayRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.examples.history.DisplayRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.examples.history.DisplayRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.examples.history.DisplayRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.examples.history.DisplayRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.examples.history.DisplayRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.examples.history.DisplayRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.examples.history.DisplayRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.examples.history.DisplayRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.examples.history.DisplayRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.examples.history.DisplayRequest parseFrom(
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
  public static Builder newBuilder(ds.examples.history.DisplayRequest prototype) {
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
   * <pre>
   *user -&gt; 1 to 10 server -&gt; transnumber: 1, amount: 240£, 2 amount 300
   * </pre>
   *
   * Protobuf type {@code history.DisplayRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:history.DisplayRequest)
      ds.examples.history.DisplayRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.examples.history.TransferServiceImpl.internal_static_history_DisplayRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.examples.history.TransferServiceImpl.internal_static_history_DisplayRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.examples.history.DisplayRequest.class, ds.examples.history.DisplayRequest.Builder.class);
    }

    // Construct using ds.examples.history.DisplayRequest.newBuilder()
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
      transactionIdStart_ = 0;

      transactionIdEnd_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.examples.history.TransferServiceImpl.internal_static_history_DisplayRequest_descriptor;
    }

    @java.lang.Override
    public ds.examples.history.DisplayRequest getDefaultInstanceForType() {
      return ds.examples.history.DisplayRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.examples.history.DisplayRequest build() {
      ds.examples.history.DisplayRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.examples.history.DisplayRequest buildPartial() {
      ds.examples.history.DisplayRequest result = new ds.examples.history.DisplayRequest(this);
      result.transactionIdStart_ = transactionIdStart_;
      result.transactionIdEnd_ = transactionIdEnd_;
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
      if (other instanceof ds.examples.history.DisplayRequest) {
        return mergeFrom((ds.examples.history.DisplayRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.examples.history.DisplayRequest other) {
      if (other == ds.examples.history.DisplayRequest.getDefaultInstance()) return this;
      if (other.getTransactionIdStart() != 0) {
        setTransactionIdStart(other.getTransactionIdStart());
      }
      if (other.getTransactionIdEnd() != 0) {
        setTransactionIdEnd(other.getTransactionIdEnd());
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
      ds.examples.history.DisplayRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.examples.history.DisplayRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int transactionIdStart_ ;
    /**
     * <code>int32 transactionIdStart = 1;</code>
     */
    public int getTransactionIdStart() {
      return transactionIdStart_;
    }
    /**
     * <code>int32 transactionIdStart = 1;</code>
     */
    public Builder setTransactionIdStart(int value) {
      
      transactionIdStart_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 transactionIdStart = 1;</code>
     */
    public Builder clearTransactionIdStart() {
      
      transactionIdStart_ = 0;
      onChanged();
      return this;
    }

    private int transactionIdEnd_ ;
    /**
     * <code>int32 transactionIdEnd = 2;</code>
     */
    public int getTransactionIdEnd() {
      return transactionIdEnd_;
    }
    /**
     * <code>int32 transactionIdEnd = 2;</code>
     */
    public Builder setTransactionIdEnd(int value) {
      
      transactionIdEnd_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 transactionIdEnd = 2;</code>
     */
    public Builder clearTransactionIdEnd() {
      
      transactionIdEnd_ = 0;
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


    // @@protoc_insertion_point(builder_scope:history.DisplayRequest)
  }

  // @@protoc_insertion_point(class_scope:history.DisplayRequest)
  private static final ds.examples.history.DisplayRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.examples.history.DisplayRequest();
  }

  public static ds.examples.history.DisplayRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DisplayRequest>
      PARSER = new com.google.protobuf.AbstractParser<DisplayRequest>() {
    @java.lang.Override
    public DisplayRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DisplayRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DisplayRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DisplayRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.examples.history.DisplayRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

