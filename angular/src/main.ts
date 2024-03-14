

const emojiButton = document.getElementById("emoji-button") as HTMLButtonElement;
const messageInput = document.getElementById("message-input") as HTMLInputElement;
const sendButton = document.getElementById("send-button") as HTMLButtonElement;
const chatMessages = document.getElementById("chat-messages") as HTMLElement;



// Función para enviar un mensaje
function sendMessage() {
  const message = messageInput.value.trim();
  if (message !== "") {
    appendMessage("Tú", message);
    simulateResponse();
    messageInput.value = "";
  }
}

// Función para simular la respuesta del bot
function simulateResponse() {
  setTimeout(function() {
    const response = "¡Hola! Soy el bot. ¿En qué puedo ayudarte?";
    appendMessage("Bot", response);
  }, 1000);
}

// Función para agregar un mensaje al chat
function appendMessage(sender: string, message: string) {
  const newMessageContainer = document.createElement("div");
  newMessageContainer.classList.add("message-container");

  const senderElement = document.createElement("span");
  senderElement.classList.add("message-sender");
  senderElement.textContent = sender + ": ";

  const messageElement = document.createElement("span");
  messageElement.classList.add("message-content");
  messageElement.textContent = message;

  newMessageContainer.appendChild(senderElement);
  newMessageContainer.appendChild(messageElement);
  chatMessages.appendChild(newMessageContainer);
  chatMessages.scrollTop = chatMessages.scrollHeight;
}

// Event listener para el botón de enviar mensaje
sendButton.addEventListener("click", sendMessage);
