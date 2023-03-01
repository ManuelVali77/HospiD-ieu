import { Patient } from "./patient.model";

export class Monitoring {
    comment !: string;
    symptom !: string;
    date !: Date;
    idPatient !: number;
    idUser ?: number;
}