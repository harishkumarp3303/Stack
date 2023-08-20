import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Person{
  name:string,
  age:number,
}



@Injectable({
  providedIn: 'root'
})
export class HttpserviceService {


  constructor(private http:HttpClient) { }

  addPerson(person:any){
     this.http.post('http://localhost:8081/addperson',{name:"Harish",age:45}).subscribe((data:any)=>console.log("Success ; "+data),(ere)=>{
      console.log(ere)
     })
  }

  get(){
    this.geter()
    this.http.get('http://localhost:8081/getperson',{responseType: 'text'}).subscribe((data:any)=>console.log(data))


  }

  geter(){
    this.http.get('https://jsonplaceholder.typicode.com/posts').subscribe((data:any)=>console.log(data))


  }




}



