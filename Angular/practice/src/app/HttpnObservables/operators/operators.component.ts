import { Component, OnInit } from '@angular/core';
import { Observable, map } from 'rxjs';




@Component({
  selector: 'app-operators',
  templateUrl: './operators.component.html',
  styleUrls: ['./operators.component.css']
})
export class OperatorsComponent implements OnInit
{
  constructor() { }

  array=[
    {name:"harish",age:25},
    {name:"kumar",age:30},
    {name:"natraj",age:35},
    {name:"madhu",age:40},
    {name:"Raj",age:20},

  ]

  ngOnInit()
  {

    let obs=new Observable((observer)=>{
      let count=0
      console.log(this.array.length)
      while(count<this.array.length){
        observer.next(this.array[count])
        count++
      
      }

    }).pipe((data:any)=>{
      data.age=data.age+10
      console.log(data)
      return data
    })
    

   

    obs.subscribe((data)=>{
      console.log(data)
    })
  }

  

}





