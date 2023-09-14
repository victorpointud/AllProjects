
import pickle
class Utils():
    """ Class Utils.
        Recibe: n/a
        Retorna: n/a """

    def __init__(self):
        """ Init.
        Recibe: n/a
        Retorna: n/a """
        pass

    def load_from_txt(self, path):
            try:
                data = pickle.load(open(path, "rb"))
                if data:
                    return data
                else:
                    return None
            except Exception as e:
                print("Error: ", str(e))
