import { NgModule } from "@angular/core";
import { AngularrouterRouter } from "./AngularRouting-routing.module";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { ProductdetailComponent } from './productdetail/productdetail.component';





@NgModule({
  declarations: [


  
    HomeComponent,
           ProductComponent,
           ProductdetailComponent
  ],
  imports: [
    CommonModule,
    AngularrouterRouter,
    FormsModule
  ],
  exports:[]
})
export class AngularRouterModule { }
