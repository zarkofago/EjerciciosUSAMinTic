salario, extras, bono = input().split()
salario = float(salario)
extras = int(extras)
bono = int(bono)
hora = salario/171
if extras >= 1:
    extras = (hora+(hora*0.17))*extras
else:
    extras = 0
if bono == 1:
    bono = (salario*0.088)
elif bono == 0:
    bono = 0
else:
    bono = 0
subtotal = salario+bono+extras
salud = (subtotal*0.05)
pension = (subtotal*0.05)
compen = (subtotal*0.01)
total = (subtotal-salud-pension-compen)
print(round(subtotal, 1), round(total, 1))