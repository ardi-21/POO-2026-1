class Animal:
    def sonido(self):
        print("El animal hace un sonido")
    def moverse(self):
        print("El animal se mueve")
    def comer(self):
        print("El animal come")

class perro(Animal):
    def sonido(self):
        print("El perro ladra")
    def moverse(self):
        print("El perro corre")
    def comer(self):
        print("El perro come croquetas")

class gato(Animal):
    def sonido(self):
        print("El gato maulla")
    def moverse(self):
        print("El gato salta")
    def comer(self):
        print("El gato come pescado")

class pajaro(Animal):
    def sonido(self):
        print("El pajaro canta")
    def moverse(self):
        print("El pajaro vuela")
    def comer(self):
        print("El pajaro come semillas")

class vaca(Animal):
    def sonido(self):
        print("La vaca muge")
    def moverse(self):
        print("La vaca camina")
    def comer(self):
        print("La vaca come pasto")

class serpiente(Animal):
    def sonido(self):
        print("La serpiente sisea")
    def moverse(self):
        print("La serpiente se arrastra")
    def comer(self):
        print("La serpiente come ratones")
