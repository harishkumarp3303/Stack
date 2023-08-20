import { Component } from '@angular/core';
import { HttpserviceService, Person } from '../HttpService.service';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent {

  constructor(private httpservice:HttpserviceService){

  }

   p={

    name:'kumaruuuuuu',
    age:32
  }
  post(){
    this.httpservice.addPerson(this.p)
    // this.httpservice.addPerson(this.p).subscribe((data:any)=>{
    //   console.log(data);
    
    // });
    
  }

  get(){
    this.httpservice.get()
  }
}
