import socket

# Definimos el host y el puerto del servidor TCP
SERVER_HOST = '192.168.219.205'
SERVER_PORT = 8888

# Creamos un socket TCP/IP
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Nos conectamos al servidor TCP
client_socket.connect((SERVER_HOST, SERVER_PORT))

# Enviamos un mensaje al servidor
message = "Hola desde el cliente TCP en Python"
client_socket.sendall(message.encode())

# Recibimos la respuesta del servidor
response = client_socket.recv(1024)
print('Respuesta del servidor:', response.decode())

# Cerramos la conexión
client_socket.close()