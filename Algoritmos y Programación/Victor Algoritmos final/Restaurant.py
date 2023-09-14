
class Restaurant():
    """ Class Restaurant.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, name, stadium_id, products):
        """ Init.
        Recibe: Variables.
        Retorna: Variables con self. """

        self.name = name
        self.stadium_id = stadium_id
        self.products = products

    def show_info(self):
        """ Muestra de restaurantes como objetos.
        Recibe: n/a
        Retorna: Info de restaurantes. """

        return(f"""
        nombre: {self.name}
        id del estadio: {self.stadium_id}
        productos: {self.products}
        """)