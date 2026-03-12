# ─── 1. Perro ───────────────────────────────────────────
class Perro(Animal):
    def __init__(self):      super().__init__("Perro")
    def sonido(self):        print("🐶 El perro ladra: ¡Guau guau!")
    def moverse(self):       print("🐶 El perro corre y mueve la cola.")
    def comer(self):         print("🐶 El perro come croquetas.")
 
 
# ─── 2. Gato ────────────────────────────────────────────
class Gato(Animal):
    def __init__(self):      super().__init__("Gato")
    def sonido(self):        print("🐱 El gato maúlla: ¡Miau!")
    def moverse(self):       print("🐱 El gato salta sigilosamente.")
    def comer(self):         print("🐱 El gato come pescado.")
 
 
# ─── 3. Pájaro ──────────────────────────────────────────
class Pajaro(Animal):
    def __init__(self):      super().__init__("Pájaro")
    def sonido(self):        print("🐦 El pájaro canta: ¡Pío pío!")
    def moverse(self):       print("🐦 El pájaro vuela entre los árboles.")
    def comer(self):         print("🐦 El pájaro come semillas.")
 
 
# ─── 4. Vaca ────────────────────────────────────────────
class Vaca(Animal):
    def __init__(self):      super().__init__("Vaca")
    def sonido(self):        print("🐄 La vaca muge: ¡Muuu!")
    def moverse(self):       print("🐄 La vaca camina lentamente por el prado.")
    def comer(self):         print("🐄 La vaca pasta hierba.")
 
 
# ─── 5. Serpiente ───────────────────────────────────────
class Serpiente(Animal):
    def __init__(self):      super().__init__("Serpiente")
    def sonido(self):        print("🐍 La serpiente sisea: ¡Ssss!")
    def moverse(self):       print("🐍 La serpiente se arrastra por el suelo.")
    def comer(self):         print("🐍 La serpiente se traga un ratón entero.")
 
 
# ─── Main ───────────────────────────────────────────────
if __name__ == "__main__":
    animales = [Perro(), Gato(), Pajaro(), Vaca(), Serpiente()]
 
    for animal in animales:
        print(f"\n═══ {animal.nombre.upper()} ═══")
        animal.sonido()
        animal.moverse()
        animal.comer()
