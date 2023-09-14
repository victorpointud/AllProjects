
from API import API
from Stadium import Stadium
class Stadiums():
    """ Class Stadium.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self):
        """ Init.
        Recibe: n/a
        Retorna: Lista. """
        
        self.stadiums = []
        self.get_stadiums()

    def get_stadiums(self):
        """ Obtencion de estadios de la Api.
        Recibe: n/a
        Retorna: Anade info de Api a Class Stadium y anade objetos a la lista. """

        stadiums_json = API.get_stadium()
        for stadium in stadiums_json:
            name = stadium["name"]
            location = stadium["location"]
            id = stadium["id"]
            restaurants = stadium["restaurants"]
            stadium = Stadium(id, name, stadium["capacity"], location, restaurants)
            self.stadiums.append(stadium)

    def show_stadiums(self):
        """ Mostrar estadios.
        Recibe: n/a
        Retorna: info de id con nombre de estadio en lista. """

        for stadium in self.stadiums:
            print(f"        {stadium.id}. {stadium.name}")

    def search_by_id(self, id):
        """ Buscar estadio por id.
        Recibe: Id del estadio
        Retorna: lista de estadio o False. """

        search_stadiums_array = self.stadiums

        if (len(search_stadiums_array) > 1):
            leftIndex = 0
            rightIndex = len(search_stadiums_array)-1
            return self.binary_search(search_stadiums_array, id, leftIndex, rightIndex)
        elif (len(search_stadiums_array) == 1 and search_stadiums_array[0].id == id) :
            return search_stadiums_array[0]
        else:
            return False

    def binary_search(self, remake, search, left, right):
        """ Busqueda binaria para estadios.
        Recibe: lista nueva, busqueda, y analisis de izquiera y derecha.
        Retorna: otra vez la funcion con otros atributos. """

        if left > right:
            return False

        mid_i = (left + right) // 2 
        mid_elem = remake[mid_i]
        if mid_elem.id == search:
            return mid_elem

        if search < mid_elem.id:
            return self.binary_search(remake, search, left, mid_i - 1)
        else:
            return self.binary_search(remake, search, mid_i + 1, right)

    def get_map(self, filas, columnas):
        """ Obtener dimensiones de los mapas.
        Recibe: filas y columnas por input.
        Retorna: Mapa. """

        mapa = []
        for y in range(filas):
            aux = []
            for x in range(columnas):
                aux.append(False)
            mapa.append(aux)
        return mapa
    
    def print_map(self, mapa):
        """ Impresion de los mapas.
        Recibe: Mapa.
        Retorna: Mapa individual por estadio impreso. """

        print()
        print("* "*len(mapa[1]) + "ESTADIO "+"* "* len(mapa[1]))
        print("\n")
        nums = "    "
        for i, x in enumerate(mapa[1]):
            if i > 8:
                nums+=str(i+1)+"| "
            else:
                nums+=str(i+1)+" | "
        print(nums)
        for i, x in enumerate(mapa) :
            if i > 8:
                auxiliar = str(i+1)
            else: 
                auxiliar= str(i+1)+" "
            for y in x:
                if y == True: 
                    auxiliar+="| X "
                else:
                    auxiliar+="|   "
            print("  "+"-"*len(mapa[1]*4)+ "-")
            print(auxiliar)
        print()
        print("* "*len(mapa[1]) +"* "* len(mapa[1])+ "* * * *")