import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CentralComponent } from './components/central/central.component';
import { AsignaturasComponent } from './components/asignaturas/asignaturas.component';


const routes: Routes = [
  {path: 'tecnologias', component: CentralComponent},
  {path: 'tecnologias/:parametro', component: CentralComponent},
  {path: 'asignaturas/:parametro', component: AsignaturasComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
