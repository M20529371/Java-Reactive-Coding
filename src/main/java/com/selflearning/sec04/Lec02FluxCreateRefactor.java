package com.selflearning.sec04;

import com.selflearning.common.Util;
import com.selflearning.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(Util.subscriber());

        for(int i = 0; i< 10; i++){
            generator.generate();
        }

    }
}
