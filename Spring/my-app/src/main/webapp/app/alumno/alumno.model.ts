export class AlumnoDTO {

  constructor(data:Partial<AlumnoDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  name?: string|null;
  mail?: string|null;
  curso?: number|null;

}
