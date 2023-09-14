
import requests
from Team import Team
from Stadium import Stadium
from Match import Match

class API():
    """ Clase API.
        Recibe: n/a
        Retorna: n/a """
        
    def __init__(self):
        """ INIT.
        Recibe: n/a
        Retorna: n/a """
        pass
    
    def get_team():
        """ Info de API de equipos.
        Recibe: n/a
        Retorna: response.json (json) """

        url = "https://raw.githubusercontent.com/Algoritmos-y-Programacion-2223-1/api-proyecto/main/teams.json"
        response = requests.request( "GET", url)
        return response.json()

    def get_stadium():
        """ Info de API de estadios.
        Recibe: n/a
        Retorna: response.json (json) """

        url = "https://raw.githubusercontent.com/Algoritmos-y-Programacion-2223-1/api-proyecto/main/stadiums.json"
        response = requests.request("GET", url)
        return response.json()

    def get_match(): 
        """ Info de API de partidos.
        Recibe: n/a
        Retorna: response.json (json) """
        
        url = "https://raw.githubusercontent.com/Algoritmos-y-Programacion-2223-1/api-proyecto/main/matches.json"
        response = requests.request("GET", url)
        return response.json()
