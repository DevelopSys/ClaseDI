import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ErrorComponent } from './components/error/error.component';
import { GeneralComponent } from './components/general/general.component';
import { CursoComponent } from './components/curso/curso.component';
import { AsignaturaComponent } from './components/asignatura/asignatura.component';
import { FormularioComponent } from './components/formulario/formulario.component';
import { FormsModule } from '@angular/forms';
import { ContratacionComponent } from './components/contratacion/contratacion.component';
import { AsignacionComponent } from './components/asignacion/asignacion.component';
import { GestionComponent } from './components/gestion/gestion.component';

@NgModule({
  declarations: [
    AppComponent,
    ErrorComponent,
    GeneralComponent,
    CursoComponent,
    AsignaturaComponent,
    FormularioComponent,
    ContratacionComponent,
    AsignacionComponent,
    GestionComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
