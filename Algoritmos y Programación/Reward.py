
puntos = int(input("¿Cuántos puntos realizó?\n"))

if puntos in range (1, 51):
    print("No hay premios para", puntos, "pts.")
if puntos in range(51, 151):
    nombre_del_premio = ("Bronze")
    print("Felicitaciones, ganaste la medalla de", nombre_del_premio, "por haber tenido", puntos, "pts!")
if puntos in range(151, 181):
    nombre_del_premio = ("Plata")
    print("Felicitaciones, Ganaste la medalla de", nombre_del_premio, "por haber tenido", puntos, "pts!")
if puntos in range(181, 201):
    nombre_del_premio = ("Oro")
    print("Felicitaciones, Ganaste la medalla de", nombre_del_premio, "por haber tenido", puntos, "pts!")