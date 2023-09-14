
from Ticket import Ticket
class Vip(Ticket):
    """ Class Vip.
        Recibe: Class Ticket
        Retorna: n/a """

    def __init__(self, ticket, match, total, column, row):
        """ Init.
        Recibe: Variables y super de Class Ticket.
        Retorna: Variables.self """

        super().__init__(ticket, match, 120, column, row)
        self.total = total
    
