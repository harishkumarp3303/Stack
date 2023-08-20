import { Directive, ElementRef, Host, HostListener, OnInit } from '@angular/core';

@Directive({
  selector: '[appColourChanger]'
})
export class ColourChangerDirective implements OnInit{


  constructor(private el:ElementRef) {
    
  
   }
  ngOnInit(): void {
    
  }

  @HostListener('mouseenter') 
  onMouseEnter() {
    this.el.nativeElement.style.backgroundColor = "red";
    this.el.nativeElement.innerHTML = "Welcome harish";
  
  }

  @HostListener('mouseleave')
   onMouseLeave() {
   this.el.nativeElement.style.backgroundColor = "white";
   this.el.nativeElement.innerHTML= "Bye harish";
   }
  

   

}
