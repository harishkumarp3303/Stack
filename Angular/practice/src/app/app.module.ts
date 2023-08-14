import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentCommunicationModule } from './ComponentCommunication/ComponentCommunication.module';
import { NavbarComponent } from './Layouts/navbar/navbar.component';
import { LifecycleModule } from './ComponentLifecycle/lifecycle/lifecycle.module';

import { AngularFormsModule } from './AngularForms/angularforms.module';


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
    AngularFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
