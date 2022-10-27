import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudios } from 'src/app/Model/estudios';
import { EstudiosService } from 'src/app/servicio/estudios.service';

@Component({
  selector: 'app-nueva-educacion',
  templateUrl: './nueva-educacion.component.html',
  styleUrls: ['./nueva-educacion.component.css']
})
export class NuevaEducacionComponent implements OnInit {
  nombreEdu:string;
  descripcionEdu:string;

  constructor(private estudiosService:EstudiosService, private router:Router) { }

  ngOnInit(): void {
  }

  CrearEstudios(): void{
    const estudios = new Estudios(this.nombreEdu, this.descripcionEdu);
    this.estudiosService.save(estudios).subscribe(
      data =>{
        alert("Estudios añadidos correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("Error al cargar Estudios");
        this.router.navigate(['']);
      }
    )
  }

}
