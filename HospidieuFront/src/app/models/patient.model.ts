export class Patient {
    ID_patient ?: number;
    name !: string;
    firstname !: string;
    birthDate !: Date;
    address !: string;
    postcode !: number;
    city !: string;
    phone !: number;
    securityNumber !: string;
}