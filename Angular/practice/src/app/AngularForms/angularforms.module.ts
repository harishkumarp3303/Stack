import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { FormsMainComponent } from "./forms-main/forms-main.component";
import { ReactiveComponent } from "./reactive/reactive.component";
import { TemplatedrivenComponent } from "./templatedriven/templatedriven.component";
import { formsRoutingModule } from "./forms-routing.module";




@NgModule({
  declarations: [
    FormsMainComponent,
    TemplatedrivenComponent,
    ReactiveComponent,
    FormsMainComponent
  ],
  imports: [
    CommonModule,
    formsRoutingModule,
    FormsModule
  ],
  exports:[]
})
export class AngularFormsModule { }
