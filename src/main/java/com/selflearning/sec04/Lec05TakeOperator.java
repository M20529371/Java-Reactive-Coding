package com.selflearning.sec04;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

public class Lec05TakeOperator {
    public static void main(String[] args) {

    }

    private static void take(){
        // take operation in flux is something like limit operation in streams.
        Flux.range(1, 10).take(3).subscribe(Util.subscriber());
        //in the above line of code, even though we have a range from 1 to 10
        // we are emitting only 3 to the subscriber.
    }

    private static void takeWhile(){
        // takeWhile operation in flux is similar to take, instead of passing a number, we should send a Predicate.
        Flux.range(1, 10)
                .takeWhile(i->i<5)
                .subscribe(Util.subscriber());
        //in the above line of code, even though we have a range from 1 to 10
        // we are emitting only items which are less than 5 to the subscriber.
    }


    private static void takeUntil(){
        // takeUntil operation in flux is similar to takeWhile, instead of passing a number, we should send a Predicate.
        Flux.range(1, 10)
                .takeUntil(i->i<5) // stop when the condition is met
                .subscribe(Util.subscriber());
        //in the above line of code, even though we have a range from 1 to 10
        // we are emitting only items which are less than 5 to the subscriber.
    }
}
