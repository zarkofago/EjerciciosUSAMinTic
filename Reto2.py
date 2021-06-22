registro = input()
registro = registro.split()
distancia_mts = float(registro[0])
velocidad_max = float(registro[1])
tiempo_seg = float(registro[2])
distancia_km = distancia_mts/1000
tiempo_hrs = tiempo_seg/3600
velocidad_final = distancia_km/tiempo_hrs
porcentaje = (velocidad_max*0.20)+velocidad_max
if velocidad_max < 0:
    print("MEDICION ERRONEA")
elif velocidad_final <= velocidad_max:
    print("OK")
elif velocidad_final < porcentaje and velocidad_final > velocidad_max:
    print("MULTA")
elif velocidad_final >= porcentaje:
    print("CURSO SENSIBILIZACION")
