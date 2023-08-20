import { NgModule } from "@angular/core";
import { HttpComponent } from "./http/http.component";
import { HttpnobservableMainComponent } from "./httpnobservable-main/httpnobservable-main.component";
import { ObservableComponent } from "./observable/observable.component";
import { CommonModule } from "@angular/common";
import { Routes, RouterModule } from "@angular/router";
import { OperatorsComponent } from "./operators/operators.component";




const routes: Routes = [
  {path: 'httpnobservable', component: HttpnobservableMainComponent,
  children: [
    {path: 'observable', component: ObservableComponent},
  {path: 'http', component: HttpComponent},
  {path:'operators',component:OperatorsComponent}

  ]
},
  
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports:[RouterModule]
})
export class httpnObservableRoutingModule { }
