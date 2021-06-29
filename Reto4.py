def Revisar_copia():
    examenes_calificar, examenes_recordar = input().split()
    notas = [int(notas_ingresar) for notas_ingresar in list(input().split())]
    return (int(examenes_calificar), int(examenes_recordar), notas)


def Numero_copias(examenes_recordar, notas):
    copias_totales = 0
    copias_detectadas = 0
    if notas.count(notas[0]) == len(notas):
        copias_totales = len(notas)-1
    else:
        revisados = []
        for nota in notas:
            if (nota not in revisados):
                revisados.append(nota)
                contador = 0
                contador = notas.count(nota)
                if (contador > 1):
                    contador = contador-1
                    copias_totales += contador
    return (copias_totales)


def copias_encontradas(examenes_recordar, notas):
    copias_detectadas = 0
    if notas.count(notas[0]) == len(notas):
        copias_detectadas = len(notas)-1
    else:
        contador = 0
        posicion = examenes_recordar
        for nota in range(examenes_recordar, len(notas)):
            total_notas = notas[contador:posicion]
            if (notas[nota] in total_notas):
                copias_detectadas += 1
            contador += 1
            posicion += 1

    return (copias_detectadas)


N, k, notas = Revisar_copia()
print(Numero_copias(k, notas), copias_encontradas(k, notas))
