import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AcercaDe } from 'src/app/Model/acerca-de';
import { ServicioAcercaDeService } from 'src/app/servicio/servicio-acerca-de.service';

@Component({
  selector: 'app-edit-acerca-de',
  templateUrl: './edit-acerca-de.component.html',
  styleUrls: ['./edit-acerca-de.component.css']
})
export class EditAcercaDeComponent implements OnInit {
  acercade:AcercaDe=null;
  nombreAcerca:string;
  descripcionAcerca:string;

  constructor(private servicioAcercaDe:ServicioAcercaDeService, private activatedRoute:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    const id=this.activatedRoute.snapshot.params['id'];
    this.servicioAcercaDe.detail(id).subscribe(
      data => {
        this.acercade=data;
      }, err=>{
        alert(" Error al editar información Acerca De Mi");
        this.router.navigate(['']);
      }
    )
  }

  EditarAcercaDe(): void{
    const id=this.activatedRoute.snapshot.params['id'];
    this.servicioAcercaDe.update(id, this.acercade).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err=>{
        alert(" Error al editar información Acerca De Mi");
        this.router.navigate(['']);


      }
    )
  }

}
