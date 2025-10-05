# 📢 Broadcast Channel
This project is a *Broadcast Channel application* that allows sending and receiving messages between multiple clients.  
It was built to demonstrate concepts of *multithreading, **client-server communication, and **synchronization* in Java.
In this Boadcast channel clientsconnecter connects by making the oject of client class passing portnumber and IP Address as a parameters
## 🚀 Features
- Multiple clients can connect to the server.
- Server Displays Messages from clientsconnecters on it's console 
- Proper handling of client connections and disconnections.
- Uses Java threads for concurrent client communication.
## Technologies Used
- *Java* (Sockets, Multithreading)
- *OOP Concepts*
- *Client-Server Architecture*
## 📂 Project Structure
- Server.java → Starts the server and listens for clients.
- Client.java → Connects to the server and sends/receives messages.
- ClientHandler.java → Handles each connected client using threads.
