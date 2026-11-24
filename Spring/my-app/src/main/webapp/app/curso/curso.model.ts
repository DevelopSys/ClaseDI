export class CursoDTO {

  constructor(data:Partial<CursoDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  name?: string|null;

}
