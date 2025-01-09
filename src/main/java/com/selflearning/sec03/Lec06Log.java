package com.selflearning.sec03;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {

    public static void main(String[] args) {
        Flux.range(1,5)
                .log("range-map")
                .map(i-> Util.faker().name().firstName())
                .log("map-subscriber")
                .subscribe(Util.subscriber());
    }
}