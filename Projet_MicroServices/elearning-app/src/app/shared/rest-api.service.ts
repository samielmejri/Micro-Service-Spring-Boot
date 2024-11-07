import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, tap, Subject, throwError} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class RestApiService {
    apiURL = 'http://localhost:8081/api'

    private _refreshNeeded = new Subject<void>();

    get refreshNeeded() {
        return this._refreshNeeded.asObservable();
    }

    constructor(private httpClient: HttpClient) {
    }

    get<T = any>(target: string): Observable<T[]> {
        return this.httpClient.get<T[]>(this.apiURL + target);
    }


    getById<T = any>(target: string, id: number): Observable<T> {
        return this.httpClient.get<T>(this.apiURL + target + '/' + id,{headers:{

        }});
    }

    add<T = any>(target: string, requestBody: T): Observable<T> {
        return this.httpClient.post<T>(this.apiURL + target, requestBody).pipe(
            tap(() => {
                this._refreshNeeded.next();
            })
        );
    }


  getAllComments(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.apiURL}/comments/all`);
  }

  getAllPostsByFormId(id : number): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.apiURL}/forum/getPostsForumById/`+ id);
  }

  getAllCommentsByPostId(id : string): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.apiURL}/comments/posts/`+ id);
  }


  getForumById(id : number): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.apiURL}/forum/getForumById/`+ id);
  }

  getPostById(id : string): Observable<any[]> {
    return this.httpClient.get<string[]>(`${this.apiURL}/post/${id}/comments`,{headers :{'Content-Type': 'application/json'}} );
  }



  addPost(requestBody: any) {
    return this.httpClient.post(`${this.apiURL}/posts`,  requestBody).pipe(
      tap(() => {
        this._refreshNeeded.next();
      })
    );
  }

  delete<T = any>(target: string, elementId: number): Observable<any> {
        return this.httpClient.delete<T>(this.apiURL + target + '/' + elementId).pipe(
            tap(() => {
                this._refreshNeeded.next();
            })
        );
    }

    update<T = any>(target: string, elementId: number, requestBody: T): Observable<T> {
        return this.httpClient
            .put<T>(this.apiURL + target + '/' + elementId, requestBody)
            .pipe(
                tap(() => {
                    this._refreshNeeded.next();
                })
            );
    }

    handleError(error: any) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            // Get client-side error
            errorMessage = error.error.message;
        } else {
            // Get server-side error
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        console.log(errorMessage);
        return throwError(() => {
            return errorMessage;
        });
    }
}
