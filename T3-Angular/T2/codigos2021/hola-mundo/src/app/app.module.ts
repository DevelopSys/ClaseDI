import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ColumnaUnoComponent } from './components/columna-uno/columna-uno.component';
import { ColumnaDosComponent } from './components/columna-dos/columna-dos.component';
import { ColumnaTresComponent } from './components/columna-tres/columna-tres.component';
import {BarraNavegacionComponent} from './components/barra-navegacion/barra-navegacion.component';
import { MateriaComponent } from './components/materia/materia.component';

@NgModule({
  declarations: [
    AppComponent,
    ColumnaUnoComponent,
    ColumnaDosComponent,
    ColumnaTresComponent,
    BarraNavegacionComponent,
    MateriaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
