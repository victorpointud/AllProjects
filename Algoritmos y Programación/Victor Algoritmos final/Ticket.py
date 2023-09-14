
class Ticket():
    """ Class Ticket.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, ticket, match, price, column, row):
        """ Init.
        Recibe: Variables.
        Retorna: Variables con self. """

        self.ticket = ticket
        self.column = column
        self.row = row
        self.match = match
        self.price = price
        self.subtotal = self.price * 0.16 
        self.attendance = False

    def show_info(self):
        """ Mostrar tickets.
        Recibe: n/a
        Retorna: Info de tickets. """

        return(f"""
        id del ticket: {self.ticket}
        id del row: {self.row}
        id del column: {self.column}
        partido: {self.match}
        asistencia: {self.attendance}""")
    