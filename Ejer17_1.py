usuario = {'nombre': 'Oscar', 'apellido': 'Silva',
          'correo': 'no@reporta.com', 'EPS': 'Sura', 'Estado': 'Inactivo'}
actualiza = {'Estado': 'Activo', 'correo': 'zarkofago@gmail.com'}
usuario.update(actualiza)
for t, d in usuario.items():
    print(f'{t}: {d}')