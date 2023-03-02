export class User {
    idUser!: number;
    firstname!: string;
    name!: string;
    mail!: string;
    password !: string;
    users_roles !: string;
    roles !:Array<any>;
    token?:string;
  }