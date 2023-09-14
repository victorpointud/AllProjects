
class Stadium():
    """ Class Stadium.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, id, name, capacity, location, restaurants):
        """ Init.
        Recibe: Variables.
        Retorna: Variables con self. """

        self.id = id
        self.name = name
        self.capacity = capacity
        self.location = location
        self.restaurants = restaurants
    
    def show_info(self):
        """ Muestra de estadios.
        Recibe: n/a
        Retorna: Info de estadios por objetos. """

        return(f"""
        id: {self.id}
        nombre: {self.name}
        capacidad: {self.capacity}
        ubicacion: {self.location}
        restaurants: {self.restaurants}
        """)