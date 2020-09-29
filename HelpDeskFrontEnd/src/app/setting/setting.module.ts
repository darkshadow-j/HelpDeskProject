import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationComponent } from './notification/notification.component';
import { RouterModule, Routes } from '@angular/router';
import { CategoriesComponent } from './categories/categories.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {FormWizardModule} from 'angular2-wizard/dist';

const routes: Routes = [
  { path: 'notification', component: NotificationComponent },
  { path: 'categories', component: CategoriesComponent },
]

@NgModule({
  declarations: [NotificationComponent, CategoriesComponent],
  imports: [
    CommonModule,
    NgbModule,
    FormWizardModule,
    RouterModule.forChild(routes),
    FormsModule,
  ]
})
export class SettingModule { }
