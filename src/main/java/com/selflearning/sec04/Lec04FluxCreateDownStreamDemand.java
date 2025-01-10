package com.selflearning.sec04;

import com.selflearning.common.Util;
import com.selflearning.sec01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownStreamDemand {

    private static final Logger log = LoggerFactory.getLogger(Lec04FluxCreateDownStreamDemand.class);

    public static void main(String[] args) {

        produceOnDemand();
    }


    private static void produceEarly(){
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink ->
                {
                    for(int i = 0; i<10; i++){
                        var name = Util.faker().name().firstName();
                        log.info("generated: {}",name); // all the values are produced by default, whenever subscriber requests for them then only they will be received
                        fluxSink.next(name);
                    }

                    fluxSink.complete();
                }
        ).subscribe(subscriber);

        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2); // from the produced queue first 2 items will be ejected
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2); // next 2 items will be ejected from the queue
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel(); // once canceled, we cannot request for items again

        subscriber.getSubscription().request(2); // no items will be ejected because we already cancelled in the previous step.

    }


    // the default behavior of the fluxsink is all items will be produced and placed in queue
    // even if subscriber request them or not, to change this default behavior and
    // make fluxsink to generate the items on demand we use below approach
    private static void produceOnDemand(){
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            // using the below onRequest method, we are changing the default behavior of fluxsink
            fluxSink.onRequest(request->{
                for(int i = 0; i<request && !fluxSink.isCancelled(); i++){
                    var name = Util.faker().name().firstName();
                    log.info("generated: {}", name);
                    fluxSink.next(name);
                }
            });
        }).subscribe(subscriber);

        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2); // from the produced queue first 2 items will be ejected
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2); // next 2 items will be ejected from the queue
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel(); // once canceled, we cannot request for items again

        subscriber.getSubscription().request(2); // no items will be ejected because we already cancelled in the previous step.

    }
}
