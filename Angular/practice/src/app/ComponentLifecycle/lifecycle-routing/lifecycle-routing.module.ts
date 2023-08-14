import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, Routes } from '@angular/router';
import { ChildComponent } from 'src/app/ComponentCommunication/child/child.component';
import { ComponentCommunciationComponent } from 'src/app/ComponentCommunication/component-communciation/component-communciation.component';
import { ParentComponent } from 'src/app/ComponentCommunication/parent/parent.component';
import { LifecycleMainComponent } from '../lifecycle-main/lifecycle-main.component';
import { ComponentAComponent } from '../component-a/component-a.component';
import { ComponentBComponent } from '../component-b/component-b.component';


const routes: Routes = [
  {path: 'lifecycle', component: LifecycleMainComponent,
  children: [
    {path: 'componentA', component: ComponentAComponent},
  {path: 'componentB', component: ComponentBComponent}
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
export class LifecycleRoutingModule { }
