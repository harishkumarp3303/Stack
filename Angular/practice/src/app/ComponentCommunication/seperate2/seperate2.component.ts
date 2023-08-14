import { Component ,OnInit} from '@angular/core';
import { ComponentcommService, StatusObj } from '../services/componentcomm.service';

@Component({
  selector: 'app-seperate2',
  templateUrl: './seperate2.component.html',
  styleUrls: ['./seperate2.component.css']
})
export class Seperate2Component implements OnInit{

  constructor(private compcommservice:ComponentcommService){

  }
  statusobj:StatusObj={
    status: '',
    text: '',
    background: ''
  }
  ngOnInit(): void {
    this.compcommservice.statusob.subscribe((data:any)=>{
      this.statusobj=data
    })
    
  }




}
