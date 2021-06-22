n = int(input())
datos = []
for i in range(0, n, 1):
    hdmi, pulgadas, resolucion, frecuencia, valor = input().split()
    hdmi = int(hdmi)
    pulgadas = int(pulgadas)
    resolucion = int(resolucion)
    frecuencia = int(frecuencia)
    valor = int(valor)
    if hdmi >= 3 and pulgadas >= 55 and resolucion >= 1080 and frecuencia >= 60:
        datos.append(valor)
for i in datos:
    print(i)
if len(datos) == 0:
    print("NO DISPONIBLE")
