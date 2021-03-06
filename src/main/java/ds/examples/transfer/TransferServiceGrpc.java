package ds.examples.transfer;

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
    comments = "Source: transfer.proto")
public final class TransferServiceGrpc {

  private TransferServiceGrpc() {}

  public static final String SERVICE_NAME = "transfer.TransferService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.examples.transfer.DepositRequest,
      ds.examples.transfer.DepositResponse> getDepositFundsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "depositFunds",
      requestType = ds.examples.transfer.DepositRequest.class,
      responseType = ds.examples.transfer.DepositResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.examples.transfer.DepositRequest,
      ds.examples.transfer.DepositResponse> getDepositFundsMethod() {
    io.grpc.MethodDescriptor<ds.examples.transfer.DepositRequest, ds.examples.transfer.DepositResponse> getDepositFundsMethod;
    if ((getDepositFundsMethod = TransferServiceGrpc.getDepositFundsMethod) == null) {
      synchronized (TransferServiceGrpc.class) {
        if ((getDepositFundsMethod = TransferServiceGrpc.getDepositFundsMethod) == null) {
          TransferServiceGrpc.getDepositFundsMethod = getDepositFundsMethod = 
              io.grpc.MethodDescriptor.<ds.examples.transfer.DepositRequest, ds.examples.transfer.DepositResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "transfer.TransferService", "depositFunds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.transfer.DepositRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.transfer.DepositResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TransferServiceMethodDescriptorSupplier("depositFunds"))
                  .build();
          }
        }
     }
     return getDepositFundsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.examples.transfer.DeductRequest,
      ds.examples.transfer.DeductResponse> getDeductFundsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deductFunds",
      requestType = ds.examples.transfer.DeductRequest.class,
      responseType = ds.examples.transfer.DeductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.examples.transfer.DeductRequest,
      ds.examples.transfer.DeductResponse> getDeductFundsMethod() {
    io.grpc.MethodDescriptor<ds.examples.transfer.DeductRequest, ds.examples.transfer.DeductResponse> getDeductFundsMethod;
    if ((getDeductFundsMethod = TransferServiceGrpc.getDeductFundsMethod) == null) {
      synchronized (TransferServiceGrpc.class) {
        if ((getDeductFundsMethod = TransferServiceGrpc.getDeductFundsMethod) == null) {
          TransferServiceGrpc.getDeductFundsMethod = getDeductFundsMethod = 
              io.grpc.MethodDescriptor.<ds.examples.transfer.DeductRequest, ds.examples.transfer.DeductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "transfer.TransferService", "deductFunds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.transfer.DeductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.transfer.DeductResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TransferServiceMethodDescriptorSupplier("deductFunds"))
                  .build();
          }
        }
     }
     return getDeductFundsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.examples.transfer.SavingRequest,
      ds.examples.transfer.SavingResponse> getSavingsFundMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "savingsFund",
      requestType = ds.examples.transfer.SavingRequest.class,
      responseType = ds.examples.transfer.SavingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.examples.transfer.SavingRequest,
      ds.examples.transfer.SavingResponse> getSavingsFundMethod() {
    io.grpc.MethodDescriptor<ds.examples.transfer.SavingRequest, ds.examples.transfer.SavingResponse> getSavingsFundMethod;
    if ((getSavingsFundMethod = TransferServiceGrpc.getSavingsFundMethod) == null) {
      synchronized (TransferServiceGrpc.class) {
        if ((getSavingsFundMethod = TransferServiceGrpc.getSavingsFundMethod) == null) {
          TransferServiceGrpc.getSavingsFundMethod = getSavingsFundMethod = 
              io.grpc.MethodDescriptor.<ds.examples.transfer.SavingRequest, ds.examples.transfer.SavingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "transfer.TransferService", "savingsFund"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.transfer.SavingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.transfer.SavingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TransferServiceMethodDescriptorSupplier("savingsFund"))
                  .build();
          }
        }
     }
     return getSavingsFundMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransferServiceStub newStub(io.grpc.Channel channel) {
    return new TransferServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransferServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransferServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransferServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransferServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TransferServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.examples.transfer.DepositRequest> depositFunds(
        io.grpc.stub.StreamObserver<ds.examples.transfer.DepositResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDepositFundsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.examples.transfer.DeductRequest> deductFunds(
        io.grpc.stub.StreamObserver<ds.examples.transfer.DeductResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDeductFundsMethod(), responseObserver);
    }

    /**
     */
    public void savingsFund(ds.examples.transfer.SavingRequest request,
        io.grpc.stub.StreamObserver<ds.examples.transfer.SavingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSavingsFundMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDepositFundsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.examples.transfer.DepositRequest,
                ds.examples.transfer.DepositResponse>(
                  this, METHODID_DEPOSIT_FUNDS)))
          .addMethod(
            getDeductFundsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.examples.transfer.DeductRequest,
                ds.examples.transfer.DeductResponse>(
                  this, METHODID_DEDUCT_FUNDS)))
          .addMethod(
            getSavingsFundMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.examples.transfer.SavingRequest,
                ds.examples.transfer.SavingResponse>(
                  this, METHODID_SAVINGS_FUND)))
          .build();
    }
  }

  /**
   */
  public static final class TransferServiceStub extends io.grpc.stub.AbstractStub<TransferServiceStub> {
    private TransferServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransferServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransferServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.examples.transfer.DepositRequest> depositFunds(
        io.grpc.stub.StreamObserver<ds.examples.transfer.DepositResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDepositFundsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.examples.transfer.DeductRequest> deductFunds(
        io.grpc.stub.StreamObserver<ds.examples.transfer.DeductResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getDeductFundsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void savingsFund(ds.examples.transfer.SavingRequest request,
        io.grpc.stub.StreamObserver<ds.examples.transfer.SavingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSavingsFundMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransferServiceBlockingStub extends io.grpc.stub.AbstractStub<TransferServiceBlockingStub> {
    private TransferServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransferServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransferServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.examples.transfer.SavingResponse savingsFund(ds.examples.transfer.SavingRequest request) {
      return blockingUnaryCall(
          getChannel(), getSavingsFundMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransferServiceFutureStub extends io.grpc.stub.AbstractStub<TransferServiceFutureStub> {
    private TransferServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransferServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransferServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransferServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.examples.transfer.SavingResponse> savingsFund(
        ds.examples.transfer.SavingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSavingsFundMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVINGS_FUND = 0;
  private static final int METHODID_DEPOSIT_FUNDS = 1;
  private static final int METHODID_DEDUCT_FUNDS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransferServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransferServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVINGS_FUND:
          serviceImpl.savingsFund((ds.examples.transfer.SavingRequest) request,
              (io.grpc.stub.StreamObserver<ds.examples.transfer.SavingResponse>) responseObserver);
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
        case METHODID_DEPOSIT_FUNDS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.depositFunds(
              (io.grpc.stub.StreamObserver<ds.examples.transfer.DepositResponse>) responseObserver);
        case METHODID_DEDUCT_FUNDS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.deductFunds(
              (io.grpc.stub.StreamObserver<ds.examples.transfer.DeductResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransferServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.examples.transfer.TransferServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransferService");
    }
  }

  private static final class TransferServiceFileDescriptorSupplier
      extends TransferServiceBaseDescriptorSupplier {
    TransferServiceFileDescriptorSupplier() {}
  }

  private static final class TransferServiceMethodDescriptorSupplier
      extends TransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransferServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TransferServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransferServiceFileDescriptorSupplier())
              .addMethod(getDepositFundsMethod())
              .addMethod(getDeductFundsMethod())
              .addMethod(getSavingsFundMethod())
              .build();
        }
      }
    }
    return result;
  }
}
