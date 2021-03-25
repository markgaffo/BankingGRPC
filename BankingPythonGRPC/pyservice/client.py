from __future__ import print_function
import logging
import grpc

import register_pb2
import register_pb2_grpc

def run():
    with grpc.insecure_channel('localhost:50055') as channel:
        stub = register_pb2_grpc.SignupStub(channel)
        response = stub.AccountName(register_pb2.UserRequest(username='Mark'))
    print("Client has recieved: " + response.message)


if __name__ == '__main__':
    logging.basicConfig()
    run()
