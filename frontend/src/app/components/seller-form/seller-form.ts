import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Seller } from '../../interfaces/seller';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-seller-form',
  standalone: false,
  templateUrl: './seller-form.html',
  styleUrl: './seller-form.css',
})
export class SellerForm {
  @Input() seller: Seller = {} as Seller;
  @Output() saveEmitter = new EventEmitter();

  sellerFormGroup: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {
    this.sellerFormGroup = this.formBuilder.group({
      id: { value: null, disable: true },
      name: ['', [Validators.required, Validators.minLength(2)]],
      salary: [null, [Validators.required, Validators.min(0.01)]],
      bonus: [null, [Validators.required, Validators.min(0), Validators.max(100)]],
      gender: [0]
    });
  }

  ngOnInit(): void { }

  ngOnChanges(): void {
    if (this.seller.id) {
      this.sellerFormGroup.setValue(this.seller);
    }
  }

  save(): void {
    this.submitted = true;

    if (this.sellerFormGroup.valid) {
      Object.assign(this.seller, this.sellerFormGroup.value);
      this.saveEmitter.emit(true);
      this.submitted = false;
      return;
    }
  }

  cancel(): void {
    this.saveEmitter.emit(false);
  }

  get name() { return this.sellerFormGroup.get("name"); }
  get salary() { return this.sellerFormGroup.get("salary"); }
  get bonus() { return this.sellerFormGroup.get("bonus"); }
  get gender() { return this.sellerFormGroup.get("gender"); }
}
