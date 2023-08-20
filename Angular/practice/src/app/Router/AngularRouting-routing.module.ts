import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { ProductComponent } from "./product/product.component";
import { ProductdetailComponent } from "./productdetail/productdetail.component";



const routes: Routes = [
    {path: 'router', component: HomeComponent,
    children: [

    {path: 'product', component: ProductComponent},
    {path: 'productdetail', component: ProductdetailComponent},
    {path: 'productdetail/:id/:name/:price', component: ProductdetailComponent},
    {path: 'productdetail/:id/:name', component: ProductdetailComponent}
    ]
  },
]
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports:[RouterModule]
})
export class AngularrouterRouter { }
