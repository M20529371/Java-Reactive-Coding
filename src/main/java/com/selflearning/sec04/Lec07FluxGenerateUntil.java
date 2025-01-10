package com.selflearning.sec04;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateUntil {
    public static void main(String[] args) {
        demo2();
    }
    // using generator print all the country names, until the canada country name is read.
    private static void demo1(){
        Flux.generate(synchronousSink -> {

            var country = Util.faker().country().name();
            synchronousSink.next(country);
            if(country.equalsIgnoreCase("canada")){
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }

    private static void demo2(){
        Flux.<String>generate(synchronousSink -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);
        }).takeUntil(c->c.equalsIgnoreCase("canada")).
                subscribe(Util.subscriber());
    }
}
