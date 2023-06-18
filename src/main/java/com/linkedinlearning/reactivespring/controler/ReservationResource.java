package com.linkedinlearning.reactivespring.controler;

import com.linkedinlearning.reactivespring.model.Reservation;
import com.linkedinlearning.reactivespring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationResource {
    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation";
    private final ReservationService reservationService;
@Autowired
    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String id){
        return reservationService.getReservation(id);
    }
   @PostMapping(path = "",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){
       return reservationService.createReservation(reservation);

    }
    @PutMapping(path = "{roomId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  Mono<Reservation> updatePrices(@PathVariable String roomId,@RequestBody Mono<Reservation> reservation){
        return reservationService.updateReservation(roomId,reservation);
    }
    @DeleteMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> deleteReservationById(@PathVariable String id) {
        return reservationService.deleteReservation(id);
    }



}
