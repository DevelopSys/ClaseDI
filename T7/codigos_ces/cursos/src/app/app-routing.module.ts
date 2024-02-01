import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformacionComponent } from './components/informacion/informacion.component';
import { CursosComponent } from './components/cursos/cursos.component';

const routes: Routes = [
  {
    path: 'informacion',
    component: InformacionComponent,
  },
  {
    path: 'cursos',
    component: CursosComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
