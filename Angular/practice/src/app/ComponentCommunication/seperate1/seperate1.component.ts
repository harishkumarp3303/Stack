import { Component, ElementRef, ViewChild ,OnInit} from '@angular/core';
import { ComponentcommService, StatusObj } from '../services/componentcomm.service';

@Component({
  selector: 'app-seperate1',
  templateUrl: './seperate1.component.html',
  styleUrls: ['./seperate1.component.css']
})
export class Seperate1Component implements OnInit {
  constructor(private compcommservice:ComponentcommService){
    
  }
  ngOnInit(): void {
    
  }

  status:StatusObj={
    status: '',
    text: '',
    background: ''
  }

  @ViewChild('text', { static: false }) text: ElementRef | undefined;

  login(){

    // alert(this.text?.nativeElement.value)
    this.status.status="Hi "+this.text?.nativeElement.value+" welcome you are now logged IN"
    this.status.background="green"
    this.status.text="white"
    this.compcommservice.setstatusobj(this.status)
  }

  logout(){

    this.status.status="Hi "+this.text?.nativeElement.value+" you are logged out"
    this.status.background="red"
    this.status.text="white"
  }
  
}
