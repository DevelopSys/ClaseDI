import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CochesComponent } from './components/coche/coche.component';
import { FormsModule } from '@angular/forms';
import { ImagenesMarcaPipe } from './pipes/imagenes-marca.pipe';
import { MotosComponent } from './components/motos/motos.component';
import { InformacionComponent } from './components/informacion/informacion.component';

@NgModule({
  declarations: [
    AppComponent,
    CochesComponent,
    ImagenesMarcaPipe,
    MotosComponent,
    InformacionComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
