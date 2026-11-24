import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { AlumnoDTO } from 'app/alumno/alumno.model';
import { map } from 'rxjs';
import { transformRecordToMap } from 'app/common/utils';


@Injectable({
  providedIn: 'root',
})
export class AlumnoService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/alumnoes';

  getAllAlumnoes() {
    return this.http.get<AlumnoDTO[]>(this.resourcePath);
  }

  getAlumno(id: number) {
    return this.http.get<AlumnoDTO>(this.resourcePath + '/' + id);
  }

  createAlumno(alumnoDTO: AlumnoDTO) {
    return this.http.post<number>(this.resourcePath, alumnoDTO);
  }

  updateAlumno(id: number, alumnoDTO: AlumnoDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, alumnoDTO);
  }

  deleteAlumno(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

  getCursoValues() {
    return this.http.get<Record<string, number>>(this.resourcePath + '/cursoValues')
        .pipe(map(transformRecordToMap));
  }

}
