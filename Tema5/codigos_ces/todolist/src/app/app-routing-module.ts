import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Agregar } from './components/agregar/agregar';
import { Listar } from './components/listar/listar';
import { Buscar } from './components/buscar/buscar';

const routes: Routes = [
  { path: 'agregar', component: Agregar },
  { path: 'listar', component: Listar },
  { path: 'buscar', component: Buscar },
  { path: 'buscar/:id', component: Buscar },
  { path: '**', pathMatch: 'full', redirectTo: 'agregar' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
