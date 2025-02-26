import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoComponent } from './components/listado/listado.component';
import { BuscadorComponent } from './components/buscador/buscador.component';
import { DetalleComponent } from './components/detalle/detalle.component';
import { ErrorComponent } from './components/error/error.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'listado' },
  {
    path: 'listado',
    component: ListadoComponent,
    children: [
      {
        path: 'detalle',
        component: ErrorComponent,
      },
      {
        path: 'comun',
        component: BuscadorComponent,
      },
    ],
  },
  { path: 'buscador', component: BuscadorComponent },
  { path: 'detalle', component: DetalleComponent },
  { path: '**', component: ErrorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
