from API import API
from Restaurant import Restaurant

class Restaurants():
    """ Class Restaurants.
        Recibe: n/a
        Retorna: n/a """
        
    def __init__(self):
        """ Init.
        Recibe: n/a
        Retorna: lista. """

        self.restaurants = []
        self.get_restaurants()
    
    def get_restaurants(self):
        """ Obtener info de restaurantes de la api.
        Recibe: n/a
        Retorna: Anade info a Clase Restaurant y anade a lista. """

        stadiums_json = API.get_stadium()
        for stadium in stadiums_json:
            for restaurant in stadium["restaurants"]:
                stadium_id = stadium["id"]
                name = restaurant["name"]
                products = restaurant["products"]
                restaurant = Restaurant(name, stadium_id, products)
                self.restaurants.append(restaurant)
