package ua.edu.ucu.open.grpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import ua.edu.ucu.open.grpc.log.Acknowledge;
import ua.edu.ucu.open.grpc.log.Log;
import ua.edu.ucu.open.grpc.log.ReplicatedLogServiceGrpc;
import ua.edu.ucu.open.service.LogService;

@GRpcService
@RequiredArgsConstructor
@Slf4j
public class ReplicatedLogServiceImpl
        extends ReplicatedLogServiceGrpc.ReplicatedLogServiceImplBase {

    private static final String ACK = "ACK";
    private final LogService logService;

    @Override
    public void storeLog(Log request, StreamObserver<Acknowledge> responseObserver) {
        log.debug("server received {}", request);
//        try {
//            Thread.sleep(5000);
//            logService.add(request.getLog(), request.getOrdinal());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        logService.add(request.getLog(), request.getOrdinal());

        Acknowledge acknowledge = Acknowledge.newBuilder()
                .setMessage(ACK)
                .build();
        log.debug("server responded {}", acknowledge);

        responseObserver.onNext(acknowledge);
        responseObserver.onCompleted();
    }
}
