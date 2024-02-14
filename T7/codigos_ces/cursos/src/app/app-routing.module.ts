import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformacionComponent } from './components/informacion/informacion.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { BuscadorComponent } from './components/buscador/buscador.component';

const routes: Routes = [
  {
    path: 'cursos',
    component: CursosComponent,
  },
  {
    path: 'buscador',
    component: BuscadorComponent,
  },
  {
    path: 'buscador/:curso',
    component: BuscadorComponent,
  },
  {
    path: 'buscador/:curso/:nivel',
    component: BuscadorComponent,
  },
  {
    path: 'info',
    component: InformacionComponent,
  },

  {
    path: '**',
    redirectTo: "info",
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
