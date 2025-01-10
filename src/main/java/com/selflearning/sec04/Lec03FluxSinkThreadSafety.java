package com.selflearning.sec04;

import com.selflearning.common.Util;
import com.selflearning.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Lec03FluxSinkThreadSafety {

    private static final Logger log = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {
        demo2();
    }

    private static void demo1(){
        var list = new ArrayList<Integer>();
        Runnable r = ()->{
            for(int i = 0 ; i<1000; i++){
                list.add(i);
            }
        };
        for(int i = 0 ; i < 10; i++){
            Thread.ofPlatform().start(r);
        }
        Util.sleepSeconds(3);
        log.info("list size: {}",list.size());
    }


    // flux sink is threadsafe
    private static void demo2(){
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);
        Runnable r = ()->{
            for(int i = 0 ; i<1000; i++){
                generator.generate();
            }
        };
        for(int i = 0 ; i < 10; i++){
            Thread.ofPlatform().start(r);
        }
        Util.sleepSeconds(3);
        log.info("list size: {}",list.size());
    }
}
