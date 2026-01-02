import { LOCALE_ID, NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import localePt from '@angular/common/locales/pt';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { registerLocaleData } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { provideHttpClient } from '@angular/common/http';
import { Navbar } from './components/navbar/navbar';
import { Header } from './components/header/header';
import { Footer } from './components/footer/footer';
import { SellerTable } from './components/seller-table/seller-table';

registerLocaleData(localePt, 'pt');

@NgModule({
  declarations: [
    App,
    Navbar,
    Header,
    Footer,
    SellerTable
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    {
      provide: LOCALE_ID,
      useValue: 'pt'
    },
    provideHttpClient()
  ],
  bootstrap: [App]
})
export class AppModule { }
