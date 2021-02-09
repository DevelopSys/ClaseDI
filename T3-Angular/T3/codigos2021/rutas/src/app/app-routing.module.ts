import { InicialComponent } from './components/inicial/inicial.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecundarioComponent } from './components/secundario/secundario.component';


const routes: Routes = [

  {path:"compo-uno",component:InicialComponent},
  {path:"compo-dos",component:SecundarioComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
