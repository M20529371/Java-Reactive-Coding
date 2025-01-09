package com.selflearning.sec03;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        var list = List.of(1,2,3,4);
        var stream = list.stream();

        //var flux = Flux.fromStream(stream);
        var flux = Flux.fromStream(list::stream);
        flux.subscribe(Util.subscriber("Sub1"));
        flux.subscribe(Util.subscriber("Sub2"));
    }
}