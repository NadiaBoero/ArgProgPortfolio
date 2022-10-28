import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarAcercaDeComponent } from './acerca-de/editar-acerca-de/editar-acerca-de.component';
import { EditarEducacionComponent } from './educacion/editar-educacion/editar-educacion.component';
import { NuevaEducacionComponent } from './educacion/nueva-educacion/nueva-educacion.component';
import { EditarExplaboralComponent } from './experiencia/editar-explaboral/editar-explaboral.component';
import { NuevaExpLaboralComponent } from './experiencia/nueva-exp-laboral/nueva-exp-laboral.component';
import { EditarHabilidadesComponent } from './habilidades/editar-habilidades/editar-habilidades.component';
import { NuevaHabilidadesComponent } from './habilidades/nueva-habilidades/nueva-habilidades.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { EditarProyectosComponent } from './proyectos/editar-proyectos/editar-proyectos.component';
import { NuevoProyectoComponent } from './proyectos/nuevo-proyecto/nuevo-proyecto.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexplaboral', component: NuevaExpLaboralComponent}, 
  {path:'editarexplaboral/:id', component: EditarExplaboralComponent},
  {path:'nuevoestudios', component: NuevaEducacionComponent},
  {path:'editarestudios/:id', component: EditarEducacionComponent},
  {path:'nuevahabilidades', component: NuevaHabilidadesComponent},
  {path:'edithabilidades/:id', component: EditarHabilidadesComponent},
  {path:'editacercade/:id', component: EditarAcercaDeComponent},
  {path:'editaproyectos/:id', component: EditarProyectosComponent},
  {path:'nuevoproyecto', component: NuevoProyectoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
