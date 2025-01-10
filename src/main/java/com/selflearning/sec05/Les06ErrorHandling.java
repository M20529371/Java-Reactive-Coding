package com.selflearning.sec05;

import com.selflearning.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Les06ErrorHandling {

    private static final Logger log = LoggerFactory.getLogger(Les06ErrorHandling.class);

    public static void main(String[] args) {
        Flux.range(1, 10)
                .map(i-> i == 5? i/0: i)
                // the below onErrorReturn method is used to handle error/exception in the code
                .onErrorReturn(-1)
                .subscribe(Util.subscriber());
    }
}
