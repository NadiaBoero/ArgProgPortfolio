import { Component, OnInit } from '@angular/core';
import { Persona } from '../Model/persona.model';
import { PersonaService } from '../servicio/persona.service';
import { TokenService } from '../servicio/token.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
persona:Persona = null;


  constructor(public personaService:PersonaService, private tokenService:TokenService) { }

  isLogged=false;

  ngOnInit(): void {
   this.cargarPersona();
   if(this.tokenService.getToken()){
    this.isLogged = true;
  }else{
    this.isLogged=false;
  }
  }


  cargarPersona(){
    this.personaService.detail(1).subscribe(data =>
      {this.persona=data})
  }
}
