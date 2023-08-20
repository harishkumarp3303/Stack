import { NgModule } from "@angular/core";
import { HttpComponent } from "./http/http.component";
import { ObservableComponent } from "./observable/observable.component";
import { HttpnobservableMainComponent } from "./httpnobservable-main/httpnobservable-main.component";
import { CommonModule } from "@angular/common";
import { httpnObservableRoutingModule } from "./httpobservable-routing.module";
import { FormsModule } from "@angular/forms";
import { OperatorsComponent } from './operators/operators.component';

import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
 HttpComponent,
 ObservableComponent,
 HttpnobservableMainComponent,
 OperatorsComponent
 
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    httpnObservableRoutingModule,
    FormsModule,
    
  ],
  exports:[]
})
export class HttpNObservableModule { }
