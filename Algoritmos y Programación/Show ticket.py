
nombre = input("¿Cuál es su nombre?")

edad = int(input("¿Cuál es su edad?"))

if edad <= 4:
    precio_entrada = "gratis"
    print("El cliente:", nombre, "tiene:", edad, "años y su entrada de cine cuesta:", precio_entrada)
elif edad <= 18:
    precio_entrada = "1.50"
    print("El cliente:", nombre, "tiene:", edad, "años y su entrada de cine cuesta: $", precio_entrada)
elif edad >= 60:
    precio_entrada = "1.00"
    print("El cliente:", nombre, "tiene:", edad, "años y su entrada de cine cuesta: $", precio_entrada)
else:
    precio_entrada = "2.00"
    print("El cliente:", nombre, "tiene:", edad, "años y su entrada de cine cuesta: $", precio_entrada)