from Tickets import Tickets
from Client import Client

class Clients():
    """ Clase Clients.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, tickets, matches, teams):
        """ Init.
        Recibe: Tickets.
        Retorna: Lista. """
        
        self.tickets = tickets
        self.matches = matches
        self.teams = teams
        self.clients = []
    
    def add_clients(self):
        """ Anadir clientes.
        Recibe: n/a.
        Retorna: Clientes. """

        first_name = input("""
        Favor ingresar su primer nombre:
        
        """)
        while not first_name.isalpha():
            first_name = input("""
        Favor ingresar su primer nombre:
        
        """)

        last_name = input("""
        Favor ingresar su primer apellido:
        
        """)
        while not last_name.isalpha():
            last_name = input("""
        Favor ingresar su primer apellido:
        
        """)

        dni = input("""
        Favor ingresar su cedula:
                
        """)
        while not dni.isnumeric():
            dni = input("""
        Favor ingresar su cedula:
                
        """)

        age = input("""
        Favor ingresar su edad:
                
        """)
        while not age.isnumeric():
            age = input("""
        Favor ingresar su edad:
                
        """)

        try:
            ticket_by_type = int(input("""
        Favor ingresar el tipo de entrada que desee comprar:

        1. General.
        2. Vip.

        """))
        except Exception as e:
            print("Error: ", str(e))
        
        self.teams.show_countries()
        

        try:
            team_id = int(input("""
        Ingrese el equipo para el que desee comprar la entrada:
        
        """))
        except Exception as e:
            print("Error: ", str(e))

        matches = self.matches.search_by_team_id(team_id)
        if matches == None or matches == []:
            print("""
        No se ha encontrado el equipo.

        """)
        else:
            self.matches.print_matches(matches)

        try:
            match_id = int(input("""
        Ingrese el id del partido que desee comprar la entrada:
        
        """))
        except Exception as e:
            print("Error: ", str(e))
            

        match = self.matches.search_by_match_id(match_id)
        if match == None or match == []:
            print("""
        No se ha encontrado el partido.

        """)

        client = Client(first_name, last_name, dni, age, match_id, ticket_by_type)
        self.clients.append(client)

        return client

    def show_clients(self):
        """ Muestra de clientes como objetos.
        Recibe: n/a
        Retorna: Info de clientes como objetos. """

        for client in self.clients:
            print(client.show_info())
    
    def print_clients_by_ci_and_type(self, ci):
        """ Muestra de cliente y mensaje para saber si puedes comprar o no.
        Recibe: Cedula.
        Retorna: Info de clientes. """
        exists = False
        for client in self.clients:
            if client.dni == ci and client.ticket_by_type == 2:
                print(client.show_info())
                print("""
            
            Su ticket es vip, puede comprar.
            """)
                exists = True
                

            elif client.dni == ci and client.ticket_by_type == 1:
                print(client.show_info())
                print("""
            
            Su ticket es no es vip, no puede comprar.
            """)
                exists =True
                
                break

        if not exists:
            print("""
            
            La cedula no esta en sistema.
            """)