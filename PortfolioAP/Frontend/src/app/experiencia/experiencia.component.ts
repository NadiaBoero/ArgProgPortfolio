import { Component, OnInit } from '@angular/core';
import { ExpLaboral } from '../Model/exp-laboral';
import { ServicioExperienciaService } from '../servicio/servicio-experiencia.service';
import { TokenService } from '../servicio/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  expLab:ExpLaboral[]=[];

  constructor(private servicioExperiencia:ServicioExperienciaService, private tokenService:TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.cargarExpLaboral();
    if(this.tokenService.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;

    }
  }

  cargarExpLaboral():void{
    this.servicioExperiencia.lista().subscribe(data =>{this.expLab = data;})
  }

  borrar(id?:number){
    if(id != undefined){
      this.servicioExperiencia.delete(id).subscribe(
        data =>{
          this.cargarExpLaboral();
        }, err =>{
          alert("No se pudo eliminar Experiencia Laboral");
        }

        
      )
    }
  }

}
