import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyectos } from 'src/app/Model/proyectos.model';
import { ImagenService } from 'src/app/servicio/imagen.service';
import { ProyectosService } from 'src/app/servicio/proyectos.service';

@Component({
  selector: 'app-nuevo-proyecto',
  templateUrl: './nuevo-proyecto.component.html',
  styleUrls: ['./nuevo-proyecto.component.css']
})
export class NuevoProyectoComponent implements OnInit {
  nombreProyecto:string;
  descripcionProyecto:string;
  urlProyecto:string;
  imgProyecto:string;

  constructor(private proyectosService:ProyectosService, private router:Router, private activatedRoute:ActivatedRoute, public imagenService:ImagenService) { }

  ngOnInit(): void {
  }

  CrearProyecto(): void{
    const proyectos = new Proyectos(this.nombreProyecto, this.descripcionProyecto, this.urlProyecto, this.imgProyecto );
    this.proyectosService.save(proyectos).subscribe(
      data =>{
        alert("Proyecto añadido correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("Error al cargar Proyecto");
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
