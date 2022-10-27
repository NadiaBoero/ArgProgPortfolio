import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExpLaboral } from 'src/app/Model/exp-laboral';
import { ServicioExperienciaService } from 'src/app/servicio/servicio-experiencia.service';

@Component({
  selector: 'app-nueva-exp-laboral',
  templateUrl: './nueva-exp-laboral.component.html',
  styleUrls: ['./nueva-exp-laboral.component.css']
})
export class NuevaExpLaboralComponent implements OnInit {
  nombreExp: string = '';
  descripcionExp: string = '';
  constructor(private servicioExperiencia: ServicioExperienciaService, private router: Router) { }

  ngOnInit(): void {
  }

  CargarExpLab(): void {
    const explaboral = new ExpLaboral(this.nombreExp, this.descripcionExp);
    this.servicioExperiencia.save(explaboral).subscribe(data => {
      alert("Experiencia Laboral cargada correctamente");
      this.router.navigate(['']);
    }, err => {
      alert("Error en la carga de Experiencia Laboral");
      this.router.navigate(['']);
    })
  }

}
