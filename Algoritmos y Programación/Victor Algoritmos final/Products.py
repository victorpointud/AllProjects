
from Product import Product
from Clients import Clients
from Client import Client
from Restaurants import Restaurants
from Restaurants import Restaurant
from Stadiums import Stadiums
from Stadium import Stadium

from API import API

class Products():
    """ Clase Products.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self):
        """ Init.
        Recibe: n/a
        Retorna: Lista. """

        self.products = []
        self.get_products()

    def get_products(self):
        """ Obtencion de productos del json.
        Recibe: n/a
        Retorna: Anade productos a Clase Product y los anade a lista como objetos. """

        stadiums_json = API.get_stadium()
        for stadium in stadiums_json:
            for restaurant in stadium["restaurants"]:
                for product in restaurant["products"]:
                    stadium_id = stadium["id"]
                    restaurant_name = restaurant["name"]
                    name = product["name"]
                    quantity = product["quantity"]
                    price = product["price"]
                    type = product["type"]
                    adicional = product["adicional"]
                    product = Product(stadium_id, restaurant_name, name, quantity, price, type, adicional)
                    self.products.append(product)

    def show_products(self, products):
        """ Muestra de productos.
        Recibe: Producto por input
        Retorna: Muestra de productos como objetos. """

        for product in products:
            print(product.show_info())
    
    def print_products_names(self):
        """ Mostrar nombres de productos.
        Recibe: n/a
        Retorna: Nombres de productos. """

        products = []
        contador = 1
        for product in self.products:
            products.append(product.name)
            for product in products:
                while(products.count(product) > 1):
                    products.remove(product)
                    print(f"        {contador}. {product}")
                    contador += 1

    def print_products_names_for_minors(self):
        """ Mostrar nombres de productos sin bebidas alcoholicas.
        Recibe: n/a
        Retorna: Nombres de productos. """

        contador = 1
        for product in self.products:
            if product.adicional != "alcoholic":
                print(f"{contador}. {product.name}")
            contador += 1

    def search_by_product_name(self, product_name):
        """ Busqueda de producto por nombre.
        Recibe: Nombre de producto.
        Retorna: Productos. """

        products = []
        for product in self.products:
            if product.name == product_name:
                products.append(product)
        return products

    def search_by_product_type(self, product_type):
        """ Busqueda de producto por tipo.
        Recibe: Tipo de producto.
        Retorna: Productos. """

        products = []
        for product in self.products:
            if product.type == product_type:
                products.append(product)
        return products
    
    def search_by_product_adicional(self, product_adicional):
        """ Busqueda de producto por adicional.
        Recibe: Adicioanl de producto.
        Retorna: Productos. """

        products = []
        for product in self.products:
            if product.adicional == product_adicional:
                products.append(product)
        return products

    def search_by_product_price(self, product_price):
        """ Busqueda de producto por precio.
        Recibe: Rango de precios de producto.
        Retorna: Productos. """

        products = []
        for product in self.products:
            if product.price in product_price:
                products.append(product)
        return products

    def buy_product(self, clients, stadiums, matches, restaurants):
        """ Compra de productos.
        Recibe: n/a
        Retorna: n/a """
        
        while True:
            ci = input("""
            Favor ingresar su cedula:
            
            """)
            while not ci.isnumeric():
                ci = input("""
            Favor ingresar su cedula:
            
            """)
            
            clients.print_clients_by_ci_and_type(ci)
    
            self.print_products_names()
            product_name = input("""
            Favor ingresar el nombre del producto que desee:
            
            """)

            while not product_name.isalpha():
                product_name = input("""
            Ingrese el nombre del producto que desee:

            """)       

            products = self.search_by_product_name(product_name)
            self.show_products(products)

            if products == None or products == []:
                print("""
                No se ha encontrado el producto.

                """)

            subtotal = self.subtotal(products)
            total_products = self.total_products(products)
            total =self.total(subtotal, products)

            print(f"""
            productos: {total_products}
            taxes: 16 %
            subtotal: ${subtotal}
            total: ${total}
            """)

            selection = int(input("""
                Desea proceder con el pago?:

                    1. Si.
                    2. No.

                """))  

            if selection == 1:
                print("""
    
                Su pago ha sido realizado exitoxamente.

                """)
                for product in products:
                    product.quantity - 1

            else:
                break

            break
        
    def subtotal(self, products):
        for product in products:
            subtotal = product.price * 0.16
            return subtotal
    
    def total(self, subtotal, products):
        for product in products:
            total = product.price + subtotal 
            return total
    
    def total_products(self, products):
        for product in products:
            total_products = product.name
            return total_products
    
        