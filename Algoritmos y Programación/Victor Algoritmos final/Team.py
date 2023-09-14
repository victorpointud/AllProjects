
class Team():
    """ Class Team.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, name, fifa_code, group, id, flag):
        """ Init.
        Recibe: Variables.
        Retorna: Variables con self. """

        self.name = name
        self.fifa_code = fifa_code
        self.group = group
        self.id = id
        self.flag = flag
    
    def show_info(self):
        """ Mostrar equipos.
        Recibe: n/a
        Retorna: Info de equipos por objetos. """

        return(f"""
        nombre: {self.name}
        codigo: {self.fifa_code}
        grupo: {self.group}""")