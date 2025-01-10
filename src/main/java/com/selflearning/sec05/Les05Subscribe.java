package com.selflearning.sec05;

import com.selflearning.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Les05Subscribe {

    private static final Logger log = LoggerFactory.getLogger(Les05Subscribe.class);

    public static void main(String[] args) {
        Flux.range(1, 10)
                .doOnNext(i->log.info("received: {}", i))
                .doOnComplete(()->log.info("completed"))
                .doOnError(err-> log.error("error", err))
                .subscribe(Util.subscriber());
    }
}
