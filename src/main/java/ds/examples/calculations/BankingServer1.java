package ds.examples.calculations;

import java.io.IOException;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import ds.examples.calculations.BankServiceGrpc.BankServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BankingServer1 extends BankServiceImplBase{
	
	public int user_balance = 0;

	public static void main(String[] args) {
		BankingServer1 bankingserver1 = new BankingServer1();
		int port = 50051;
		
		try {
			Server server = ServerBuilder.forPort(port).addService(bankingserver1).build().start();
			
			System.out.println("Bank add server started, listening on " + port);
			
			server.awaitTermination();
		
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void addMoney(addMoneyRequest request,
			StreamObserver<balanceResponse> responseObserver) {
		
		System.out.printf("receiving addMoney method amount: %d \n", request.getAddMoney());
		
		int user_add_amount = request.getAddMoney();
		user_balance = user_balance + user_add_amount;
		balanceResponse reply = balanceResponse.newBuilder().setUserBalance(user_balance).build();
		responseObserver.onNext(reply);
		
    	try {
    		Thread.sleep(1000);
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
		
		responseObserver.onCompleted();
	}

}
