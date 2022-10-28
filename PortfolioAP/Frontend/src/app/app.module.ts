import { NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ExperienciaComponent } from './experiencia/experiencia.component';
import { EducacionComponent } from './educacion/educacion.component';
import { HabilidadesComponent } from './habilidades/habilidades.component';
import { ProyectosComponent } from './proyectos/proyectos.component';
import { LogoargprogComponent } from './logos/logoargprog/logoargprog.component';
import { RedessocialesComponent } from './redessociales/redessociales.component';
import { BannerComponent } from './banner/banner.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { interceptorProvider } from './servicio/interceptor-servicio';
import { NuevaExpLaboralComponent } from './experiencia/nueva-exp-laboral/nueva-exp-laboral.component';
import { EditarExplaboralComponent } from './experiencia/editar-explaboral/editar-explaboral.component';
import { NuevaEducacionComponent } from './educacion/nueva-educacion/nueva-educacion.component';
import { EditarEducacionComponent } from './educacion/editar-educacion/editar-educacion.component';
import { EditarHabilidadesComponent } from './habilidades/editar-habilidades/editar-habilidades.component';
import { NuevaHabilidadesComponent } from './habilidades/nueva-habilidades/nueva-habilidades.component';
import { FooterComponent } from './footer/footer.component';
import { AcercaDeComponent } from './acerca-de/acerca-de.component';
import { EditarAcercaDeComponent } from './acerca-de/editar-acerca-de/editar-acerca-de.component';
import { initializeApp,provideFirebaseApp } from '@angular/fire/app';
import { environment } from '../environments/environment';
import { provideStorage,getStorage } from '@angular/fire/storage';
import { EditarProyectosComponent } from './proyectos/editar-proyectos/editar-proyectos.component';
import { NuevoProyectoComponent } from './proyectos/nuevo-proyecto/nuevo-proyecto.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ExperienciaComponent,
    EducacionComponent,
    HabilidadesComponent,
    ProyectosComponent,
    LogoargprogComponent,
    RedessocialesComponent,
    BannerComponent,
    HomeComponent,
    LoginComponent,
    NuevaExpLaboralComponent,
    EditarExplaboralComponent,
    NuevaEducacionComponent,
    EditarEducacionComponent,
    EditarHabilidadesComponent,
    NuevaHabilidadesComponent,
    FooterComponent,
    AcercaDeComponent,
    EditarAcercaDeComponent,
    EditarProyectosComponent,
    NuevoProyectoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideStorage(() => getStorage())
  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]

})
export class AppModule { }
