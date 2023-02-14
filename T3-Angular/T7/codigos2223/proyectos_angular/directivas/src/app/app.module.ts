import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventosComponent } from './components/eventos/eventos.component';
import { DirectivaifComponent } from './components/directivaif/directivaif.component';
import { DirectivaswitchComponent } from './components/directivaswitch/directivaswitch.component';

@NgModule({
  declarations: [
    AppComponent,
    EventosComponent,
    DirectivaifComponent,
    DirectivaswitchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
