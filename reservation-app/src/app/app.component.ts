import { Component } from '@angular/core';
import {FormControl} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  constructor(private http:HttpClient) {
  }
  private baseUrl:String='http://localhost:8081';
  private reservationUrl:String=this.baseUrl+'/room/v1/reservation';
  rooms: Room[] | undefined ;
  ngOnInit(){
    this.rooms=[new Room("127", "127", "150"),
      new Room("135", "135", "200"),
      new Room("255", "255", "180"),]
  }
}
export class Room{
  id:String;
  roomNumber:string;
  price:String;

  constructor(id: String, roomNumber: string, price: String) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
  }
}
