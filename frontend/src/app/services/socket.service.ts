import { Injectable } from '@angular/core';
import { webSocket } from 'rxjs/webSocket';

Injectable({
  providedIn: 'root'
})
const subject = webSocket('ws://localhost:8081');

subject.subscribe({
  next: msg => console.log('message received: ' + msg), // Called whenever there is a message from the server.
  error: err => console.log(err), // Called if at any point WebSocket API signals some kind of error.
  complete: () => console.log('complete') // Called when connection is closed (for whatever reason).
 });
 
subject.subscribe();
// Note that at least one consumer has to subscribe to the created subject - otherwise "nexted" values will be just buffered and not sent,
// since no connection was established!
 
subject.next({ message: 'some message' });
// This will send a message to the server once a connection is made. Remember value is serialized with JSON.stringify by default!
 
subject.complete(); // Closes the connection.
 
subject.error({ code: 4000, reason: 'I think our app just broke!' });
// Also closes the connection, but let's the server know that this closing is caused by some error.

// const observableA = subject.multiplex(
//   () => ({ subscribe: 'A' }), // When server gets this message, it will start sending messages for 'A'...
//   () => ({ unsubscribe: 'A' }), // ...and when gets this one, it will stop.
//   message => message.type === 'A' // If the function returns `true` message is passed down the stream. Skipped if the function returns false.
// );
 
// const observableB = subject.multiplex( // And the same goes for 'B'.
//   () => ({ subscribe: 'B' }),
//   () => ({ unsubscribe: 'B' }),
//   message => message.type === 'B'
// );
 
// const subA = observableA.subscribe(messageForA => console.log(messageForA));
// // At this moment WebSocket connection is established. Server gets '{"subscribe": "A"}' message and starts sending messages for 'A',
// // which we log here.
 
// const subB = observableB.subscribe(messageForB => console.log(messageForB));
// // Since we already have a connection, we just send '{"subscribe": "B"}' message to the server. It starts sending messages for 'B',
// // which we log here.
 
// subB.unsubscribe();
// // Message '{"unsubscribe": "B"}' is sent to the server, which stops sending 'B' messages.
 
// subA.unsubscribe();
// // Message '{"unsubscribe": "A"}' makes the server stop sending messages for 'A'. Since there is no more subscribers to root Subject,
// // socket connection closes.
export class SocketService {
  constructor() { }
}
