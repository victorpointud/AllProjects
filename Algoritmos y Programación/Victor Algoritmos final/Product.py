
class Product():
    """ Clase Product.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, stadium_id, restaurant_name, name, quantity, price, type, adicional):
        """ Init.
        Recibe: variables.
        Retorna: variables con self. """

        self.stadium_id = stadium_id
        self.restaurant_name = restaurant_name
        self.name = name
        self.quantity = quantity
        self.price = price
        self.type = type
        self.adicional = adicional

    def show_info(self):
        """ Muestra de productos como objetos.
        Recibe: n/a
        Retorna: Info de productos. """

        return(f"""
        id del estadio: {self.stadium_id}
        restaurante: {self.restaurant_name}
        nombre: {self.name}
        cantidad: {self.quantity}
        precio: {self.price}
        tipo: {self.type}
        adicional: {self.adicional}
        """)