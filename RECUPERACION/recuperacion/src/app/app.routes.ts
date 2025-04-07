import { Routes } from '@angular/router';
import { InformacionComponent } from './components/informacion/informacion.component';
import { FormularioComponent } from './components/formulario/formulario.component';

export const routes: Routes = [
  { path: '**', redirectTo: 'info' }, // Redirige a la página de información si la ruta no coincide
  { path: '', pathMatch: 'full', redirectTo: 'info' },
  { path: 'info', component: InformacionComponent },
  { path: 'form', component: FormularioComponent },
];
