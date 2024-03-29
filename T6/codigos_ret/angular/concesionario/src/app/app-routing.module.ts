import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CochesComponent } from './components/coche/coche.component';
import { MotosComponent } from './components/motos/motos.component';
import { InformacionComponent } from './components/informacion/informacion.component';

const routes: Routes = [
  { path: 'info', component: InformacionComponent },
  { path: 'coches', component: CochesComponent },
  { path: 'motos', component: MotosComponent },
  { path: 'motos/:tipo', component: MotosComponent },
  { path: '**', redirectTo: 'info' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
