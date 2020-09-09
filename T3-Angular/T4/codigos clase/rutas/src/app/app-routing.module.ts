import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FutbolComponent } from './components/futbol/futbol.component';
import { JuegosComponent } from './components/juegos/juegos.component';
import { AppComponent } from './app.component';
import { ViajesComponent } from './components/secundario/viajes/viajes.component';
import { LibrosComponent } from './components/libros/libros.component';

const routes: Routes = [
  { path: 'futbol', component: FutbolComponent },
  { path: 'futbol/:id', component: FutbolComponent },
  { path: 'videojuegos', component: JuegosComponent },
  { path: 'videojuegos/:id', component: JuegosComponent },
  { path: 'libros', component: LibrosComponent },
  {
    path: 'viajes',
    loadChildren: () => import('./components/secundario/secundario.module').then(m => m.SecundarioModule)
  },
  { path: '', redirectTo: '/', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
