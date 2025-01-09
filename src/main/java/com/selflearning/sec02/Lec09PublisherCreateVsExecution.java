package com.selflearning.sec02;

import com.selflearning.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec09PublisherCreateVsExecution {

    private static final Logger log = LoggerFactory.getLogger(Lec09PublisherCreateVsExecution.class);

    public static void main(String[] args) {
        getName().subscribe(Util.subscriber());
    }

    private static final Mono<String> getName(){
        log.info("entered the method");
        return Mono.fromSupplier(()->{
           log.info("generating name");
            Util.sleepSeconds(3);
            return Util.faker().name().firstName();
        });
    }
}
