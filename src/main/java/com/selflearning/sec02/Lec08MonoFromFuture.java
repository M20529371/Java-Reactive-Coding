package com.selflearning.sec02;

import com.selflearning.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec08MonoFromFuture {

    private static final Logger log = LoggerFactory.getLogger(Lec08MonoFromFuture.class);

    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(Util.subscriber());
        Util.sleepSeconds(2);
    }

    public static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()-> {
                    log.info("generating name");
                    return Util.faker().name().firstName();
                }
        );

    }
}
