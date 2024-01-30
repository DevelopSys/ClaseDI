import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConcesionarioComponent } from './components/concesionario/concesionario.component';
import { FormsModule } from '@angular/forms';
import { ImagenesPipe } from './pipes/imagenes.pipe';

@NgModule({
  declarations: [AppComponent, ConcesionarioComponent, ImagenesPipe],
  imports: [FormsModule, BrowserModule, AppRoutingModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
