import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EscribirComponent } from './components/escribir/escribir.component';
import { ListarComponent } from './components/listar/listar.component';

const routes: Routes = [
  { path: 'mandar', component: EscribirComponent },
  { path: 'listar', component: ListarComponent },
  { path: '**', redirectTo: 'mandar' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
