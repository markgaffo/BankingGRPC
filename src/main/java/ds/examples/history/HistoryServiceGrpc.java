package ds.examples.history;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: history.proto")
public final class HistoryServiceGrpc {

  private HistoryServiceGrpc() {}

  public static final String SERVICE_NAME = "history.HistoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.examples.history.DisplayRequest,
      ds.examples.history.DisplayResponse> getDisplayTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "displayTransaction",
      requestType = ds.examples.history.DisplayRequest.class,
      responseType = ds.examples.history.DisplayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.examples.history.DisplayRequest,
      ds.examples.history.DisplayResponse> getDisplayTransactionMethod() {
    io.grpc.MethodDescriptor<ds.examples.history.DisplayRequest, ds.examples.history.DisplayResponse> getDisplayTransactionMethod;
    if ((getDisplayTransactionMethod = HistoryServiceGrpc.getDisplayTransactionMethod) == null) {
      synchronized (HistoryServiceGrpc.class) {
        if ((getDisplayTransactionMethod = HistoryServiceGrpc.getDisplayTransactionMethod) == null) {
          HistoryServiceGrpc.getDisplayTransactionMethod = getDisplayTransactionMethod = 
              io.grpc.MethodDescriptor.<ds.examples.history.DisplayRequest, ds.examples.history.DisplayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "history.HistoryService", "displayTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.history.DisplayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.history.DisplayResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryServiceMethodDescriptorSupplier("displayTransaction"))
                  .build();
          }
        }
     }
     return getDisplayTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.examples.history.RecentRequest,
      ds.examples.history.RecentResponse> getRecentTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recentTransactions",
      requestType = ds.examples.history.RecentRequest.class,
      responseType = ds.examples.history.RecentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.examples.history.RecentRequest,
      ds.examples.history.RecentResponse> getRecentTransactionsMethod() {
    io.grpc.MethodDescriptor<ds.examples.history.RecentRequest, ds.examples.history.RecentResponse> getRecentTransactionsMethod;
    if ((getRecentTransactionsMethod = HistoryServiceGrpc.getRecentTransactionsMethod) == null) {
      synchronized (HistoryServiceGrpc.class) {
        if ((getRecentTransactionsMethod = HistoryServiceGrpc.getRecentTransactionsMethod) == null) {
          HistoryServiceGrpc.getRecentTransactionsMethod = getRecentTransactionsMethod = 
              io.grpc.MethodDescriptor.<ds.examples.history.RecentRequest, ds.examples.history.RecentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "history.HistoryService", "recentTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.history.RecentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.history.RecentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryServiceMethodDescriptorSupplier("recentTransactions"))
                  .build();
          }
        }
     }
     return getRecentTransactionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HistoryServiceStub newStub(io.grpc.Channel channel) {
    return new HistoryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HistoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HistoryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HistoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HistoryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HistoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void displayTransaction(ds.examples.history.DisplayRequest request,
        io.grpc.stub.StreamObserver<ds.examples.history.DisplayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDisplayTransactionMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.examples.history.RecentRequest> recentTransactions(
        io.grpc.stub.StreamObserver<ds.examples.history.RecentResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecentTransactionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDisplayTransactionMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.examples.history.DisplayRequest,
                ds.examples.history.DisplayResponse>(
                  this, METHODID_DISPLAY_TRANSACTION)))
          .addMethod(
            getRecentTransactionsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.examples.history.RecentRequest,
                ds.examples.history.RecentResponse>(
                  this, METHODID_RECENT_TRANSACTIONS)))
          .build();
    }
  }

  /**
   */
  public static final class HistoryServiceStub extends io.grpc.stub.AbstractStub<HistoryServiceStub> {
    private HistoryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void displayTransaction(ds.examples.history.DisplayRequest request,
        io.grpc.stub.StreamObserver<ds.examples.history.DisplayResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getDisplayTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.examples.history.RecentRequest> recentTransactions(
        io.grpc.stub.StreamObserver<ds.examples.history.RecentResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRecentTransactionsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HistoryServiceBlockingStub extends io.grpc.stub.AbstractStub<HistoryServiceBlockingStub> {
    private HistoryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.examples.history.DisplayResponse> displayTransaction(
        ds.examples.history.DisplayRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getDisplayTransactionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HistoryServiceFutureStub extends io.grpc.stub.AbstractStub<HistoryServiceFutureStub> {
    private HistoryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoryServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DISPLAY_TRANSACTION = 0;
  private static final int METHODID_RECENT_TRANSACTIONS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HistoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HistoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DISPLAY_TRANSACTION:
          serviceImpl.displayTransaction((ds.examples.history.DisplayRequest) request,
              (io.grpc.stub.StreamObserver<ds.examples.history.DisplayResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECENT_TRANSACTIONS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recentTransactions(
              (io.grpc.stub.StreamObserver<ds.examples.history.RecentResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HistoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HistoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.examples.history.TransferServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HistoryService");
    }
  }

  private static final class HistoryServiceFileDescriptorSupplier
      extends HistoryServiceBaseDescriptorSupplier {
    HistoryServiceFileDescriptorSupplier() {}
  }

  private static final class HistoryServiceMethodDescriptorSupplier
      extends HistoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HistoryServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HistoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HistoryServiceFileDescriptorSupplier())
              .addMethod(getDisplayTransactionMethod())
              .addMethod(getRecentTransactionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
