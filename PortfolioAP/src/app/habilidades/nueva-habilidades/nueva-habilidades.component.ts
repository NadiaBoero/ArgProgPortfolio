import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Habilidades } from 'src/app/Model/habilidades';
import { HabilidadesServiceService } from 'src/app/servicio/habilidades-service.service';

@Component({
  selector: 'app-nueva-habilidades',
  templateUrl: './nueva-habilidades.component.html',
  styleUrls: ['./nueva-habilidades.component.css']
})
export class NuevaHabilidadesComponent implements OnInit {
  nombre:string;
  porcentaje: number;

  constructor(private habilidadesService:HabilidadesServiceService, private router:Router) { }

  ngOnInit(): void {

  }

  CargarHabilidad(): void {
    const habilidades = new Habilidades(this.nombre, this.porcentaje);
    this.habilidadesService.save(habilidades).subscribe(data => {
      alert("Habilidad cargada correctamente");
      this.router.navigate(['']);
    }, err => {
      alert("Error en la carga de Habilidad");
      this.router.navigate(['']);
    })
  }

}
