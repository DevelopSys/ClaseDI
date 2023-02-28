import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { from } from 'rxjs';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DirectivaifComponent } from './components/directivaif/directivaif.component';
import { DirectivaswitchComponent } from './components/directivaswitch/directivaswitch.component';
import { UnoComponent } from './components/uno/uno.component';
import { DosComponent } from './components/dos/dos.component';
import { TresComponent } from './components/tres/tres.component';

@NgModule({
  declarations: [AppComponent, DirectivaifComponent, DirectivaswitchComponent, UnoComponent, DosComponent, TresComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
