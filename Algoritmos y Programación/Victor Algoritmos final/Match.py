
class Match():
    """ Clase Match.
        Recibe: n/a
        Retorna: n/a """
        
    def __init__(self, home_team, away_team, date, stadium, id):
        """ Init.
        Recibe: n/a
        Retorna: n/a """

        self.home_team = home_team
        self.away_team = away_team
        self.date = date
        self.stadium = stadium
        self.id = id

    def show_info(self):
        """ Muestra de partidos como objetos.
        Recibe: n/a
        Retorna: Info de productos. """

        return(f"""
        local: {self.home_team.name}
        visitante: {self.away_team.name}
        fecha: {self.date}
        estadio: {self.stadium.name}
        id: {self.id}
        """)
    