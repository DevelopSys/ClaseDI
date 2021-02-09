import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TituloComponent } from './components/titulo/titulo.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { NoticiasService } from './services/noticias.service';
import { ImagenesPipe } from './pipes/imagenes.pipe';

@NgModule({
  declarations: [
    AppComponent,
    TituloComponent,
    NoticiasComponent,
    ImagenesPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [NoticiasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
