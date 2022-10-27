import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Estudios } from 'src/app/Model/estudios';
import { EstudiosService } from 'src/app/servicio/estudios.service';

@Component({
  selector: 'app-editar-educacion',
  templateUrl: './editar-educacion.component.html',
  styleUrls: ['./editar-educacion.component.css']
})
export class EditarEducacionComponent implements OnInit {
  estudios:Estudios=null;
  nombreEdu:string;
  descripcionEdu:string;

  constructor(private estudiosService:EstudiosService, private activatedRoute:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    const id=this.activatedRoute.snapshot.params['id'];
    this.estudiosService.detail(id).subscribe(
      data => {
        this.estudios=data;
      }, err=>{
        alert(" Error al editar Estudios");
        this.router.navigate(['']);
      }
    )
  }

  EditarEstudios(): void{
    const id=this.activatedRoute.snapshot.params['id'];
    this.estudiosService.update(id, this.estudios).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err=>{
        alert(" Error al editar Estudios");
        this.router.navigate(['']);


      }
    )
  }

}
