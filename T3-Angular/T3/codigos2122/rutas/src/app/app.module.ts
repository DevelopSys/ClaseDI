import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InformacionComponent } from './core/informacion/informacion.component';
import { CursosComponent } from './core/cursos/cursos.component';
import { HomeComponent } from './core/home/home.component';
import { ImagenPipe } from './pipe/imagen.pipe';

@NgModule({
  declarations: [
    AppComponent,
    InformacionComponent,
    CursosComponent,
    HomeComponent,
    ImagenPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
