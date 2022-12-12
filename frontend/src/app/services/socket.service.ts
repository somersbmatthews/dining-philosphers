import { Injectable } from '@angular/core';
import { QueueingSubject } from 'queueing-subject';

@Injectable({
  providedIn: 'root'
})

export class SocketService {
// this subject queues as necessary to ensure every message is delivered
input$ = new QueueingSubject<string>()


  constructor() { }
}
