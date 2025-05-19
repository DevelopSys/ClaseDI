import { Routes } from '@angular/router';
import { InformacionComponent } from './components/informacion/informacion.component';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListadoComponent } from './components/listado/listado.component';
import { PaisesComponent } from './components/paises/paises.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'info' },
  { path: 'info', component: InformacionComponent },
  { path: 'form', component: FormularioComponent },
  { path: 'list', component: ListadoComponent },
  { path: 'countries', component: PaisesComponent },
  { path: '**', redirectTo: 'info' }, // Redirige a la página de información si la ruta no coincide
];
