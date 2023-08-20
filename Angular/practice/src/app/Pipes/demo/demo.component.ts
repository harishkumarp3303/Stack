import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  name:string="haRiSh"
  ubtn:any=false
  lbtn:any=true
  val:string='lowercase'

  anothertext:any="pipe with input"
  constructor() { }

  ngOnInit() {

  }

  uppercase(uppercase:any){
    this.ubtn=true
    this.lbtn=false
    this.val=uppercase
  }

  lowercase(uppercase:any){
    this.ubtn=false
    this.lbtn=true
    this.val=uppercase
  }

  // async pipe


   asynctext=new Observable((observer:any)=>{
    
      setTimeout(()=>{
        observer.next('hello Im from observable')
      
      },3000)


  })

}

 

