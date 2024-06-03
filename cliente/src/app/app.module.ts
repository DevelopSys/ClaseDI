import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EscribirComponent } from './components/escribir/escribir.component';
import { ListarComponent } from './components/listar/listar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, EscribirComponent, ListarComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
