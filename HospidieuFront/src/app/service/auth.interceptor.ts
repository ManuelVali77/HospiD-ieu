import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {       
        let modifiedReq = req
        if (sessionStorage.getItem('mail') && sessionStorage.getItem('token')) {
            //console.log('With Token --- ' + sessionStorage.getItem('token'));
            const token = sessionStorage.getItem('token');
            modifiedReq = req.clone({
                setHeaders: {
                    Authorization: '${token}'
                  }
            });
        }
        return next.handle(modifiedReq);
    }
}