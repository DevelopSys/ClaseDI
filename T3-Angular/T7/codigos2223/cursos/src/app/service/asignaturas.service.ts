import { Injectable } from '@angular/core';
import { AsignaturaInterfaz } from '../model/asignatura_interfaz';

@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  ciclos: string[] = ['DAM', 'DAW', 'ASIR', 'TODOS'];
  asignturas: AsignaturaInterfaz[] = [
    {
      nombre: 'Progmacion Multimedia',
      siglas: 'PMDM',
      horas: 6,
      curso: 2,
      ciclo: 'DAM',
      imagen:
        'https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Android_logo_2019_%28stacked%29.svg/1200px-Android_logo_2019_%28stacked%29.svg.png',
      conocimientos: ['Kotlin', 'Android', 'XML'],
    },
    {
      nombre: 'Desarrollo Interfaces',
      siglas: 'DI',
      horas: 6,
      curso: 2,
      ciclo: 'DAM',
      imagen:
        'https://bs-uploads.toptal.io/blackfish-uploads/components/seo/content/og_image_file/og_image/1096617/top-18-most-common-angularjs-developer-mistakes-41f9ad303a51db70e4a5204e101e7414.png',
      conocimientos: ['Java', 'Js', 'Angular', 'JavaFX'],
    },
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      horas: 8,
      curso: 1,
      ciclo: 'DAM|DAW',
      imagen:
        'https://contentstatic.techgig.com/photo/93000110/what-makes-java-still-popular-among-developers.jpg?28608',
      conocimientos: ['Java', 'JDBC'],
    },
    {
      nombre: 'Base Datos',
      siglas: 'BD',
      horas: 6,
      curso: 1,
      ciclo: 'DAM|DAW|ASIR',
      imagen:
        'https://bs-uploads.toptal.io/blackfish-uploads/components/seo/content/og_image_file/og_image/1154099/0712-Bad_Practices_in_Database_Design_-_Are_You_Making_These_Mistakes_Dan_Social-754bc73011e057dc76e55a44a954e0c3.png',
      conocimientos: ['MySQL', 'Mongo'],
    },
    {
      nombre: 'Implantacion de sistemas opetativos',
      siglas: 'ISO',
      horas: 8,
      curso: 1,
      ciclo: 'ASIR',
      imagen:
        'https://artoftesting.com/wp-content/uploads/2022/02/operating-system.png',
      conocimientos: ['Windows', 'Linux', 'Powershell', 'Bash'],
    },
    {
      nombre: 'Desarrollo cliente',
      siglas: 'DAWC',
      horas: 6,
      curso: 2,
      ciclo: 'DAW',
      imagen:
        'https://bs-uploads.toptal.io/blackfish-uploads/components/seo/content/og_image_file/og_image/1154083/react-context-api-4929b3703a1a7082d99b53eb1bbfc31f.png',
      conocimientos: ['Js', 'React', 'React Native'],
    },
    {
      nombre: 'Desarrollo servidor',
      siglas: 'DAWS',
      horas: 9,
      curso: 2,
      ciclo: 'DAW',
      imagen: '',
      conocimientos: ['PHP', 'Python'],
    },
    {
      nombre: 'Administacion de sistemas operativos',
      siglas: 'ASO',
      horas: 6,
      curso: 2,
      ciclo: 'ASIR',
      imagen:
        'https://media.geeksforgeeks.org/wp-content/uploads/20200429161002/server-image-1.png',
      conocimientos: [
        'Servidores',
        'Linux',
        'Windows',
        'PowerShell',
        'AD',
        'Bash',
      ],
    },

    {
      nombre: 'Implantacion de Aplicaciones Web',
      siglas: 'IAW',
      horas: 6,
      curso: 2,
      ciclo: 'ASIR',
      imagen: '',
      conocimientos: ['JS', 'Bash'],
    },
  ];

  constructor() {
    // consulta y llenado de arrays
    // promesa
    /* fetch("asdasd",{method:"POST",body:{}}) */
  }

  getAllCiclos(): string[] {
    return this.ciclos;
  }

  getAllAsignaturas(): AsignaturaInterfaz[] {
    console.log('Servicio llamado');

    return this.asignturas;
  }

  getAsignaturasCursoCiclo(ciclo: string, curso: string): AsignaturaInterfaz[] {
    return this.asignturas.filter(
      (item) => item.ciclo.includes(ciclo) && item.curso == Number(curso)
    );
  }

  getAsignaturasConocimiento(conocimiento: string): AsignaturaInterfaz[] {
    /* this.asignaturasFiltradas = this.asignaturasFiltradas.filter((item) => {
      return (
         item.conocimientos.filter((item2) => {
          return item2 == conocimiento;
        }).length > 0
      );
    }); */

    return this.asignturas.filter((item) => {
      return item.conocimientos.find((item2) => {
        return item2 == conocimiento;
      });
    });
  }
}
