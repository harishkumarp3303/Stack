import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit
{
  constructor() { }

  ngOnInit(): void {
  }


  text:string=""
  
  cstate:string=""
  
  countries=[
    {
    country:"India",
    states:["Karnatka","Tamil Nadu","Maharastra","Andra pradesh","Kerala"]
  },
  {
    country:"USA",
    states:["New York","California","Texas","Florida","Ohio"]
  },
  {
    country:"China",
    states:["Beijing","Shanghai","Guangdong","Shanxi","Hubei"]
  }
]

arr:string=""

res:any[]=[]
call(){
  console.log(this.arr)
  this.res=this.arr.split(",")
  console.log(this.res)
}

SelectedState(event:any){
  this.cstate=event
}



 



}
