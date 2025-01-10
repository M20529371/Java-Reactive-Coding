package com.selflearning.sec05;


/*
* do hooks/callbacks
* the reactor provides many do methods and these will be invoked at appropriate times
* and they dont change the value(except doOnNext method) whatever we are emitting as part of producer
*
* */


import com.selflearning.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Les03DoCallbacks {

    private static final Logger log = LoggerFactory.getLogger(Les03DoCallbacks.class);

    public static void main(String[] args) {
        Flux.<Integer>create(fluxsink->{
            log.info("Producer begins");
            for(int i = 0; i < 4; i++){
                fluxsink.next(i);
            }
            fluxsink.complete();
            log.info("producer ends");
        })
           // The doOnComplete is a method which will be invoked when the producer sends a complete signal
                .doOnComplete(() -> log.info("doOnComplete-1"))
                .doFirst(() -> log.info("doFirst-1"))
                .doOnNext(item -> log.info("doOnNext-1: {}", item))
                .doOnSubscribe(subscription -> log.info("doOnSubscribe-1: {}", subscription))
                .doOnRequest(request -> log.info("doOnRequest-1: {}", request))
                .doOnError(error -> log.info("doOnError-1: {}", error.getMessage()))
                .doOnTerminate(() -> log.info("doOnTerminate-1")) // complete or error case
                .doOnCancel(() -> log.info("doOnCancel-1"))
                .doOnDiscard(Object.class, o -> log.info("doOnDiscard-1: {}", o))
                .doFinally(signal -> log.info("doFinally-1: {}", signal)) // finally irrespective of the reason
                // .take(2)
                .doOnComplete(() -> log.info("doOnComplete-2"))
                .doFirst(() -> log.info("doFirst-2"))
                .doOnNext(item -> log.info("doOnNext-2: {}", item))
                .doOnSubscribe(subscription -> log.info("doOnSubscribe-2: {}", subscription))
                .doOnRequest(request -> log.info("doOnRequest-2: {}", request))
                .doOnError(error -> log.info("doOnError-2: {}", error.getMessage()))
                .doOnTerminate(() -> log.info("doOnTerminate-2")) // complete or error case
                .doOnCancel(() -> log.info("doOnCancel-2"))
                .doOnDiscard(Object.class, o -> log.info("doOnDiscard-2: {}", o))
                .doFinally(signal -> log.info("doFinally-2: {}", signal)) // finally irrespective of the reason
                //.take(4)
                .subscribe(Util.subscriber("subscriber"));


    }
}
