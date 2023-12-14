from socket import *
# '127.0.0.1' is the loopback IP address, which always refers to the current machine.
serverName = '127.0.0.1' # Local host
serverPort = 12000
# AF_INET tells the socket to use IPv4.
# SOCK_DGRAM tells the socket to use the UDP protocol (as opposed to SOCK_STREAM for TCP).
clientSocket = socket(AF_INET, SOCK_DGRAM)
message = input('Input lowercase sentence:')
clientSocket.sendto(message.encode(),(serverName, serverPort))
modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
print(modifiedMessage.decode())
clientSocket.close()
