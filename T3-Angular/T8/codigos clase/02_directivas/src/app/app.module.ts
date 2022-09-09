import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DirectivasComponent } from './components/directivas/directivas.component';
import { PipesPersoComponent } from './components/pipes-perso/pipes-perso.component';
import { PipePersoPipe } from './pipes/pipe-perso.pipe';

@NgModule({
  declarations: [
    AppComponent,
    DirectivasComponent,
    PipesPersoComponent,
    PipePersoPipe
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
