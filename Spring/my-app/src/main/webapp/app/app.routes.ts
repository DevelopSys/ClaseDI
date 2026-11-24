import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AlumnoListComponent } from './alumno/alumno-list.component';
import { AlumnoAddComponent } from './alumno/alumno-add.component';
import { AlumnoEditComponent } from './alumno/alumno-edit.component';
import { CursoListComponent } from './curso/curso-list.component';
import { CursoAddComponent } from './curso/curso-add.component';
import { CursoEditComponent } from './curso/curso-edit.component';
import { ErrorComponent } from './error/error.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: $localize`:@@home.index.headline:Welcome to your new app!`
  },
  {
    path: 'alumnoes',
    component: AlumnoListComponent,
    title: $localize`:@@alumno.list.headline:Alumnoes`
  },
  {
    path: 'alumnoes/add',
    component: AlumnoAddComponent,
    title: $localize`:@@alumno.add.headline:Add Alumno`
  },
  {
    path: 'alumnoes/edit/:id',
    component: AlumnoEditComponent,
    title: $localize`:@@alumno.edit.headline:Edit Alumno`
  },
  {
    path: 'cursoes',
    component: CursoListComponent,
    title: $localize`:@@curso.list.headline:Cursoes`
  },
  {
    path: 'cursoes/add',
    component: CursoAddComponent,
    title: $localize`:@@curso.add.headline:Add Curso`
  },
  {
    path: 'cursoes/edit/:id',
    component: CursoEditComponent,
    title: $localize`:@@curso.edit.headline:Edit Curso`
  },
  {
    path: 'error',
    component: ErrorComponent,
    title: $localize`:@@error.page.headline:Error`
  },
  {
    path: '**',
    component: ErrorComponent,
    title: $localize`:@@notFound.headline:Page not found`
  }
];
