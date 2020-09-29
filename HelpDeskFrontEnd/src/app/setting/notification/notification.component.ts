import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss']
})
export class NotificationComponent implements OnInit {
  normal: any;
  strong: any;
  item: any;
  isCompleted: boolean;

  constructor() { }

  ngOnInit(): void {
  }

  onItemChange(item: any) {
    console.log(item.value);
  }

  templateForm(value: any) {
    alert(JSON.stringify(value));
  }

  next() {
    console.log('WYBIERZ !');
  }

  onComplete($event: any) {
    this.isCompleted=true;
  }
}
