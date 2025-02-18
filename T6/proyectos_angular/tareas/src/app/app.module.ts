import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AddComponent } from './components/add/add.component';
import { ListComponent } from './components/list/list.component';
import { FindComponent } from './components/find/find.component';
import { ModifyComponent } from './components/modify/modify.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddComponent,
    ListComponent,
    FindComponent,
    ModifyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration(withEventReplay())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
