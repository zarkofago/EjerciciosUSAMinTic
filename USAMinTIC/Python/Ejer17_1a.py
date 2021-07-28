paciente = {'Nombre': 'Oscar', 'Apellido': 'Silva',
            'Correo': 'no@reporta.com', 'EPS': 'Sura', 'Estado': 'Inactivo'}
actualiza = {'Estado': 'Activo', 'Correo': 'zarkofago@gmail.com'}
paciente.update(actualiza)
print('Los datos del paciente son:')
for t, d in paciente.items():
    print(f'{t}: {d}')