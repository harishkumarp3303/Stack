import { NgModule } from "@angular/core";
import { DemoComponent } from './demo/demo.component';
import { RouterModule, Routes } from "@angular/router";
import { ColourChangerDirective } from './colour-changer.directive';
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { MinLengthDirective } from './min-length.directive';


const routes:Routes=[
    {path:'directives',component:DemoComponent}
]
@NgModule({
    declarations: [
    DemoComponent,
    ColourChangerDirective,
    MinLengthDirective,
 
  ],
    imports:[RouterModule.forRoot(routes)
    ,
    FormsModule,
    CommonModule],
    exports:[DemoComponent,RouterModule],
    providers:[],
})
export class DirectiveModule {
    constructor() { }
}