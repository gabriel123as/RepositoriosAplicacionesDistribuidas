import socket

# Definimos el host y el puerto del servidor UDP
SERVER_HOST = '192.168.219.205'
SERVER_PORT = 8888

# Creamos un socket UDP/IP
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Enviamos un mensaje al servidor
message = "Hola desde el cliente UDP en Python"
client_socket.sendto(message.encode(), (SERVER_HOST, SERVER_PORT))

# Recibimos la respuesta del servidor
response, addr = client_socket.recvfrom(1024)
print('Respuesta del servidor:', response.decode())

# Cerramos el socket
client_socket.close()