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

@NgModule({
  declarations: [App, Agregar, Buscar, Listar, ImagenesPipe, Carta],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners(), provideClientHydration(withEventReplay())],
  bootstrap: [App],
})
export class AppModule {}
