import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { AsignaturasComponent } from './components/asignaturas/asignaturas.component';
import { BuscadorComponent } from './components/buscador/buscador.component';
import { ErrorComponent } from './components/error/error.component';
import { DetalleComponent } from './components/detalle/detalle.component';

/* 
http://localhost:4200/ -> home
http://localhost:4200/home -> homer
http://localhost:4200/buscador -> buscador
http://localhost:4200/cursos -> cursos
http://localhost:4200/asignaturas -> asignaturas
http://localhost:4200/detalle -> error
*/

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'cursos',
    component: CursosComponent,
    children: [
      {
        path: 'detalle',
        component: DetalleComponent,
      },
    ],
  },
  {
    path: 'asignaturas',
    component: AsignaturasComponent,
    children: [
      {
        path: 'detalle',
        component: DetalleComponent,
      },
    ],
  },
  {
    path: 'buscador',
    component: BuscadorComponent,
  },
  {
    path: 'detalle/:tipo/:id',
    component: DetalleComponent,
  },
  {
    path: '**',
    component: ErrorComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
