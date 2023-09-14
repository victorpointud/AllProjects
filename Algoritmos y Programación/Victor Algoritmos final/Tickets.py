from Teams import Teams
from Stadiums import Stadiums
from Team import Team
from Stadium import Stadium
from Ticket import Ticket
from Match import Match
from General import General
from Vip import Vip

class Tickets():
    """ Class Tickets.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, stadiums, teams, matches):
        """ Init.
        Recibe: Variables.
        Retorna: Variables con self y Listas. """

        self.tickets = []
        self.attendance = 0
        self.stadiums = stadiums
        self.teams = teams
        self.matches = matches

    def buy_ticket(self, client):
        """ Comprar ticket.
        Recibe: n/a
        Retorna: Datos del cliente, Impresion del estadio, info en objetos de tickets. """

        match = self.matches.search_by_match_id(client.match_id)
        if match == None or match == []:
            print("""
        No se ha encontrado el partido.

        """)
        else:
            if client.ticket_by_type == 1:
                capacity = match.stadium.capacity[0] 
            else:
                capacity = match.stadium.capacity[1]

            mapa = self.stadiums.get_map(int(capacity/10), 10)

            for ticket in self.tickets:
                if int(ticket.match.id) == client.match_id and (isinstance(ticket,General) and client.ticket_by_type == 1): 
                    mapa[int(ticket.row)-1][int(ticket.column)-1] = True

                elif int(ticket.match.id) == client.match_id and (isinstance(ticket,Vip) and client.ticket_by_type == 2):
                    mapa[int(ticket.row)-1][int(ticket.column)-1] = True

            self.stadiums.print_map(mapa)

        while True:
            try:
                fila = int(input("""
        Seleccione la fila del asiento que desee comprar:
                    
        """))
                columna = int(input("""
        Seleccione la columna del asiento que desee comprar:
                    
        """))
            except Exception as e:
                print("Error: ", str(e))


            mapa[int(fila)-1][int(columna)-1] = True  
            self.stadiums.print_map(mapa)
            seat = (fila, columna)
            taken = False


            for s in self.tickets:
                puesto = (int(s.row), int(s.column))
                if puesto == seat and (isinstance(s,General) and client.ticket_by_type == 1):
                    print("""
        El asiento seleccionado ya ha sido adquirido.
            
        """)

                    taken = True
                    break
                elif puesto == seat and (isinstance(s,Vip) and client.ticket_by_type == 2):
                    print("""
        El asiento seleccionado ya ha sido adquirido.
            
        """)
                    taken = True
                    break

            if not taken:
                ticket = f'{client.match_id}-{client.ticket_by_type}-{fila}-{columna}'
                precio = 50 if client.ticket_by_type == 1 else 120
                subtotal = precio * 0.16
                total = precio + subtotal
                print(f"""
            precio: ${precio}
            taxes: 16 %
            subtotal: ${subtotal}
            total: ${total}
            ticket: {ticket}
                """)

                selection = int(input("""
                Desea continuar con la compra?:

                1. Si.
                2. No.

                """))

                if selection == 1:
                    if client.ticket_by_type == 1:
                        new_ticket = General(ticket, match, total, columna,fila) 

                    else:
                        new_ticket = Vip(ticket, match, total, columna, fila) 
                    self.tickets.append(new_ticket)
                
                if selection == 2:
                    break
                
            break

    def check_ticket(self):
        """ Verificacion de ticket.
        Recibe: n/a
        Retorna: Ticket usado, Ticket en sistema, """

        while True:
            put = input("""
        Favor ingresar el codigo de tu ticket:
        
        """)

            found = False
            for ticket in self.tickets:
                if put == ticket.ticket:
                    found = True
                    if ticket.attendance:
                        print("""
            El ticket ya ha sido usado.        
            """)
                    else:
                        print("""
            El ticket esta en sistema.        
            """)
                        ticket.attendance = True
                    break
            if not found:
                print("""
            El ticket no se encuentra en sistema.        
            """)
            try:
                selection = int(input("""
            Desea salir?:

            1. Si.
            2. No.

            """))
            except Exception as e:
                print("Error: ", str(e))

            if selection == 1:
                break
            elif selection == 2:
                pass
