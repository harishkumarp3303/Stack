import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LifecycleMainComponent } from '../lifecycle-main/lifecycle-main.component';
import { ComponentAComponent } from '../component-a/component-a.component';
import { ComponentBComponent } from '../component-b/component-b.component';
import { LifecycleRoutingModule } from '../lifecycle-routing/lifecycle-routing.module';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    LifecycleMainComponent,
    ComponentAComponent,
    ComponentBComponent
  ],
  imports: [
    CommonModule,
    LifecycleRoutingModule,
    FormsModule
  ],
  exports:[LifecycleMainComponent,ComponentAComponent,ComponentBComponent]
})
export class LifecycleModule { }
