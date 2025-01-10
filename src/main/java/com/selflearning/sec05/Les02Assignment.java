package com.selflearning.sec05;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

public class Les02Assignment {

    public static void main(String[] args) {
        Flux.<String>generate(synchronousSink->{
            var country = Util.faker().country().name();
            synchronousSink.next(country);
        }).handle((c,sink)->{
            sink.next(c);
            if(c.equalsIgnoreCase("canada")){
                sink.complete();
            }
        }).subscribe(Util.subscriber());
    }
}
