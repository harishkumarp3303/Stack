import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ComponentCommunciationComponent } from "./component-communciation/component-communciation.component";
import { ParentComponent } from "./parent/parent.component";
import { ChildComponent } from "./child/child.component";


const routes: Routes = [
    {path: 'componentcommunciation', component: ComponentCommunciationComponent,
    children: [
      {path: 'parent', component: ParentComponent},
    {path: 'child', component: ChildComponent}
    ]
  },
    
];




@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ComponentCommunciationRoutingModule{

}