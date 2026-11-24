import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { CursoDTO } from 'app/curso/curso.model';


@Injectable({
  providedIn: 'root',
})
export class CursoService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/cursoes';

  getAllCursoes() {
    return this.http.get<CursoDTO[]>(this.resourcePath);
  }

  getCurso(id: number) {
    return this.http.get<CursoDTO>(this.resourcePath + '/' + id);
  }

  createCurso(cursoDTO: CursoDTO) {
    return this.http.post<number>(this.resourcePath, cursoDTO);
  }

  updateCurso(id: number, cursoDTO: CursoDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, cursoDTO);
  }

  deleteCurso(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

}
