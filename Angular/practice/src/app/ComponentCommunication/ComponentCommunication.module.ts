import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ParentComponent } from "./parent/parent.component";
import { ChildComponent } from "./child/child.component";
import { ComponentCommunciationComponent } from './component-communciation/component-communciation.component';
import { ComponentCommunciationRoutingModule } from "./ComponentCommunicationrouting.module";
import { FormsModule } from "@angular/forms";
import { Seperate1Component } from "./seperate1/seperate1.component";
import { Seperate2Component } from "./seperate2/seperate2.component";


@NgModule({
    declarations: [
        ParentComponent,
        ChildComponent,
        ComponentCommunciationComponent,
        Seperate1Component,
        Seperate2Component
    ],
    imports: [
    ComponentCommunciationRoutingModule,
    CommonModule,
    FormsModule
    ],
    exports: [ComponentCommunciationRoutingModule]

  })
  export class ComponentCommunicationModule { }