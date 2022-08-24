import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AcercaDe } from 'src/app/Model/acerca-de';
import { ServicioAcercaDeService } from 'src/app/servicio/servicio-acerca-de.service';

@Component({
  selector: 'app-nuevo-acerca-de',
  templateUrl: './nuevo-acerca-de.component.html',
  styleUrls: ['./nuevo-acerca-de.component.css']
})
export class NuevoAcercaDeComponent implements OnInit {
  nombreAcerca: string;
  descripcionAcerca: string;

  constructor(private servicioAcercaDe: ServicioAcercaDeService, private router: Router) { }

  ngOnInit(): void {
  }

  CargarAcercaDe(): void {
    const acercade = new AcercaDe(this.nombreAcerca, this.descripcionAcerca);
    this.servicioAcercaDe.save(acercade).subscribe(data => {
      alert("Información Acerca De cargada correctamente");
      this.router.navigate(['']);
    }, err => {
      alert("Error en la carga de Información Acerca De");
      this.router.navigate(['']);
    })
  }

}
