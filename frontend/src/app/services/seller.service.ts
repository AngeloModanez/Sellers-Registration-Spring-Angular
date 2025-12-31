import { Injectable } from '@angular/core';
import { Seller } from '../interfaces/seller';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SellerService {
  private readonly API = 'http://localhost:8080/sellers';

  constructor(private http: HttpClient) { }

  getSellers(): Observable<Seller[]> {
    return this.http.get<Seller[]>(this.API);
  }

  saveSeller(seller: Seller): Observable<Seller> {
    return this.http.post<Seller>(this.API, seller);
  }

  deleteSeller(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }

  updateSeller(seller: Seller): Observable<Seller> {
    return this.http.put<Seller>(`${this.API}/${seller.id}`, seller);
  }
}
