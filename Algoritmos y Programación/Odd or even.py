#Realizar un programa donde se reciba un número flotante por teclado e imprima un mensaje diciendo si el número es par o impar y evaluar si es positivo/negativo.

number = float(input("Indique un número.\n"))

if number < 0 and number %2 == 0:
    print("El número es par y negativo.")
elif number > 0 and number %2 == 0:
    print("El número es par y positivo.")

if number < 0 and number %2 == 1:
    print("El número es impar y negativo.")
elif number > 0 and number %2 == 1:
    print("El número es impar y positivo.")

else:
    print("El número es neutro.")