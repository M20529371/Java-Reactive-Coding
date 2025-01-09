package com.selflearning.sec03;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec01FluxJust {

    public static void main(String[] args) {
        Flux.just(1, 2, 3, "sam").subscribe(Util.subscriber());

    }
}
