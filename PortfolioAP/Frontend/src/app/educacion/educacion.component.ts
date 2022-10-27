import { Component, OnInit } from '@angular/core';
import { Estudios } from '../Model/estudios';
import { EstudiosService } from '../servicio/estudios.service';
import { TokenService } from '../servicio/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  estudios:Estudios[]=[];

  constructor(private estudiosService:EstudiosService, private tokenService:TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.cargarEstudios();
   if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged=false;
    }
  }

  cargarEstudios(): void{
    this.estudiosService.lista().subscribe(
      data =>{
        this.estudios=data;
      }
    )
  }

  borrar(id?:number){
    if(id != undefined){
      this.estudiosService.delete(id).subscribe(
        data =>{
          this.cargarEstudios();
        }, err =>{
          alert("No se pudo eliminar Estudios y Certificados")
        }
      )

    }
  }

}
