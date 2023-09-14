tope = input("Ingrese el tope de la sucesión:\n")

while not tope.isnumeric() or int(tope) == 0:
    tope = input("Número inválido. Intente de nuevo:\n")

x = 0
y = 1
z = 1
sucesion = [str(x), str(y)]

while z <= int(tope):
    sucesion.append(str(z))
    x = y
    y = z 
    z = x + y
    print("final")
    print(x, y, z)
    print(sucesion)
    print()

print(",".join(sucesion))