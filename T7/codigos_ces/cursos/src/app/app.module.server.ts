import { NgModule } from '@angular/core';
import { ServerModule } from '@angular/platform-server';

import { AppModule } from './app.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    AppModule,
    ServerModule,
    FormsModule
  ],
  bootstrap: [AppComponent],
})
export class AppServerModule {}
