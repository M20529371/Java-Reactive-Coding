package com.selflearning.sec03;

import com.selflearning.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec11FluxMono {

    public static void main(String[] args) {
       var flux = Flux.range(1, 10);
        // converting flux to mono
        flux.next().subscribe(Util.subscriber());
        // or another way of converting flux to mono is
        Mono.from(flux).subscribe(Util.subscriber());
    }


    private static void monoToFlux(){
        var mono = getUsername(1);
        // converting mono to flux
        save(Flux.from(mono));
    }

    public static Mono<String> getUsername(int userId){
        return switch(userId){
            case 1 -> Mono.just("Sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber());
    }
}
