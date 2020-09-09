import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolComponent } from './components/futbol/futbol.component';
import { JuegosComponent } from './components/juegos/juegos.component';
import { MenuBarraComponent } from './components/shared/menu-barra/menu-barra.component';
import { SecundarioModule } from './components/secundario/secundario.module';
import { LibrosComponent } from './components/libros/libros.component';
import { FutbolDataService } from './services/futbol-data.service';
import { HttpClientModule } from '@angular/common/http';
import { ImagenPipe } from './pipes/imagen.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FutbolComponent,
    JuegosComponent,
    MenuBarraComponent,
    LibrosComponent,
    ImagenPipe,
  ],
  imports: [BrowserModule, AppRoutingModule, SecundarioModule, HttpClientModule],
  providers: [FutbolDataService],
  bootstrap: [AppComponent],
})
export class AppModule {}
