import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolistasComponent } from './components/futbolistas/futbolistas.component';
import { VideojuegosComponent } from './components/videojuegos/videojuegos.component';
import { CicloVidaComponent } from './components/ciclo-vida/ciclo-vida.component';


@NgModule({
  declarations: [
    AppComponent, FutbolistasComponent, VideojuegosComponent, CicloVidaComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
