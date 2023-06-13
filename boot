import network
from machine import Pin

# Configuración de la red Wi-Fi
SSID = 'Mjmm'
PASSWORD = '123456789'

# Conectar a la red Wi-Fi
def connect_to_wifi():
    sta_if = network.WLAN(network.STA_IF)
    if not sta_if.isconnected():
        print('Conectando a la red Wi-Fi...')
        sta_if.active(True)
        sta_if.connect(SSID, PASSWORD)
        while not sta_if.isconnected():
            pass
    print('Conexión establecida')
    print('Dirección IP:', sta_if.ifconfig()[0])
    led = Pin(2, Pin.OUT)
    led.on()

# Conexión a la red Wi-Fi al iniciar el dispositivo
connect_to_wifi()
