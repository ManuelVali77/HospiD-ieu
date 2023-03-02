export class User {
    idUser!: number;
    firstName!: string;
    name!: string;
    mail!: string;
    password !: string;
    users_roles !: string;
    roles !:Array<any>;
    token?:string;
  }