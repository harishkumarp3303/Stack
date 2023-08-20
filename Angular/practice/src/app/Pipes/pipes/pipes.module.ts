import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';

import { DemoComponent } from '../demo/demo.component';
import { TitlecasePipe } from '../titlecase.pipe';
import { Route, RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { FormatterPipe } from '../formatter.pipe';


const routes:Routes=[
  {path:'pipes',component:DemoComponent},
]

@NgModule({
  declarations: [
    DemoComponent,
    TitlecasePipe,
    FormatterPipe

  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule
  ],
  
})
export class PipesModule { }
