import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursosComponent } from './components/cursos/cursos.component';
import { InformacionComponent } from './components/informacion/informacion.component';

const routes: Routes = [
  { path: 'info', component: InformacionComponent },
  { path: 'cursos', component: CursosComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
