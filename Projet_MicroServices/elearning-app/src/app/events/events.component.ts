import { Component, OnInit } from '@angular/core';
import { RestApiService } from 'app/shared/rest-api.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events: any = [];

  constructor(public restApi: RestApiService) { }

  loadEvent() {
    this.restApi.get("/events").subscribe((data: {}) => {
      this.events = data;
    });
  }

  deleteEvent(eventId: number) {
    if (eventId) {
      this.restApi.delete("/events", eventId).subscribe(() => {
        this.loadEvent(); // Reload the events after a successful delete
      });
    } else {
      console.error("Invalid event ID");
    }
  }
  

  ngOnInit(): void {
    this.loadEvent();
  }
}
