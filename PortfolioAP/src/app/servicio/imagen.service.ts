import { Injectable } from '@angular/core';
import { getDownloadURL, list, ref, Storage, uploadBytes } from '@angular/fire/storage';
import { log } from 'console';

@Injectable({
  providedIn: 'root'
})
export class ImagenService {
  url:string="";

  constructor(private storage:Storage) { }

  public subirImagen($event:any, nombre:string){
    const file = $event.target.files[0]
    console.log(file);
    const imgRef=ref(this.storage, `imagenes/` + nombre)
    uploadBytes(imgRef, file)
    .then(Response=>{
      this.getImagenes()
    })
    .catch(error => console.log(error))
  }

  getImagenes(){
    const ImagenRef = ref(this.storage, 'imagenes')
    list(ImagenRef)
    .then(async Response=>{
      for (let item of Response.items){
        this.url = await getDownloadURL(item);
        console.log("La URL es:  " + this.url)
      }
    })
    .catch(error => console.log(error))
  }
}
