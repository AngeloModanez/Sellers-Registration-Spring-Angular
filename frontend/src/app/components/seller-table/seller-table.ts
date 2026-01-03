import { Component, signal } from '@angular/core';
import { SellerService } from '../../services/seller.service';
import { Seller } from '../../interfaces/seller';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-seller-table',
  standalone: false,
  templateUrl: './seller-table.html',
  styleUrl: './seller-table.css',
})
export class SellerTable {
  sellers = signal<Seller[]>([]);
  seller = signal<Seller>({} as Seller);
  deletedSeller = {} as Seller;

  showForm = false;
  isEditing = false;

  constructor(private sellerService: SellerService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.loadSellers();
  }

  editSeller(seller: Seller): void {
    this.seller.set(seller);
    this.showForm = true;
    this.isEditing = true;
  }

  createSeller(): void {
    this.showForm = true;
  }

  loadSellers(): void {
    this.sellerService.getSellers().subscribe({
      next: data => this.sellers.set(data)
    });
  }

  saveSeller(save: boolean) {
    if (save) {
      if (this.isEditing) {
        this.sellerService.updateSeller(this.seller()).subscribe();
      } else {
        this.sellerService.saveSeller(this.seller()).subscribe({
          next: data => {
            this.sellers.update(seller => [...seller, data]);
          }
        });
      }
    }

    this.showForm = false;
    this.isEditing = false;
    this.seller.set({} as Seller);
  }

  deleteSeller(modal: any, seller: Seller): void {
    this.deletedSeller = seller;
    this.modalService.open(modal).result.then(
      (confirm) => {
        if (confirm) {
          this.sellerService.deleteSeller(seller.id).subscribe({
            next: () => {
              this.sellers.update(sellers => sellers.filter(s => s.id !== seller.id));
            }
          });
        }
      }
    );
  }
}
