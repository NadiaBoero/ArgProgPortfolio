import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Habilidades } from '../Model/habilidades';

@Injectable({
  providedIn: 'root'
})
export class HabilidadesServiceService {

  URL= environment.URL + 'habilidades/';

  constructor(private httpClient:HttpClient) { }

  public lista(): Observable<Habilidades[]>{
    return this.httpClient.get<Habilidades[]>(this.URL + 'lista');
   
  }

  public detail(id:number): Observable<Habilidades>{
    return this.httpClient.get<Habilidades>(this.URL + `detail/${id}`);
  }

  public save(habilidades:Habilidades): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', habilidades);

  }

  public update(id: number, habilidades:Habilidades): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, habilidades);

  }

  public delete(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);

  }



}
