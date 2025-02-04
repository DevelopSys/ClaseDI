import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
  withEventReplay,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { AsignaturasComponent } from './components/asignaturas/asignaturas.component';
import { BuscadorComponent } from './components/buscador/buscador.component';
import { DetalleComponent } from './components/detalle/detalle.component';
import { ErrorComponent } from './components/error/error.component';
import { DatosService } from './services/datos.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CursosComponent,
    AsignaturasComponent,
    BuscadorComponent,
    DetalleComponent,
    ErrorComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [provideClientHydration(withEventReplay()), DatosService],
  bootstrap: [AppComponent],
})
export class AppModule {}
