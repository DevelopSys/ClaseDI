import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
  withEventReplay,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ListadoComponent } from './components/listado/listado.component';
import { DetalleComponent } from './components/detalle/detalle.component';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './service/api.service';
import { ImagesPipe } from './pipe/images.pipe';
import { PostcardComponent } from './components/postcard/postcard.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListadoComponent,
    DetalleComponent,
    ImagesPipe,
    PostcardComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [provideClientHydration(withEventReplay()), ApiService],
  bootstrap: [AppComponent],
})
export class AppModule {}
