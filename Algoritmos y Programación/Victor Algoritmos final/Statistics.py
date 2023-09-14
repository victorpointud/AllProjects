from Products import Products
from Restaurants import Restaurants
from Clients import Clients
from Teams import Teams
from Tickets import Tickets
from Matches import Matches
from Stadiums import Stadiums

class Statistics():
    """ Clase Statistics.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self):
        """ Init.
        Recibe: n/a.
        Retorna: Lista. """
        pass
    
    def vip_spend_by_match(self):
        """ Gasto de cliente Vip en un partido.
        Recibe: n/a
        Retorna: n/a """

        #¿Cuál es el promedio de gasto de un cliente VIP en un partido (ticket + restaurante)?
        pass

    def attendance_by_match(self):
        """ Asistencia a partidos.
        Recibe: n/a
        Retorna: n/a """

        #Mostrar tabla con la asistencia a los partidos de mejor a peor, mostrando el nombre del partido (nombre de los equipos), estadio en donde se juega, boletos vendidos, personas que asistieron y la relación asistencia/venta

        self.attendance
        pass

    def max_match_attendance(self):
        """ Partido con mayor asistencia.
        Recibe: n/a
        Retorna: n/a """

        #¿Cuál fue el partido con mayor asistencia?
        pass
    
    def max_match_tickets_sold(self):
        """ Partido con mayor boletos vendidos.
        Recibe: n/a
        Retorna: n/a """

        #¿Cuál fue el partido con mayor boletos vendidos?
        pass

    def top_sold_products_by_restaurant(self):
        """ Top productos mas vendidos por restaurantes.
        Recibe: n/a
        Retorna: n/a """

        #Top 3 productos más vendidos en el restaurante.
        pass

    def top_clients_buying_tickets(self):
        """ Top clientes con mayor tickets comprados.
        Recibe: n/a
        Retorna: n/a """

        #Top 3 de clientes (clientes que más compraron boletos)
        pass

    def graphic_statistics(self):
        """ Graficas con matplot.lib.
        Recibe: n/a
        Retorna: n/a """

        #Realizar gráficos con dichas estadísticas con las librerías de mathplotlib o Bokeh (Bono).
        pass