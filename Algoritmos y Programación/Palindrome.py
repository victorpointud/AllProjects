numero_palabra = input("Ingrese un número o palabra:")

numero_palabra[:: -1]

if numero_palabra == numero_palabra[:: -1]:
    print("Es palíndromo")
else:
    print("No es palíndromo")
