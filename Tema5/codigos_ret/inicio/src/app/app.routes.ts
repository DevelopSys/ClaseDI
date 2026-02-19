import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Tareas } from './components/tareas/tareas';
import { Hobbies } from './components/hobbies/hobbies';

export const routes: Routes = [
  { path: 'home', component: Home },
  { path: 'hobbies', component: Hobbies },
  { path: 'tareas', component: Tareas },
  { path: 'tareas/:id', component: Tareas },
  { path: '**', pathMatch: 'full', redirectTo: 'home' },
];
