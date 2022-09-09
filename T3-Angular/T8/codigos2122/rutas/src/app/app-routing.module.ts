import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConexionComponent } from './core/conexion/conexion.component';
import { CursosComponent } from './core/cursos/cursos.component';
import { DamComponent } from './core/dam/dam.component';
import { HomeComponent } from './core/home/home.component';
import { InformacionComponent } from './core/informacion/informacion.component';

const routes: Routes = [
  { path: 'informacion', component: InformacionComponent },
  { path: 'profesores', component: ConexionComponent },
  { path: 'cursos/:ciclo', component: CursosComponent },
  { path: 'home', component: HomeComponent },
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
