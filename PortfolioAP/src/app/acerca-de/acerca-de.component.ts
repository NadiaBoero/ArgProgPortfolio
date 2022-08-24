import { Component, OnInit } from '@angular/core';
import { AcercaDe } from '../Model/acerca-de';
import { Persona } from '../Model/persona.model';
import { PersonaService } from '../servicio/persona.service';
import { ServicioAcercaDeService } from '../servicio/servicio-acerca-de.service';
import { TokenService } from '../servicio/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  persona : Persona = new Persona(" ",  " " , " ");
  acercade : AcercaDe[]=[];
  constructor(public personaService:PersonaService, private servicioAcercaDe: ServicioAcercaDeService, private tokenService: TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data=>{
      this.persona = data
    })
    this.cargarAcercaDe();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged=false;
    }
  }

  


  cargarAcercaDe(): void{
    this.servicioAcercaDe.lista().subscribe(
      data =>{
        this.acercade=data;
      }
    )
  }

  borrar(id?:number){
    if(id != undefined){
      this.servicioAcercaDe.delete(id).subscribe(
        data =>{
          this.cargarAcercaDe();
        }, err =>{
          alert("No se pudo eliminar información Acerca De Mi")
        }
      )

    }
  }
}
