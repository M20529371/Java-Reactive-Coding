package com.selflearning.sec01.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubsriptionImpl implements Subscription {


    private static final Logger log = LoggerFactory.getLogger(SubsriptionImpl.class);
    private static final int MAX_ITEMS = 10;
    private final Subscriber<? super String> subscriber;
    private final Faker faker;
    private boolean isCancelled = false;
    private int count = 0;

    public SubsriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = new Faker();
    }

    @Override
    public void request(long l) {
        if(isCancelled){
            return;
        }else{
            log.info("Subscriber has requested {} items", l);
            if(l > MAX_ITEMS){
                this.subscriber.onError(new RuntimeException("Validation Failed"));
                this.isCancelled = true;
                return;
            }
            for(int i = 0; i<l&&count<MAX_ITEMS;i++){
                ++count;
                this.subscriber.onNext(this.faker.internet().emailAddress());
            }
            if(count == MAX_ITEMS){
                log.info("no more data to produce");
                this.subscriber.onComplete();
               this.isCancelled = true;
            }
        }
    }

    @Override
    public void cancel() {
      log.info("subscriber has cancelled");
      isCancelled = true;
    }
}
