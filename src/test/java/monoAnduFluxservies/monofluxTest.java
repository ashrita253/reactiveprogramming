package monoAnduFluxservies;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class monofluxTest {
    monoflux monoflux
            =new monoflux();

    @Test
    void fruitFlux() {
        var fruitFlux= monoflux.fruitFlux();
        StepVerifier.create(fruitFlux)
                .expectNext("mango","orange","banana")
                .verifyComplete();

    }

    @Test
    void fruitMono() {
        var fruitMono= monoflux.fruitMono();
        StepVerifier.create(fruitMono)
                .expectNext("mango")
                .verifyComplete();
    }

    @Test
    void fruitFluxMap() {
        var fruitFluxMap= monoflux.fruitFluxMap();
        StepVerifier.create(fruitFluxMap)
                .expectNext("MANGO","ORANGE","BANANA")
                .verifyComplete();

    }

    @Test
    void fruitMonoMap() {
        var fruitMonoMap= monoflux.fruitMonoMap();
        StepVerifier.create(fruitMonoMap)
                .expectNext("MANGO")
                .verifyComplete();
    }

    @Test
    void fruitFluxFilter() {
        var fruitFluxFilter= monoflux.fruitFluxFilter(5);
        StepVerifier.create(fruitFluxFilter)
                .expectNext("orange","banana")
                .verifyComplete();
        }

    @Test
    void fruitFluxFilterMap() {
        var fruitFluxFliterMap= monoflux.fruitFluxFilterMap(5);
        StepVerifier.create(fruitFluxFliterMap)
                .expectNext("ORANGE","BANANA")
                .verifyComplete();
    }

    @Test
    void fruitFluxFlatMap() {
        var fruitFluxFlatMap=monoflux.fruitFluxFlatMap();
        StepVerifier.create(fruitFluxFlatMap)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitFluxFlatMapAsync() {
        var fruitFluxFlatMapAsync=monoflux.fruitFluxFlatMapAsync();
        StepVerifier.create(fruitFluxFlatMapAsync)
                .expectNextCount(17)
                .verifyComplete();

    }

    @Test
    void fruitMonoFlatMap() {
        var fruitMonoFlatMap= monoflux.fruitMonoFlatMap();
        StepVerifier.create(fruitMonoFlatMap)
                .expectNextCount(1)
                .verifyComplete();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fruitFluxConcatMap() {
        var fruitFluxConcatMap=monoflux.fruitFluxConcatMap();
        StepVerifier.create(monoflux.fruitFluxConcatMap())
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitMonoFlatMapMany() {
        var fruitMonoFlatMapMany= monoflux.fruitMonoFlatMapMany();
        StepVerifier.create(fruitMonoFlatMapMany)
                .expectNextCount(5)
                .verifyComplete();
    }



    @Test
    void fruitFluxZip() {
        var fruitFluxZip=monoflux.fruitFluxZip();
        StepVerifier.create(fruitFluxZip)
                .expectNext("MangoTomato","OrangeLemon")
                .verifyComplete();

    }

    @Test
    void fruitFluxZipWith() {
        var fruitFluxZipWith=monoflux.fruitFluxZipWith();
        StepVerifier.create(fruitFluxZipWith)
                .expectNext("MangoTomato","OrangeLemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxZipTuple() {
        var fruitFluxZipTuple = monoflux.fruitFluxZipTuple();
        StepVerifier.create(fruitFluxZipTuple)
                .expectNext("MangoTomatoPotato", "OrangeLemonBean")
                .verifyComplete();
    }

    @Test
    void fruitFluxLimit() {
        var fruitFluxLimit = monoflux.fruitFluxLimit();
        StepVerifier.create(fruitFluxLimit)
                .expectNext("MangoTomatoPotato", "OrangeLemonBean")
                .verifyComplete();
    }

    @Test
    void fruitFluxReduce() {
        var fruitFluxReduce=monoflux.fruitFluxReduce();
        StepVerifier.create(fruitFluxReduce)
                .expectNext("Mango,Orange,Banana")
                .verifyComplete();
    }

    @Test
    void fruitFluxMerge() {
        var fruitFluxMerge=monoflux.fruitFluxMerge().log();
        StepVerifier.create(fruitFluxMerge)
                .expectNext("Mango","Tomato","Orange","Lemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxMergeWith() {
        var fruitFluxMergeWith=monoflux.fruitFluxMergeWith().log();
        StepVerifier.create(fruitFluxMergeWith)
                .expectNext("Mango","Tomato","Orange","Lemon")
                .verifyComplete();

    }

    @Test
    void fruitFluxFliterDoOn() {
        var fruitFluxFilterDoOn= monoflux.fruitFluxFliterDoOn(5).log();
        StepVerifier.create(fruitFluxFilterDoOn)
                .expectNext("orange","banana")
                .verifyComplete();
    }
}
