import { Component, EventEmitter, Input, OnChanges,Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {

  @Input()states:string[] =[]
  @Input() email:any
  @Output() sstate:EventEmitter<string>=new EventEmitter<string>()

  constructor() { }

  // ngOnChanges(){
  //   this.states=this.states
  // }
  selectedstate:string="";


  selectstate(){
    this.sstate.emit(this.selectedstate)
  }
}
