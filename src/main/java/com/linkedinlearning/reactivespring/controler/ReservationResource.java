package com.linkedinlearning.reactivespring.controler;

import com.linkedinlearning.reactivespring.model.Reservation;
import org.springframework.data.repository.query.Param;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationResource {
    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation";
    @GetMapping(path = "{roomId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getReservationById(@PathVariable String roomId){
        return Mono.just("{}");
    }
   @PostMapping(path = "",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> createReservation(@RequestBody Mono<Reservation> reservation){
       return Mono.just("{post}");

    }
    @PutMapping(path = "{roomId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  Mono<String> updatePrices(@PathVariable String roomId){
        return Mono.just("{delete}");
    }
    @DeleteMapping(path = "{roomId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> deleteReservationById(@PathVariable String roomId){
        return Mono.just(true);}



}
