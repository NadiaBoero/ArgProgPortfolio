import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyectos } from 'src/app/Model/proyectos.model';
import { ImagenService } from 'src/app/servicio/imagen.service';
import { ProyectosService } from 'src/app/servicio/proyectos.service';

@Component({
  selector: 'app-editar-proyectos',
  templateUrl: './editar-proyectos.component.html',
  styleUrls: ['./editar-proyectos.component.css']
})
export class EditarProyectosComponent implements OnInit {
  proyectos:Proyectos=null;

  constructor(private activatedRoute:ActivatedRoute, private proyectosService:ProyectosService, private router:Router, public imagenService: ImagenService) { }

  ngOnInit(): void {
    const id=this.activatedRoute.snapshot.params['id'];
    this.proyectosService.detail(id).subscribe(
      data => {
        this.proyectos=data;
      }, err=>{
        alert(" Error al editar Proyecto");
        this.router.navigate(['']);
      }
    )

  }

  EditarProyectos():void{
    const id=this.activatedRoute.snapshot.params['id'];
    this.proyectos.imgProyecto=this.imagenService.url;
    this.proyectosService.update(id, this.proyectos).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err=>{
        alert(" Error al editar Proyecto");
        this.router.navigate(['']);


      }
    )
  }

  subirImagenProyecto($event:any){
    const id = this.activatedRoute.snapshot.params['id'];
    const nombre = 'fotoproyecto_' + id;
    this.imagenService.subirImagen($event, nombre)
    
  }





}
