import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-settings-panel',
  templateUrl: './settings-panel.component.html',
  styleUrls: ['./settings-panel.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class SettingsPanelComponent implements OnInit {

  public isDefaultLayout: boolean;
  public isBoxedLayout: boolean;
  public isSidebarIconOnly: boolean;
  public isCompactMenu: boolean;
  public isFixedSidebar: boolean;
  public isHiddenSidebar: boolean;
  public isOverlaySidebar: boolean;

  constructor() { }

  ngOnInit() {
    let body = document.querySelector('body');
    switch(true) {
      case body.classList.contains('boxed-layout'):
        this.isBoxedLayout = true;
        break;
      case body.classList.contains('sidebar-icon-only'):
        this.isSidebarIconOnly = true;
        break;
      case body.classList.contains('sidebar-mini'):
        this.isCompactMenu = true;
        break;
      case body.classList.contains('sidebar-fixed'):
        this.isFixedSidebar = true;
        break;
      case body.classList.contains('sidebar-toggle-display'):
        this.isHiddenSidebar = true;
        break;
      case body.classList.contains('sidebar-absolute'):
        this.isOverlaySidebar = true;
        break;
      default:
        this.isDefaultLayout = true;  
    }
  }

  toggleThemeSettings() {
    document.querySelector('#theme-settings').classList.toggle('open');
  }

  closeSettingsSidebar(el) {    
    if (el === 'theme') {
      document.querySelector('#theme-settings').classList.remove('open');
    } else {
      document.querySelector('#right-sidebar').classList.remove('open');
    } 
  }

  changeLayout(value) {
    let layoutClasses = ['boxed-layout', 'sidebar-icon-only', 'sidebar-mini', 'sidebar-fixed', 'sidebar-toggle-display', 'sidebar-hidden', 'sidebar-absolute'];
    let body = document.querySelector('body');
    let themeSettings = document.querySelector('#theme-settings');
    switch(value) {
      case 'boxed':
        body.classList.remove(...layoutClasses);
        body.classList.add('boxed-layout');
        themeSettings.classList.remove('open');
        break;
      case 'icon-menu':
        body.classList.remove(...layoutClasses);
        body.classList.add('sidebar-icon-only');
        themeSettings.classList.remove('open');
        break;
      case 'compact-menu':
        body.classList.remove(...layoutClasses);
        body.classList.add('sidebar-mini');
        themeSettings.classList.remove('open');
        break;
      case 'fixed-sidebar':
        body.classList.remove(...layoutClasses);
        body.classList.add('sidebar-fixed');
        themeSettings.classList.remove('open');
        break;
      case 'hidden-sidebar':
        body.classList.remove(...layoutClasses);
        body.classList.add('sidebar-toggle-display', 'sidebar-hidden');
        themeSettings.classList.remove('open');
        break;
      case 'overlay-sidebar':
        body.classList.remove(...layoutClasses);
        body.classList.add('sidebar-absolute', 'sidebar-hidden');
        themeSettings.classList.remove('open');
        break;
      default:
        body.classList.remove(...layoutClasses);
        themeSettings.classList.remove('open');
    }
  }

}
