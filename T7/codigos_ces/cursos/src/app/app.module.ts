import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InformacionComponent } from './components/informacion/informacion.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { ImagenesPipe } from './pipes/imagenes.pipe';
import { AsignaturasService } from './services/asignaturas.service';

@NgModule({
  declarations: [
    AppComponent,
    InformacionComponent,
    CursosComponent,
    ImagenesPipe,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [provideClientHydration(), AsignaturasService],
  bootstrap: [AppComponent],
})
export class AppModule {}
