import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class FileserviceService {

  constructor(private http:HttpClient) { }
  private baseUrl:string='http://localhost:8080';
  create(file:File){
    const _formData = new FormData();
    _formData.append('file', file, file.name);
    // return this.http.post(UrlFileUpload, _formData);

    return this.http.post(this.baseUrl+'/uploadFile/',_formData);

  }
  download(url)
  {

    return this.http.get("http://localhost:8080/downloadFile/16");
  }


}
