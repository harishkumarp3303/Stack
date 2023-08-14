import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComponentCommunciationComponent } from './ComponentCommunication/component-communciation/component-communciation.component';

const routes: Routes = [
  //  {path:'',component:ComponentCommunciationComponent},
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
