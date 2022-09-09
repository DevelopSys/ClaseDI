import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InformacionComponent } from './core/informacion/informacion.component';
import { CursosComponent } from './core/cursos/cursos.component';
import { HomeComponent } from './core/home/home.component';
import { ImagenPipe } from './pipe/imagen.pipe';
import { ConexionComponent } from './core/conexion/conexion.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    InformacionComponent,
    CursosComponent,
    HomeComponent,
    ImagenPipe,
    ConexionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
