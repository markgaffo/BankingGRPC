package ds.examples.view;

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
    comments = "Source: view.proto")
public final class ViewServiceGrpc {

  private ViewServiceGrpc() {}

  public static final String SERVICE_NAME = "view.ViewService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.examples.view.AccountNameRequest,
      ds.examples.view.AccountNameResponse> getAccountNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "accountName",
      requestType = ds.examples.view.AccountNameRequest.class,
      responseType = ds.examples.view.AccountNameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.examples.view.AccountNameRequest,
      ds.examples.view.AccountNameResponse> getAccountNameMethod() {
    io.grpc.MethodDescriptor<ds.examples.view.AccountNameRequest, ds.examples.view.AccountNameResponse> getAccountNameMethod;
    if ((getAccountNameMethod = ViewServiceGrpc.getAccountNameMethod) == null) {
      synchronized (ViewServiceGrpc.class) {
        if ((getAccountNameMethod = ViewServiceGrpc.getAccountNameMethod) == null) {
          ViewServiceGrpc.getAccountNameMethod = getAccountNameMethod = 
              io.grpc.MethodDescriptor.<ds.examples.view.AccountNameRequest, ds.examples.view.AccountNameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "view.ViewService", "accountName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.view.AccountNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.view.AccountNameResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ViewServiceMethodDescriptorSupplier("accountName"))
                  .build();
          }
        }
     }
     return getAccountNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.examples.view.ContactsRequest,
      ds.examples.view.ContactsResponse> getViewContactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewContacts",
      requestType = ds.examples.view.ContactsRequest.class,
      responseType = ds.examples.view.ContactsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.examples.view.ContactsRequest,
      ds.examples.view.ContactsResponse> getViewContactsMethod() {
    io.grpc.MethodDescriptor<ds.examples.view.ContactsRequest, ds.examples.view.ContactsResponse> getViewContactsMethod;
    if ((getViewContactsMethod = ViewServiceGrpc.getViewContactsMethod) == null) {
      synchronized (ViewServiceGrpc.class) {
        if ((getViewContactsMethod = ViewServiceGrpc.getViewContactsMethod) == null) {
          ViewServiceGrpc.getViewContactsMethod = getViewContactsMethod = 
              io.grpc.MethodDescriptor.<ds.examples.view.ContactsRequest, ds.examples.view.ContactsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "view.ViewService", "viewContacts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.view.ContactsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.view.ContactsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ViewServiceMethodDescriptorSupplier("viewContacts"))
                  .build();
          }
        }
     }
     return getViewContactsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ViewServiceStub newStub(io.grpc.Channel channel) {
    return new ViewServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ViewServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ViewServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ViewServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ViewServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ViewServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void accountName(ds.examples.view.AccountNameRequest request,
        io.grpc.stub.StreamObserver<ds.examples.view.AccountNameResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAccountNameMethod(), responseObserver);
    }

    /**
     */
    public void viewContacts(ds.examples.view.ContactsRequest request,
        io.grpc.stub.StreamObserver<ds.examples.view.ContactsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getViewContactsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAccountNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.examples.view.AccountNameRequest,
                ds.examples.view.AccountNameResponse>(
                  this, METHODID_ACCOUNT_NAME)))
          .addMethod(
            getViewContactsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.examples.view.ContactsRequest,
                ds.examples.view.ContactsResponse>(
                  this, METHODID_VIEW_CONTACTS)))
          .build();
    }
  }

  /**
   */
  public static final class ViewServiceStub extends io.grpc.stub.AbstractStub<ViewServiceStub> {
    private ViewServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ViewServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ViewServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ViewServiceStub(channel, callOptions);
    }

    /**
     */
    public void accountName(ds.examples.view.AccountNameRequest request,
        io.grpc.stub.StreamObserver<ds.examples.view.AccountNameResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAccountNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void viewContacts(ds.examples.view.ContactsRequest request,
        io.grpc.stub.StreamObserver<ds.examples.view.ContactsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getViewContactsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ViewServiceBlockingStub extends io.grpc.stub.AbstractStub<ViewServiceBlockingStub> {
    private ViewServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ViewServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ViewServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ViewServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.examples.view.AccountNameResponse accountName(ds.examples.view.AccountNameRequest request) {
      return blockingUnaryCall(
          getChannel(), getAccountNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.examples.view.ContactsResponse> viewContacts(
        ds.examples.view.ContactsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getViewContactsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ViewServiceFutureStub extends io.grpc.stub.AbstractStub<ViewServiceFutureStub> {
    private ViewServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ViewServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ViewServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ViewServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.examples.view.AccountNameResponse> accountName(
        ds.examples.view.AccountNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAccountNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACCOUNT_NAME = 0;
  private static final int METHODID_VIEW_CONTACTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ViewServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ViewServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACCOUNT_NAME:
          serviceImpl.accountName((ds.examples.view.AccountNameRequest) request,
              (io.grpc.stub.StreamObserver<ds.examples.view.AccountNameResponse>) responseObserver);
          break;
        case METHODID_VIEW_CONTACTS:
          serviceImpl.viewContacts((ds.examples.view.ContactsRequest) request,
              (io.grpc.stub.StreamObserver<ds.examples.view.ContactsResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ViewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ViewServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.examples.view.ViewServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ViewService");
    }
  }

  private static final class ViewServiceFileDescriptorSupplier
      extends ViewServiceBaseDescriptorSupplier {
    ViewServiceFileDescriptorSupplier() {}
  }

  private static final class ViewServiceMethodDescriptorSupplier
      extends ViewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ViewServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ViewServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ViewServiceFileDescriptorSupplier())
              .addMethod(getAccountNameMethod())
              .addMethod(getViewContactsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
