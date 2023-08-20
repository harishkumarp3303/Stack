import { AfterViewInit, Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Observable, Subscription, debounce, debounceTime, from, fromEvent, interval, of } from 'rxjs';

@Component({
  selector: 'app-observable',
  templateUrl: './observable.component.html',
  styleUrls: ['./observable.component.css']
})
export class ObservableComponent implements OnInit,OnDestroy{

  fetcheddata:any
  subscription: Subscription = new Subscription();
  customsubscription: Subscription = new Subscription();
  @ViewChild('btn') buttonclicked:ElementRef|undefined

  obs=new Observable(
    (observer)=>{
      // observer.error(Error("Exception occured"))
      // let arr=[1,2,3,4,5]
      // observer.next(arr)
      observer.next(1)
      observer.next(2)
      observer.next(3)
      observer.next(4)
      observer.next(5)
      observer.complete()
    })
  ;

  // another methods to create observable

  // create method
  // ob1=Observable.create((observer:any)=>{
  //   observer.next(1)
  //   observer.next(2)
  //   observer.next(3)
  //   observer.next(4)
  //   observer.next(5)
  //   observer.complete()
  // }

  arr=[1,2,3,4,5]
  arrstr=["Strings","another string"]

  // Differences of vs from
  // of method
  
  // obs1=of(this.arr)

  obs2=of(this.arr,this.arrstr)

  // from method

  obs3=from(this.arr)
  // obs3=from(this.arrstr)

  constructor() { }

  // interval observable 

  obsint=interval(1000)



 
  ngOnInit(): void {
    console.log("ObservableComponent initializaed")

    console.log(this.obs.subscribe(this.accept,this.reject,this.complete))
    
    this.obs2.subscribe((data:any)=>console.log("Of method :"+data))

    this.obs3.subscribe((data:any)=>console.log("from method : "+data))

    // interval method
    // this.subscription=this.obsint.subscribe((data:any)=>console.log("interval method : "+data))


    // custom observable
    let customObservable=Observable.create((observer:any)=>{

    let count=0;
    setInterval(()=>{
      observer.next(count)
      count++
    },1000)
    }

    )

    // this.customsubscription= customObservable.subscribe((data:any)=>console.log("Custom Observable : "+data))


    let anothercustomObservable=Observable.create((observer:any)=>{

      let count=0;
      setInterval(()=>{
        observer.next(count)

        // if --count ==3 throw an eeror
        // if(count>3){
        //   observer.error(Error("Exception occured"))
        
        // }
        // --if count ==5 stop the observable and complete it 
        
        if(count===5){
          observer.complete()
        }
        count++
      },1000)
      })

      anothercustomObservable.subscribe((data:any)=>
      console.log("Another Custom Observable : "+data)
      ,(error:any)=>console.log("Error : "+error.message)
      ,()=>console.log("Completed observing")
      )

  }
  
  ngOnDestroy(): void {
    console.log("ObservableComponent destroyed ")
    this.subscription.unsubscribe()
    this.customsubscription.unsubscribe()
  }

  
  accept(data:any){
    // console.log("Succes : "+ data)
    this.fetcheddata=data
    // console.log(this.fetcheddata)
  }

  reject(data:Error){
    console.log("error : "+data.message)
  }
  complete(){
    console.log("complete")
  }


  // from event

  buttonsubscription: any
  buttonclick(){
    console.log(this.buttonclicked)
    this.buttonsubscription=fromEvent(this.buttonclicked?.nativeElement,'click')
    .pipe(debounceTime(1000))
    .subscribe((data:any)=>console.log(data))
  }

  // rxjs operators


  
  



}
