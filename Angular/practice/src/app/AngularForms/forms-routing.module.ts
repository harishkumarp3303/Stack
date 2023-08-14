import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { FormarrayComponent } from "./formarray/formarray.component";
import { FormsMainComponent } from "./forms-main/forms-main.component";
import { ReactiveComponent } from "./reactive/reactive.component";
import { TemplatedrivenComponent } from "./templatedriven/templatedriven.component";


const routes: Routes = [
  {path: 'forms', component: FormsMainComponent,
  children: [
    {path: 'templatedriven', component: TemplatedrivenComponent},
  {path: 'reactive', component: ReactiveComponent},
  {path: 'formarray', component: FormarrayComponent}
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
export class formsRoutingModule { }
