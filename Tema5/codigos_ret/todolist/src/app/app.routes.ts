import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Add } from './components/add/add';
import { List } from './components/list/list';
import { Find } from './components/find/find';

export const routes: Routes = [
  {
    path: 'home',
    component: Home,
  },
  {
    path: 'agregar',
    component: Add,
  },
  {
    path: 'listar',
    component: List,
  },
  {
    path: 'buscar',
    component: Find,
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: 'home ',
  },
];
