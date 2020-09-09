import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SecundarioRoutingModule } from './secundario-routing.module';
import { ViajesComponent } from './viajes/viajes.component';


@NgModule({
  declarations: [ViajesComponent],
  imports: [
    CommonModule,
    SecundarioRoutingModule
  ]
})
export class SecundarioModule { }
