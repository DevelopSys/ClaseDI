import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FutbolistasComponent } from './components/futbolistas/futbolistas.component';
import { VideojuegosComponent } from './components/videojuegos/videojuegos.component';
import { CicloVidaComponent } from './components/ciclo-vida/ciclo-vida.component';
import { ClasesComponent } from './components/clases/clases.component';


@NgModule({
  declarations: [
    AppComponent, FutbolistasComponent, VideojuegosComponent, CicloVidaComponent, ClasesComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
