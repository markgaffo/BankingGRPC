from concurrent import futures
import logging
import grpc

import register_pb2
import register_pb2_grpc

class Signup(register_pb2_grpc.SignupServicer):

    def AccountName(self, request, context):
        return register_pb2.UserReply(message='welcome,  %s! to the banking service!' % request.username)

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    register_pb2_grpc.add_SignupServicer_to_server(Signup(), server)
    server.add_insecure_port('[::]:50055')
    print('Starting server. Listening on port 50055.')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig()
    serve()
