import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViajesComponent } from './viajes/viajes.component';

const routes: Routes = [{ path: '', component: ViajesComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SecundarioRoutingModule { }
