import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import {authInterceptorProviders} from './_helpers/auth.interceptor';
import { SpinnerComponent } from './shared/spinner/spinner.component';
import {LoginpageComponent} from './loginpage/loginpage.component';
import {AuthGuardServiceService} from './_services/auth-guard.service';
import {NewticketComponent} from './newticket/newticket.component';
import {TicketDetailsComponent} from './ticket-details/ticket-details.component';
import {AllticketsComponent} from './alltickets/alltickets.component';
import {TestComponent} from './test/test.component';
import {MyticketsComponent} from './mytickets/mytickets.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuardServiceService] },
  { path: 'userlogin', component: LoginpageComponent},
  { path: 'newticket', component: NewticketComponent},
  { path: 'alltickets', component: AllticketsComponent},
  { path: 'details', component: TicketDetailsComponent},
  { path: 'mytickets', component: MyticketsComponent},
  { path: 'test', component: TestComponent},
  { path: 'stats', loadChildren: () => import('./setting/setting.module').then(m => m.SettingModule)},
  { path: 'error-pages', loadChildren: () => import('./error-pages/error-pages.module').then(m => m.ErrorPagesModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  providers: [authInterceptorProviders],
  exports: [RouterModule]
})
export class AppRoutingModule { }
