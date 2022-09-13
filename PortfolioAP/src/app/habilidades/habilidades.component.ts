import { Component, OnInit } from '@angular/core';
import { Habilidades } from '../Model/habilidades';
import { HabilidadesServiceService } from '../servicio/habilidades-service.service';
import { TokenService } from '../servicio/token.service';

@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {
  habilidades:Habilidades[]=[];

  constructor(private habilidadesService: HabilidadesServiceService, private tokenService:TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.cargarHabilidades();
    if(this.tokenService.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;

    }
  }

  cargarHabilidades():void{
    this.habilidadesService.lista().subscribe(data =>{this.habilidades = data;})
  }

  borrar(id?:number){
    if(id != undefined){
      this.habilidadesService.delete(id).subscribe(
        data =>{
          this.cargarHabilidades();
        }, err =>{
          alert("No se pudo eliminar Habilidad");
        }

        
      )
    }
  }

}
