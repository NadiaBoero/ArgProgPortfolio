import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcercaDeComponent } from './acerca-de/acerca-de.component';
import { NuevoAcercaDeComponent } from './acerca-de/nuevo-acerca-de/nuevo-acerca-de.component';
import { EditarEducacionComponent } from './educacion/editar-educacion/editar-educacion.component';
import { NuevaEducacionComponent } from './educacion/nueva-educacion/nueva-educacion.component';
import { EditarExplaboralComponent } from './experiencia/editar-explaboral/editar-explaboral.component';
import { NuevaExpLaboralComponent } from './experiencia/nueva-exp-laboral/nueva-exp-laboral.component';
import { EditarHabilidadesComponent } from './habilidades/editar-habilidades/editar-habilidades.component';
import { NuevaHabilidadesComponent } from './habilidades/nueva-habilidades/nueva-habilidades.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexplaboral', component: NuevaExpLaboralComponent}, 
  {path:'editarexplaboral/:id', component: EditarExplaboralComponent},
  {path:'nuevoestudios', component: NuevaEducacionComponent},
  {path:'editarestudios/:id', component: EditarEducacionComponent},
  {path:'nuevoacercade', component: NuevoAcercaDeComponent},
  {path:'nuevahabilidades', component: NuevaHabilidadesComponent},
  {path:'edithabilidades/:id', component: EditarHabilidadesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
