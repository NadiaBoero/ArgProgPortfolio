import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Habilidades } from 'src/app/Model/habilidades';
import { HabilidadesServiceService } from 'src/app/servicio/habilidades-service.service';

@Component({
  selector: 'app-editar-habilidades',
  templateUrl: './editar-habilidades.component.html',
  styleUrls: ['./editar-habilidades.component.css']
})
export class EditarHabilidadesComponent implements OnInit {
  habilidades: Habilidades = null;

  constructor(private habilidadesService:HabilidadesServiceService, private activatedRoute:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.habilidadesService.detail(id).subscribe(
      data => {
        this.habilidades = data;
      }, err =>{
         alert("Error al editar Habilidades");
         this.router.navigate(['']);
      }

    )

  }

  EditarHabilidades(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.habilidadesService.update(id, this.habilidades).subscribe(
      data => {
        this.router.navigate(['']);
      }, err =>{
         alert("Error al editar Habilidades");
         this.router.navigate(['']);
      }
    )
  }

}
