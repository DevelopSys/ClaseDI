import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CentralComponent } from './components/central/central.component';


const routes: Routes = [

  {path: 'central', component: CentralComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
