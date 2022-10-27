import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/Model/persona.model';
import { ImagenService } from 'src/app/servicio/imagen.service';
import { PersonaService } from 'src/app/servicio/persona.service';

@Component({
  selector: 'app-editar-acerca-de',
  templateUrl: './editar-acerca-de.component.html',
  styleUrls: ['./editar-acerca-de.component.css']
})


export class EditarAcercaDeComponent implements OnInit {
    persona:Persona=null;

  constructor(private activatedRoute:ActivatedRoute, private personaService:PersonaService, private router:Router, public imagenService:ImagenService) { }

  ngOnInit(): void {
    const id=this.activatedRoute.snapshot.params['id'];
    this.personaService.detail(id).subscribe(
      data => {
        this.persona=data;
      }, err=>{
        alert(" Error al editar Persona");
        this.router.navigate(['']);
      }
    )

  }


  EditarPersona():void{
    const id=this.activatedRoute.snapshot.params['id'];
    this.persona.img=this.imagenService.url;
    this.personaService.update(id, this.persona).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err=>{
        alert(" Error al editar Persona");
        this.router.navigate(['']);


      }
    )
  }

  subirImagen($event:any){
    const id = this.activatedRoute.snapshot.params['id'];
    const nombre = 'fotoperfil_' + id;
    this.imagenService.subirImagen($event, nombre)
    
  }

}
