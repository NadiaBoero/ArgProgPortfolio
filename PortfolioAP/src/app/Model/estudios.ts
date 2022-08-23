export class Estudios {
    id?:number;
    nombreEdu:string;
    descripcionEdu:string;

    constructor(nombreEdu:string, descripcionEdu:string){
        this.nombreEdu=nombreEdu;
        this.descripcionEdu=descripcionEdu;
    }
}
