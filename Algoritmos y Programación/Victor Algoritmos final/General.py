
from Ticket import Ticket
class General(Ticket):
    """ Clase General.
        Recibe: Clase Ticket.
        Retorna: n/a """

    def __init__(self, ticket, match, total, column, row): 
        """ Init.
        Recibe: Variables con variables de Clase Ticket.
        Retorna: Variables con self. """

        super().__init__(ticket, match, 50, column, row)
        self.total = total

        