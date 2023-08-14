import { EventEmitter, Injectable } from '@angular/core';

export interface StatusObj{
  status:string,
  text:string,
  background:string
}


@Injectable({
  providedIn: 'root'
})
export class ComponentcommService {

  constructor() { }

  statusob= new EventEmitter<StatusObj>()

  setstatusobj(data:StatusObj){
    this.statusob.emit(data)
    console.log(this.statusob)
  }







}
