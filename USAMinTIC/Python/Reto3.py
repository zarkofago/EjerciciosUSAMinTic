n = int(input())
colegios = []
for i in range(0, n, 1):
    fundacion, profesores, recorrido, parques, matricula = input().split()
    fundacion = int(fundacion)
    profesores = int(profesores)
    recorrido = int(recorrido)
    parques = int(parques)
    matricula = int(matricula)
    if fundacion >= 10 and profesores >= 40 and recorrido <= 35 and parques >= 4:
        colegios.append(matricula)
for i in colegios:
    print(i)
if len(colegios) == 0:
    print("NO DISPONIBLE")
