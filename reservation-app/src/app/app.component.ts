import { Component } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ReservationService, ReservationRequest, Reservation} from './reservation.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  constructor(private reservationService: ReservationService) {}

  rooms!: Room[];
  roomSearchForm!: FormGroup;
  currentCheckInVal!: string;
  currentCheckOutVal!: string;
  currentPrice!: number;
  currentRoomNumber!: number;
  currentReservation!:Reservation[];

  ngOnInit() {
    this.roomSearchForm = new FormGroup ({
      checkin: new FormControl(''),
      checkout: new FormControl(''),
      roomNumber: new FormControl('')
    });

    this.roomSearchForm.valueChanges.subscribe(form => {

      this.currentCheckInVal = form.checkin;
      this.currentCheckOutVal = form.checkout;

      if(form.roomNumber) {
        let roomValues: string[] = form.roomNumber.split('|');
        this.currentRoomNumber = Number(roomValues[0]);
        this.currentPrice = Number(roomValues[1]);
      }

      console.log(this.currentCheckInVal);
      console.log(this.currentCheckOutVal);
      console.log(this.currentRoomNumber);
      console.log(this.currentPrice);

    });

    this.rooms = [ new Room("127", "127", "150"),
      new Room("138", "138", "180"),
      new Room("254", "254", "200")
    ];
    this.getCurrentReservation();
  }

  getCurrentReservation(){
    this.reservationService.getAllReservation().subscribe(getResult=>{console.log(getResult);
      this.currentReservation=getResult;
    });

  }

  createReservation() {
    this.reservationService.createReservation(
      new ReservationRequest(this.currentRoomNumber, this.currentCheckInVal,
        this.currentCheckOutVal, this.currentPrice)
    ).subscribe(postResult => {
      console.log(postResult);
      this.getCurrentReservation();
    } );

  }
}

export class Room {
  id: string;
  roomNumber: string;
  price: string;

  constructor(id: string, roomNumber: string, price: string) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
  }

}
