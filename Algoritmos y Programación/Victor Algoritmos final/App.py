from Tickets import Tickets
from Products import Products
from Ticket import Ticket
from Vip import Vip
from General import General
from Match import Match
from Stadium import Stadium
from Team import Team
from Product import Product
from Client import Client
from Clients import Clients
from API import API
from Matches import Matches
from Stadiums import Stadiums
from Utils import Utils
from Teams import Teams
from Restaurant import Restaurant
from Restaurants import Restaurants
from Statistics import Statistics
import pickle

class App():
    """ Clase App.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self):
        """ Lectura de archivos txt.
        Recibe: n/a
        Retorna: n/a """

        self.stadiums = Utils().load_from_txt("stadiums.txt") if Utils().load_from_txt("stadiums.txt") else Stadiums()
        self.teams = Utils().load_from_txt("teams.txt") if Utils().load_from_txt("teams.txt") else Teams()
        self.matches = Utils().load_from_txt("matches.txt") if Utils().load_from_txt("matches.txt") else Matches(self.teams.teams, self.stadiums.stadiums)
        self.tickets = Utils().load_from_txt("tickets.txt") if Utils().load_from_txt("tickets.txt") else Tickets(self.stadiums, self.teams, self.matches)
        self.clients = Utils().load_from_txt("clients.txt") if Utils().load_from_txt("clients.txt") else Clients(self.tickets, self.matches, self.teams)
        self.restaurants = Utils().load_from_txt("restaurants.txt") if Utils().load_from_txt("restaurants.txt") else Restaurants()
        self.products = Utils().load_from_txt("products.txt") if Utils().load_from_txt("products.txt") else Products()
        self.statistics = Utils().load_from_txt("statistics.txt") if Utils().load_from_txt("statistics.txt") else Statistics()

    def start(self):
        """ Menu de seleccion y arranque de programa.
        Recibe: n/a
        Retorna: n/a """

        print("\nBIENVENIDO A QATAR 2022.")
        while True:
            try:
                selection = int(input(""" 
        Seleccione la accion que desee realizar:

        1. Gestión de partidos y estadios. 
        2. Gestión de venta de entradas.
        3. Gestión de asistencia a partidos.
        4. Gestión de restaurantes.
        5. Gestión de venta de restaurantes.
        6. Indicadores de gestión (estadísticas).
        7. Salir

        """))                
                if selection == 1:
                    self.search_1()

                elif selection == 2:
                    client = self.clients.add_clients()
                    self.tickets.buy_ticket(client)

                elif selection == 3:
                    self.tickets.check_ticket()

                elif selection == 4:
                    self.search_2()

                elif selection == 5:
                    self.products.buy_product(self.clients, self.stadiums, self.matches, self.restaurants)

                elif selection == 6:
                    self.statistics.vip_spend_by_match()
                    self.statistics.attendance_by_match()
                    self.statistics.max_match_attendance()
                    self.statistics.max_match_tickets_sold()
                    self.statistics.top_sold_products_by_restaurant()
                    self.statistics.top_clients_buying_tickets()
                    self.statistics.graphic_statistics()

                elif selection == 7:
                    pickle.dump(self.stadiums, open("stadiums.txt", "wb"))
                    pickle.dump(self.teams, open("teams.txt", "wb"))
                    pickle.dump(self.matches, open("matches.txt", "wb"))
                    pickle.dump(self.tickets, open("tickets.txt", "wb"))
                    pickle.dump(self.clients, open("clients.txt", "wb"))
                    pickle.dump(self.restaurants, open("restaurants.txt", "wb"))
                    pickle.dump(self.products, open("products.txt", "wb"))
                    pickle.dump(self.statistics, open("statistics.txt", "wb"))
                    break
                
                else:
                    pickle.dump(self.stadiums, open("stadiums.txt", "wb"))
                    pickle.dump(self.teams, open("teams.txt", "wb"))
                    pickle.dump(self.matches, open("matches.txt", "wb"))
                    pickle.dump(self.tickets, open("tickets.txt", "wb"))
                    pickle.dump(self.clients, open("clients.txt", "wb"))
                    pickle.dump(self.restaurants, open("restaurants.txt", "wb"))
                    pickle.dump(self.products, open("products.txt", "wb"))
                    pickle.dump(self.statistics, open("statistics.txt", "wb"))
                    break
            
            except Exception as e:
                print("Error: ", str(e))

    def search_1(self):
        """ Filtros de busqueda para partidos.
        Recibe: n/a
        Retorna: n/a """
        
        while True:
            try:
                selection = int(input("""
            Seleccione la opcion que desee:
            
            1. Buscar partidos por Pais.
            2. Buscar partidos por Estadio. 
            3. Buscar partidos por Fecha. 
            4. Salir.
            
            """))
               
                if selection == 1:
                    while True:
                        print()
                        self.teams.show_countries()
                        try:
                            team_id = int(input("""
            Ingrese el equipo que desee:
            
            """))
                   
                            matches = self.matches.search_by_team_id(team_id)
                            if matches == None or matches == []:
                                print("""
            No se ha encontrado el equipo.

            """)
                            else:
                                self.matches.print_matches(matches)
                        except Exception as e:
                            print("Error: ", str(e))
                        break
                    
                elif selection == 2:
                    while True:
                        print()
                        self.stadiums.show_stadiums()
                        try:
                            stadium_id = int(input("""
            Ingrese el numero del estadio que desee:
            
            """))
                            stadium = self.stadiums.search_by_id(stadium_id)
                            if stadium == None or stadium == False or stadium == []:
                                print("""
            No se ha encontrado el estadio.

            """)
                            else:
                                matches = self.matches.get_by_stadium_id(stadium_id)
                                self.matches.print_matches(matches)
                        except Exception as e:
                            print("Error: ", str(e))
                        break

                elif selection == 3:
                    selecc_date = input("""
            Ingrese la fecha que desee en formato mm/dd/yyyy:
            
            """)
                    dates = self.matches.search_by_date(selecc_date)
                    for i in dates:                  
                        print(i.show_info())  
                    if dates == None or dates == []:
                        print("""
            No hay partidos en la fecha seleccionada.

            """)

                elif selection == 4:
                    break

                else:
                    break

            except Exception as e:
                print("Error: ", str(e))

    def search_2(self):
        """ Filtros de busqueda para productos.
        Recibe: n/a
        Retorna: n/a """

        while True:
            try:
                selection = int(input("""
            Seleccione la opcion que desee:
            
            1. Buscar productos por nombre.
            2. Buscar productos por tipo. 
            3. Buscar productos por precio. 
            4. Salir.
            
            """))
                if selection == 1:
                    while True:
                        print()
                        self.products.print_products_names()
                        try:
                            product_name = input("""
                Ingrese el nombre que desee:
                
                """)        
                            products = self.products.search_by_product_name(product_name)
                            if products == None or products == []:
                                print("""
                No se ha encontrado el producto.

                """)
                            else:
                                self.products.show_products(products)

                        except Exception as e:
                            print("Error: ", str(e))

                        break
                        
                elif selection == 2:
                    while True:
                        try:
                            product_type = int(input("""
                Ingrese el tipo de producto que desee:

                    1. Comida.
                    2. Bebida.
                    
                """))
                    
                            if product_type == 1:
                                product_type = "food"
                                products = self.products.search_by_product_type(product_type)
                                self.products.show_products(products)

                                while True:
                                    try:
                                        product_adicional = int(input("""
                    Ingrese el tipo de comida que desea:

                        1. Plato.
                        2. Empacado.
                        
                """))       
                                        if product_adicional == 1:
                                            product_adicional = "plate"
                                            products = self.products.search_by_product_adicional(product_adicional)
                                            self.products.show_products(products)

                                        elif product_adicional == 2:
                                            product_adicional = "package"
                                            products = self.products.search_by_product_adicional(product_adicional)
                                            self.products.show_products(products)

                                        else:
                                            break
                                    
                                    except Exception as e:
                                        print("Error: ", str(e))

                                    break

                            elif product_type == 2:
                                product_type = "beverages"
                                products = self.products.search_by_product_type(product_type)
                                self.products.show_products(products)
                                
                                while True:
                                    try:
                                        product_adicional = int(input("""
                    Ingrese el tipo de bebida que desea:

                        1. Alcoholica.
                        2. No Alcoholica.
                        
                """))       
                                        if product_adicional == 1:
                                            product_adicional = "alcoholic"
                                            products = self.products.search_by_product_adicional(product_adicional)
                                            self.products.show_products(products)
                                        

                                        elif product_adicional == 2:
                                            product_adicional = "non-alcoholic"
                                            products = self.products.search_by_product_adicional(product_adicional)
                                            self.products.show_products(products)
                                        
                                        else:
                                            break
                                    
                                    except Exception as e:
                                        print("Error: ", str(e))

                                    break

                            else:
                                break
                                
                        except Exception as e:
                            print("Error: ", str(e))

                        break

                elif selection == 3:
                    while True:
                        try:
                            min_price = int(input("""
                    Ingrese el precio minimo del producto que desee:
                    
                    """))
                            max_price = int(input("""
                    Ingrese el precio maximo del producto que desee:
                    
                    """))   

                            product_price = range(min_price, max_price + 1)
                            products = self.products.search_by_product_price(product_price)
                            if products == None or products == []:
                                print("""
                        No se ha encontrado un producto en ese rango de precio.

                        """)
                            else:
                                self.products.show_products(products)
                            
                            while min_price < 0 or max_price < 0:
                                print("""
                        No se puede realizar la operacion con un numero negativo

                         """)   
                                break

                            while max_price < min_price:
                                print("""
                        No se puede realizar la operacion al ser precio maximo menor que precio minimo

                         """)
                                break
                        
                        except Exception as e:
                            print("Error: ", str(e))
                        
                        break

                elif selection == 4:
                    break

            except Exception as e:
                print("Error: ", str(e))

