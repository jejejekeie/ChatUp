// chat-list.component.ts
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chat-list',
  templateUrl: './chat-list.component.html',
  styleUrls: ['./chat-list.component.css']
})
export class ChatListComponent implements OnInit {
  chat: any[]; // Supongamos que cada chat tiene una propiedad 'name'

  constructor() { }

  ngOnInit(): void {
    // Aquí podrías obtener los chats de un servicio o de algún otro origen de datos
    this.chats = [
      { name: 'Chat 1' },
      { name: 'Chat 2' },
      { name: 'Chat 3' }
    ];
  }

  selectChat(chat: any) {
    // Lógica para seleccionar el chat
    console.log('Chat seleccionado:', chat);
  }
}
