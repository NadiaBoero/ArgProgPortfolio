import { Component, OnInit } from '@angular/core';
import { Proyectos } from '../Model/proyectos.model';
import { ImagenService } from '../servicio/imagen.service';
import { ProyectosService } from '../servicio/proyectos.service';
import { TokenService } from '../servicio/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  proyectos:Proyectos[]=[];

  constructor(private proyectosService:ProyectosService, private tokenService:TokenService, public imagenService:ImagenService) { }
  isLogged=false;
  ngOnInit(): void {
    this.cargarProyecto();
    if(this.tokenService.getToken()){
       this.isLogged = true;
     }else{
       this.isLogged=false;
     }
  }

  cargarProyecto(): void{
    this.proyectosService.lista().subscribe(
      data =>{
        this.proyectos=data;
      }
    )
  }

  borrar(id?:number){
    if(id != undefined){
      this.proyectosService.delete(id).subscribe(
        data =>{
          this.cargarProyecto();
        }, err =>{
          alert("No se pudo eliminar Proyecto")
        }
      )

    }
  }

}
