package com.selflearning.sec04;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

/**
 * Flux generate
 * - invokes the given lambda expression again and again based on downstream demand.
 * - we can emit only one value at a time
 * - will stop when complete method is invoked
 * - will stop when error method is invoked
 * - will stop when downstream cancels.
 */

public class Lec06FluxGenerate {

    public static void main(String[] args) {


        // the generate method can only emit, one item, if we try to emit multiple items, then
        // we will get IllegalStateException.
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
//            synchronousSink.next(2);
            synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }
}
