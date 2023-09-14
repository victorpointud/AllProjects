
import math 

numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print("El total de números en la lista es", len(numbers))

suma = 0
contador = 0

while suma <= len(str(numbers)):
    for numbers in range(10):
        if numbers %2 != 0:
            print("El número impar es:", numbers)
            contador += 1
            suma += numbers

print("La cantidad de números impares es:", contador)
print("La suma total de los numeros impares de la lista es:", suma)


"""for number in numbers:
    if number %2 != 0:
        print("El número impar es:", number)
        contador += 1
        suma = suma + number

print("La cantidad de números impares es:", contador)
print("La suma total de los numeros impares de la lista es:", suma)"""