import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConcesionarioComponent } from './components/concesionario/concesionario.component';
import { FormsModule } from '@angular/forms';
import { ImagenesMarcaPipe } from './pipes/imagenes-marca.pipe';

@NgModule({
  declarations: [AppComponent, ConcesionarioComponent, ImagenesMarcaPipe],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
