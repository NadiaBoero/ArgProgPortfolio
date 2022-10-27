import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExpLaboral } from 'src/app/Model/exp-laboral';
import { ServicioExperienciaService } from 'src/app/servicio/servicio-experiencia.service';

@Component({
  selector: 'app-editar-explaboral',
  templateUrl: './editar-explaboral.component.html',
  styleUrls: ['./editar-explaboral.component.css']
})
export class EditarExplaboralComponent implements OnInit {
  
  expLaboral: ExpLaboral = null;

  constructor(private servicioExperiencia:ServicioExperienciaService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.servicioExperiencia.detail(id).subscribe(
      data => {
        this.expLaboral = data;
      }, err =>{
         alert("Error al editar Experiencia Laboral");
         this.router.navigate(['']);
      }

    )
  }


  EditarExpLab(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.servicioExperiencia.update(id, this.expLaboral).subscribe(
      data => {
        this.router.navigate(['']);
      }, err =>{
         alert("Error al editar Experiencia Laboral");
         this.router.navigate(['']);
      }
    )
  }
}
