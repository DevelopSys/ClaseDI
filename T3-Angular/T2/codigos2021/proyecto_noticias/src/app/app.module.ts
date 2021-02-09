import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TituloComponent } from './components/titulo/titulo.component';
import { NoticiasComponent } from './components/noticias/noticias.component';

@NgModule({
  declarations: [
    AppComponent,
    TituloComponent,
    NoticiasComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
