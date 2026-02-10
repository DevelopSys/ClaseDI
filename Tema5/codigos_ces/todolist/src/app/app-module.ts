import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Agregar } from './components/agregar/agregar';
import { Buscar } from './components/buscar/buscar';
import { Listar } from './components/listar/listar';
import { FormsModule } from '@angular/forms';
import { ImagenesPipe } from './pipes/imagenes-pipe';
import { Carta } from './components/carta/carta';
import { Detail } from './components/detail/detail';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';

@NgModule({
  declarations: [App, Agregar, Buscar, Listar, ImagenesPipe, Carta, Detail],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [App],
})
export class AppModule {}
