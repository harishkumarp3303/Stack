import { Component, OnChanges, OnInit ,DoCheck, AfterViewInit,AfterViewChecked,AfterContentInit,AfterContentChecked,OnDestroy, SimpleChanges, Input} from '@angular/core';

@Component({
  selector: 'app-component-a',
  templateUrl: './component-a.component.html',
  styleUrls: ['./component-a.component.css']
})
export class ComponentAComponent implements OnChanges,OnInit,DoCheck, AfterViewInit,AfterViewChecked,AfterContentInit,AfterContentChecked,OnDestroy {

  @Input() x:String=""
  msg:any
  counter=0
  constructor(){
    console.log("Constructor of Component A")
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges of Component A.');
    console.log(changes['x'])
  }
  ngOnInit(): void {
    console.log("ngOnInit of Component A")
  }
  ngDoCheck(): void {
    console.log("ngDoCheck of Component A")
  }

  call(){
    this.counter++
    console.log(this.counter)
  }
  
  ngAfterViewInit(): void {
    console.log("ngAfterViewInit of Component A")
  }
  ngAfterViewChecked(): void {
    console.log("ngAfterViewChecked of Component A")
  }
  ngAfterContentInit(): void {
    console.log("ngAfterContentInit of Component A")
  }
  ngAfterContentChecked(): void {
    console.log("ngAfterContentChecked of Component A")
  }
  ngOnDestroy(): void {
    console.log("ngOnDestroy of Component A")
  }

}
