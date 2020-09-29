import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';



import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartsModule } from 'ng2-charts';

import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { SettingsPanelComponent } from './shared/settings-panel/settings-panel.component';
import { FooterComponent } from './shared/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { SpinnerComponent } from './shared/spinner/spinner.component';
import { ContentAnimateDirective } from './shared/directives/content-animate.directive';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { NewticketComponent } from './newticket/newticket.component';
import {NgxSummernoteModule} from 'ngx-summernote';
// AoT requires an exported function for factories
import { CommonModule } from '@angular/common';
import { EditorModule } from '@tinymce/tinymce-angular';
import { CodemirrorModule } from 'ng2-codemirror';

import { DropzoneModule } from 'ngx-dropzone-wrapper';
import { DROPZONE_CONFIG } from 'ngx-dropzone-wrapper';
import { DropzoneConfigInterface } from 'ngx-dropzone-wrapper';

import { QuillModule } from 'ngx-quill';
import { TicketDetailsComponent } from './ticket-details/ticket-details.component';

import { NgSelectModule } from '@ng-select/ng-select';
import { AllticketsComponent } from './alltickets/alltickets.component';
import { DataTablesModule } from 'angular-datatables';
import { ModalComponent } from './ticket-details/modal/modal.component';
import { NgxDropzoneModule } from 'ngx-dropzone';
import { TestComponent } from './test/test.component';
import { MyticketsComponent } from './mytickets/mytickets.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
import {FormWizardModule} from 'angular2-wizard/index';

const DEFAULT_DROPZONE_CONFIG: DropzoneConfigInterface = {
  // Change this to your upload POST address:
  url: 'https://httpbin.org/post',
  maxFilesize: 50,
  acceptedFiles: 'image/*'
};

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/');
}

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    ModalComponent,
    SettingsPanelComponent,
    FooterComponent,
    DashboardComponent,
    SpinnerComponent,
    ContentAnimateDirective,
    LoginpageComponent,
    NewticketComponent,
    TicketDetailsComponent,
    AllticketsComponent,
    TestComponent,
    MyticketsComponent,
  ],
  imports: [
    EditorModule,
    DropzoneModule,
    CodemirrorModule,
    NgxDropzoneModule,
    CommonModule,
    NgSelectModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    DataTablesModule,
    SweetAlert2Module.forRoot(),
    ToastrModule.forRoot(),
    ChartsModule,
    CarouselModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
    QuillModule.forRoot(),
    NgxSummernoteModule
  ],
  providers: [
    {
      provide: DROPZONE_CONFIG,
      useValue: DEFAULT_DROPZONE_CONFIG
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
