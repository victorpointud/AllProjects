
# sourcery skip: remove-str-from-print, remove-unnecessary-cast, use-assigned-variable
print("Hola, ¿cómo estás?, por favor escoje una operación matemática.\n")
selección = input("Suma, Resta, Multiplicación, División, Potencia, Módulo, Comparar mayor que, Comparar menor que, Valor absoluto.\n")

import math 

if selección == "Suma":
    numero_1 = float(input("Favor ingresar el primer numero:"))
    numero_2 = float(input("Favor ingresar el segundo numero:"))
    print("La suma tiene como resultado:", str(numero_1 + numero_2))

elif selección == "Resta":
    numero_1 = float(input("Favor ingresar el primer numero:"))
    numero_2 = float(input("Favor ingresar el segundo numero:"))
    print("La resta tiene como resultado:", str(numero_1 - numero_2))

elif selección == "Multiplicación":
    numero_1 = float(input("Favor ingresar el primer numero:"))
    numero_2 = float(input("Favor ingresar el segundo numero:"))
    print("La multiplicación tiene como resultado:", str(numero_1 * numero_2))

elif selección == "División":
    numero_1 = float(input("Favor ingresar el primer numero:"))
    numero_2 = float(input("Favor ingresar el segundo numero:"))
    print("La división tiene como resultado:", str(numero_1 / numero_2))

elif selección == "Potencia":
    base = float(input("Favor ingresar la base:"))
    exponente = float(input("Favor ingresar el exponente:"))
    print("La potencia tiene como resultado:", str(base ** exponente))

elif selección == "Módulo":
    numero_1 = float(input("Favor ingresar el primer numero:"))
    numero_2 = float(input("Favor ingresar el segundo numero:"))
    print("El módulo tiene como resultado:", str(numero_1 % numero_2))

elif selección == "Comparar mayor que":
    mayor = int (-99999)
    menor = int (99999)

    numero_1 = float(input("Favor ingresar el primer numero:"))
    numero_2 = float(input("Favor ingresar el segundo numero:"))

    if numero_1 > mayor:
        mayor = numero_1
        print("El mayor que, tiene como resultado:", str(numero_1))
    if numero_2 > menor:
        menor = numero_2
        print("El mayor que, tiene como resultado:", str(numero_2))

elif selección == "Comparar menor que":
    mayor = int (-99999)
    menor = int (99999)

    numero_1 = float(input("Favor ingresar el primer numero:"))
    numero_2 = float(input("Favor ingresar el segundo numero:"))

    if numero_1 < menor:
        menor = numero_1
        print("El menor que, tiene como resultado:", str(numero_1))
    if numero_2 < mayor:
        menor = numero_2
        print("El menor que, tiene como resultado:", str(numero_2))

elif selección == "Valor absoluto":
    numero = float(input("Favor ingresar el numero:"))
    print("El valor absoluto tiene como resultado:", end="")
    print(str(math.fabs(numero)))