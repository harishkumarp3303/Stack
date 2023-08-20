import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentCommunicationModule } from './ComponentCommunication/ComponentCommunication.module';
import { NavbarComponent } from './Layouts/navbar/navbar.component';
import { LifecycleModule } from './ComponentLifecycle/lifecycle/lifecycle.module';

import { AngularFormsModule } from './AngularForms/angularforms.module';
import { HttpNObservableModule } from './HttpnObservables/httpnobservable.module';
import { AngularRouterModule } from './Router/AngularRouter.module';
import { DirectiveModule } from './Directives/directive.module';
import { PipesModule } from './Pipes/pipes/pipes.module';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ComponentCommunicationModule,
    LifecycleModule,
    AngularFormsModule,
    HttpNObservableModule,
    AngularRouterModule,
    DirectiveModule,
    PipesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
