package com.selflearning.sec05;


/*
*  Handle method behaves like filter + map
*
*  if we have a requirement like below
*  1 => -2
*  4 => dont send
*  7 => error
*  every thing else => send as it is
* */

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;

public class Les01Handle {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 10).filter(i->i!=7);
        // handle method accpets a bipridicate as an argument(item and sink)

        flux.handle((item, sink)->{
            if(item == 1){
                sink.next(-2);
            }else if(item == 4){
            }else if (item == 7){
                sink.error(new RuntimeException("Item is 7"));
            }else{
                sink.next(item);
            }
        }).subscribe(Util.subscriber());
    }
}
