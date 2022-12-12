import { Injectable, OnInit } from '@angular/core';
import { webSocket } from 'rxjs/webSocket';

@Injectable({
  providedIn: 'root'
})
export class SocketService implements OnInit {
  subject = webSocket('ws://localhost:8081');
  constructor() { }
  ngOnInit(): void {


    this.subject.subscribe(message => {
      console.log(message);
    });
    // Note that at least one consumer has to subscribe to the created subject - otherwise "nexted" values will be just buffered and not sent,
    // since no connection was established!

    this.subject.next({ message: 'some message' });
    // This will send a message to the server once a connection is made. Remember value is serialized with JSON.stringify by default!

    this.subject.complete(); // Closes the connection.

    this.subject.error({ code: 4000, reason: 'I think our app just broke!' });
    // Also closes the connection, but let's the server know that this closing is caused by some error.
  }



}
