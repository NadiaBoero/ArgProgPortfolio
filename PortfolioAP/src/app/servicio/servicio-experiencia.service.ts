import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExpLaboral } from '../Model/exp-laboral';

@Injectable({
  providedIn: 'root'
})
export class ServicioExperienciaService {
  expURL='http://localhost:8080/explaboral/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<ExpLaboral[]>{
    return this.httpClient.get<ExpLaboral[]>(this.expURL + 'lista');
   
  }

  public detail(id:number): Observable<ExpLaboral>{
    return this.httpClient.get<ExpLaboral>(this.expURL + `detail/${id}`);
  }

  public save(explaboral:ExpLaboral): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', explaboral);

  }

  public update(id: number, explaboral:ExpLaboral): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, explaboral);

  }

  public delete(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);

  }
}
