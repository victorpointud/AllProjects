
class Client():
    """ Clase Client.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, first_name, last_name, dni, age, match_id, ticket_by_type):
        """ Init.
        Recibe: Variables.
        Retorna: Varibales con self. """
        
        self.first_name = first_name
        self.last_name = last_name
        self.dni = dni
        self.age = age
        self.match_id = match_id
        self.ticket_by_type = ticket_by_type
    
    def show_info(self):
        """ Muestra de clientes como objetos.
        Recibe: n/a
        Retorna: Info de clientes. """

        return(f"""
        nombre: {self.first_name}
        apellido: {self.last_name}
        ci: {self.dni}
        edad: {self.age}
        id del partido: {self.match_id}
        ticket: {self.ticket_by_type} """)
    