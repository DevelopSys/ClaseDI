import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GeneralComponent } from './components/general/general.component';
import { FormularioComponent } from './components/formulario/formulario.component';
import { CursoComponent } from './components/curso/curso.component';
import { ErrorComponent } from './components/error/error.component';
import { GestionComponent } from './components/gestion/gestion.component';

const routes: Routes = [
  { path: 'gestion', component: GestionComponent },
  { path: 'general', component: GeneralComponent },
  { path: 'matriculacion', component: FormularioComponent },
  { path: 'cursos/:curso', component: CursoComponent },
  { path: 'error', component: ErrorComponent },
  { path: '**', redirectTo: 'error' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
