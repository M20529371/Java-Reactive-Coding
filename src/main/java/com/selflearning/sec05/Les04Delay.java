package com.selflearning.sec05;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Les04Delay {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(12);
    }
}
