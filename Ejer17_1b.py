print('ingrese nombre del paciente')
nombre = input()
print('ingrese apellido del paciente')
apellido = input()
print('ingrese email del paciente')
correo = input()
print("ingrese EPS del paciente")
eps = input()
print("ingrese estado de afiliacion del paciente")
estado = input()
paciente = {'Nombre': nombre, 'Apellido': apellido,
            'Correo': correo, 'EPS': eps, 'Estado': estado}
print('Debe actualizar el correo y el estado de afiliacion del paciente')
print('ingrese correo actualizado')
correoa = input()
print('ingrese estado actualizado')
estadoa = input()
actualiza = {'Estado': estadoa, 'Correo': correoa}
paciente.update(actualiza)
print('Los datos del paciente son:')
for t, d in paciente.items():
    print(f'{t}: {d}')