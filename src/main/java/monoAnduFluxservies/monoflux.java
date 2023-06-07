package monoAnduFluxservies;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class monoflux {
    public Flux<String> fruitFlux(){
        return Flux.fromIterable(List.of("mango","orange","banana")).log();
    }

    public Flux<String> fruitFluxMap(){
        return Flux.fromIterable(List.of("mango","orange","banana"))
                .map(String::toUpperCase)
                .log();
    }
    public Flux<String> fruitFluxFilter(int number){
        return Flux.fromIterable(List.of("mango","orange","banana"))
                .filter(s->s.length()>number)
                .log();
    }
    public Flux<String> fruitFluxFilterMap(int number){
        return Flux.fromIterable(List.of("mango","orange","banana"))
                .filter(s->s.length()>number)
                .map(String::toUpperCase)
                .log();
    }
    public Flux<String> fruitFluxFlatMap(){
        return Flux.fromIterable(List.of("mango","orange","banana"))
                .flatMap(s-> Flux.just(s.split("")))
                .log();
    }
    public Flux<String> fruitFluxFlatMapAsync(){
        return Flux.fromIterable(List.of("mango","orange","banana"))
                .flatMap(s-> Flux.just(s.split("")))
                .delayElements(Duration.ofMillis(
                        new Random().nextInt(1000)
                ))
                .log();
    }
    public Flux<String> fruitFluxConcatMap(){
        return Flux.fromIterable(List.of("mango","orange","banana"))
                .concatMap(s-> Flux.just(s.split("")))
                .delayElements(Duration.ofMillis(
                        new Random().nextInt(1000)
                ))
                .log();
    }
    public Flux<String> fruitFluxReduce(){
        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .reduce((accumlator,current)-> accumlator+","+ current)
                .flux()
                .log();

    }
    public Flux<String> fruitFluxMerge(){
        Flux<String> Fruits= Flux.just("Mango","Orange")
                .delayElements(Duration.ofMillis(50));
        Flux<String> veggies=Flux.just("Tomato","Lemon")
                .delayElements(Duration.ofMillis(75));
        return Flux.merge(Fruits,veggies);
    }
    public Flux<String> fruitFluxMergeWith(){
        Flux<String> Fruits= Flux.just("Mango","Orange")
                .delayElements(Duration.ofMillis(50));
        Flux<String> veggies=Flux.just("Tomato","Lemon")
                .delayElements(Duration.ofMillis(75));
        return Fruits.mergeWith( veggies);
    }

    public Flux<String> fruitFluxZip(){
        Flux<String> Fruits= Flux.just("Mango","Orange");
        Flux<String> veggies=Flux.just("Tomato","Lemon");
        return  Flux.zip(Fruits,veggies,
                (first,second)->first+second).log();
    }
    public Flux<String> fruitFluxZipWith(){
        Flux<String> Fruits= Flux.just("Mango","Orange");
        Flux<String> veggies=Flux.just("Tomato","Lemon");
        return  Fruits.zipWith(veggies,
                (first,second)->first+second).log();
    }
    public Flux<String> fruitFluxZipTuple(){
        Flux<String> Fruits= Flux.just("Mango","Orange");
        Flux<String> veggies=Flux.just("Tomato","Lemon");
        Flux<String> moreveggies=Flux.just("Potato","Bean");
        return  Fruits.zip(Fruits,veggies,moreveggies)
                .map(objects -> objects.getT1() +objects.getT2()+objects.getT3());


    }

    public Flux<String> fruitFluxLimit(){
        Flux<String> Fruits= Flux.just("Mango","Orange");
        Flux<String> veggies=Flux.just("Tomato","Lemon");
        Flux<String> moreveggies=Flux.just("Potato","Bean");
        return  Fruits.zip(Fruits,veggies,moreveggies)
                .map(objects -> objects.getT1() +objects.getT2()+objects.getT3())
                .limitRequest(2)
                .log();


    }
    public Flux<String> fruitFluxFliterDoOn(int number){
        return Flux.fromIterable(List.of("mango","orange","banana"))
                .filter(s->s.length()>number)
                .doOnNext(s -> {
                    System.out.println("s="+s);
                })
                .doOnSubscribe(subscription ->{
                    System.out.println("subscription = " + subscription.toString());
                } )
                .doOnComplete(()-> System.out.println(" completed!!" ))
                .doOnError(throwable -> System.out.println("error occured:"+ throwable.getMessage()));
        }



    public Mono<String> fruitMono(){
        return Mono.just("mango").log();
    }
    public Mono<String> fruitMonoMap(){
        return Mono.just("mango")
                .map(String::toUpperCase)
                .log();
    }
    public Mono<List<String>> fruitMonoFlatMap(){
        return Mono.just("mango")
                .flatMap(s -> Mono.just(List.of(s.split(""))))
                .log();
    }
    public Flux<String> fruitMonoFlatMapMany(){
        return Mono.just("mango")
                .flatMapMany(s-> Flux.just(s.split("")))
                .log();
    }


    public static void main(String[]args){
        monoflux monoflux
                =new monoflux();
        monoflux.fruitFlux()
                .subscribe(s->{
                    System.out.println("s="+s);
                });
        monoflux.fruitMono()
                .subscribe(s ->{
                    System.out.println("Mono -> s="+s);
                });
    }
}





