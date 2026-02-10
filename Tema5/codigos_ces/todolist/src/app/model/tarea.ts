export interface tarea {
  id: number;
  nombre: string | undefined;
  responsable: string | undefined;
  items: string[];
  fecha: string | undefined;
  prioridad: number;
  descipcion: string | undefined;
}
