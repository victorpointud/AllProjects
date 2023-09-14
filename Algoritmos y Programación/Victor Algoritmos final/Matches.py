
from API import API
from Match import Match

class Matches():
    """ Clase Matches.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self, teams, stadiums):
        """ Init.
        Recibe: Variables
        Retorna: Variables con self y lista. """

        self.matches = []
        self.teams = teams
        self.stadiums = stadiums
        self.get_matches()
       
    def get_matches(self):
        """ Extraccion de partidos de la API.
        Recibe: n/a
        Retorna: Anade a Clase Match como objeto y anade info a lista. """

        matches_json = API.get_match()
        for match in matches_json:

            for team in self.teams:
                if team.name == match["home_team"]:
                    home_team = team
                elif team.name == match["away_team"]:
                    away_team = team

            date = match["date"]

            for s in self.stadiums:
                if s.id == match["stadium_id"]:
                    stadium = s

            id = match["id"]

            match = Match(home_team, away_team, date, stadium, id)
            self.matches.append(match)
            
    def print_matches(self, matches):
        """ Se Imprimen los partidos.
        Recibe: Partidos
        Retorna: Impresion de partidos como objetos """

        for match in matches:
            print(match.show_info())

    def search_by_team_id(self, team_id):
        """ Busqueda de partido por id de equipo.
        Recibe: Id de equipo que fue seleccionado.
        Retorna: Partidos """

        matches = []
        for match in self.matches:
            if match.home_team.id == str(team_id) or match.away_team.id == str(team_id):
                matches.append(match)
        return matches
    
    def search_by_date(self, selecc_date):
        """ Busqueda de partido por fecha.
        Recibe: Fecha que fue introducida en formato mm/dd/yyyy.
        Retorna: Fechas. """

        dates = []
        for match in self.matches:
            if selecc_date in match.date:
                dates.append(match)
        return dates

    def search_by_match_id(self, match_id):
        """ Busqueda de partido por id del partido.
        Recibe: Id de partido que fue seleccionado.
        Retorna: Partido """
        
        for match in self.matches:
            if match.id == str(match_id):
                return match
        return None

    def get_by_stadium_id(self, stadium_id):
        """ Busqueda de partido por id de estadio.
        Recibe: Id de estadio que fue seleccionado.
        Retorna: Partidos """
        
        matches = []
        for match in self.matches:
            if match.stadium.id == stadium_id:
                matches.append(match)
        return matches