import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BindComponent } from './components/bind/bind.component';
import { ForComponent } from './components/for/for.component';
import { IfComponent } from './components/if/if.component';
import { SwitchComponent } from './components/switch/switch.component';

@NgModule({
  declarations: [
    AppComponent,
    BindComponent,
    IfComponent,
    SwitchComponent,
    ForComponent  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
