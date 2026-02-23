import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-tareas',
  imports: [CommonModule],
  templateUrl: './tareas.html',
  styleUrl: './tareas.css',
})
export class Tareas implements OnInit {
  recupero = true;
  datoRecuperado?: string;

  constructor(private gestorRutasActivas: ActivatedRoute) {}

  ngOnInit(): void {
    this.recupero = true;
    // this.datoRecuperado = this.gestorRutasActivas.snapshot.params['id'];
    this.gestorRutasActivas.paramMap.subscribe((items) => {
      this.datoRecuperado = items.get('id') ?? undefined;
    });
  }
}
