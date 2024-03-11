import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { LigasComponent } from './components/ligas/ligas.component';
import { LigasService } from './services/ligas.service';

@NgModule({
  declarations: [AppComponent, LigasComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [provideClientHydration(), LigasService],
  bootstrap: [AppComponent],
})
export class AppModule {}
