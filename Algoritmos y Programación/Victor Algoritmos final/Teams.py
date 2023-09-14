
from API import API
from Team import Team
class Teams():
    """ Class Teams.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self):
        """ Init.
        Recibe: n/a
        Retorna: Lista. """

        self.teams = []
        self.get_teams()
        
    def get_teams(self):
        """ Obtencion de equipos de Api.
        Recibe: n/a
        Retorna: Anade equipos a Clase Team y anade objetos a lista. """
        
        teams_json = API.get_team()
        for team in teams_json:
            name = team["name"]
            fifa_code = team["fifa_code"]
            group = team["group"]
            id = team["id"]
            flag = team["flag"]
            team = Team(name, fifa_code, group, id, flag)
            self.teams.append(team)

    def search_by_country(self, country):
        """ Busqueda por pais.
        Recibe: Pais por seleccion.
        Retorna: Equipo. """

        for team in self.teams:
            if team.name == country:
                return team

    def get_countries(self):
        """ Obtencion de paises.
        Recibe: n/a
        Retorna: Paises. """

        countries = []
        for team in self.teams:
            countries.append(team.name)
        return countries

    def show_countries(self):
        """ Mostrar paises.
        Recibe: n/a
        Retorna: Impresion de id de equipo y nombre de equipo."""

        self.teams.sort(key=lambda team: int(team.id))
        for team in self.teams:
            print(f"        {team.id}. {team.name}")
        
