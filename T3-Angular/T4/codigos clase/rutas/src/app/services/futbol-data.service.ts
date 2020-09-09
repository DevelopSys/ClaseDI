import { Injectable } from '@angular/core';
import { Liga } from '../utils/ligas';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root',
})
export class FutbolDataService {
  APIKEY = 'd7d433069b2e42eeb96fa372e18bc5bc';

  // http://api.football-data.org/v2/competitions

  ligas = [
    {
      id: 1,
      nombre: 'La Liga',
      pais: 'España',
      logo:
        'https://3.bp.blogspot.com/-8D_PYiuqhiw/VeSXbIfc_MI/AAAAAAAAAM4/XRzqhoZ6Y2k/s1600/LigaBBVA.png',
    },
    {
      id: 2,
      nombre: 'Premiere League',
      pais: 'Inglaterra',
      logo:
        'https://2.bp.blogspot.com/-4tg1eX1A_pY/WVOHis9gtWI/AAAAAAABKB8/gFWgwyWBjjUiP9IaqHibaD1iRh10B4sXQCLcBGAs/s1600/Premier%2BLeague.png',
    },
    {
      id: 3,
      nombre: 'Serie A',
      pais: 'Italia',
      logo:
        'https://3.bp.blogspot.com/-1wJdeqXqXGU/WPFobp4_h3I/AAAAAAAAA2Y/JDAb0rJGboQGfnztRrnhxyBJh4e_D-NogCLcB/s1600/Serie%2BA%2BTIM%2BLogo.png',
    },
    {
      id: 4,
      nombre: 'Bundesliga',
      pais: 'Alemania',
      logo:
        'data:image/png;base64,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',
    },
  ];

  constructor(private conexion: HttpClient) {}

  getLigasAPI() {
    return this.conexion.get(
      'https://www.thesportsdb.com/api/v1/json/1/all_leagues.php'
    );
  }
  getLigasAPIFiltrado() {
    return this.conexion
      .get('https://www.thesportsdb.com/api/v1/json/1/all_leagues.php')
      .pipe(
        map((resultado) => {
          return resultado['leagues'];
        })
      );
  }

  getLiga(id: number): Liga[] {
    let ligasFiltradas = [];

    this.ligas.forEach((element) => {
      if (element.id == id) {
        ligasFiltradas.push(element);
      }
    });

    return ligasFiltradas;
  }

  getLigas(): Liga[] {
    return this.ligas;
  }
}
