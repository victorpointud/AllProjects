#    1.   Se propone que se implemente un algoritmo que, dado un número introducido por el usuario*, diga si ese número es primo de Fermat.

#Definiciones:
#Número de Fermat: todo número natural de la forma (2^(2^n)) + 1 para algún n. Si ese número resulta ser primo, se denomina primo de Fermat.

#*debe validarse que el input sea un número natural.

numero = input("Ingrese un número:\n")

while not numero.isnumeric() or int(numero) < 1:
    numero = input("Número inválido. Intente de nuevo:\n")

numero_2 = int(numero) ** 2
numero_3 = int(numero_2) ** 2
numero_4 = int(numero_3) + 1
if numero_4 %2 == 1:
    print("El número es primo de Fermat.")
else:
    print("El número no es primo de Fermat.")


#    2.   ejemplo de def 
 
def console():
    name = input("Cuál es tu consola favorita?\n")
    return name

def game():
    name = input(str("Cuál es tu juego favorito?\n"))
    return name

def main():
    print(console(), "its a legend console, and", game(), "its a good game.") 

main()

