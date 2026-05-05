from abc import ABC, abstractmethod

# 1. CLASE ABSTRACTA
class Personaje(ABC):
    def __init__(self, nombre, nivel, vida_max):
        self._nombre = nombre
        self._nivel = nivel
        self._puntos_vida_max = vida_max
        self._puntos_vida = vida_max

    def recibir_dano(self, dano):
        self._puntos_vida -= dano
        if self._puntos_vida < 0:
            self._puntos_vida = 0
        print(f"{self._nombre} recibe {dano} de daño.")

    def esta_vivo(self):
        return self._puntos_vida > 0

    @abstractmethod
    def atacar(self, objetivo): pass

    @abstractmethod
    def get_tipo_personaje(self): pass

    def __str__(self):
        return f"[{self.get_tipo_personaje()}] {self._nombre} Nv.{self._nivel} | HP: {self._puntos_vida}/{self._puntos_vida_max}"

# 2. INTERFACES (ABC)
class Habilidoso(ABC):
    @abstractmethod
    def usar_habilidad_especial(self, objetivo): pass
    @abstractmethod
    def get_costo_habilidad(self): pass
    @abstractmethod
    def get_nombre_habilidad(self): pass

class Equipable(ABC):
    @abstractmethod
    def equipar_item(self, item): pass
    @abstractmethod
    def get_item_equipado(self): pass

class Sanador(ABC):
    @abstractmethod
    def sanar(self, objetivo): pass
    @abstractmethod
    def get_potencia_sanacion(self): pass

# 3. SUBCLASES
class Guerrero(Personaje, Habilidoso, Equipable):
    def __init__(self, nombre, nivel):
        super().__init__(nombre, nivel, 100 + (nivel * 10))
        self._fuerza = 15 + (nivel * 3)
        self._defensa = 10 + (nivel * 2)
        self._item_equipado = "Sin equipo"

    def atacar(self, objetivo):
        print(f"{self._nombre} ataca con fuerza bruta!")
        objetivo.recibir_dano(self._fuerza)

    def get_tipo_personaje(self): return "Guerrero"

    def usar_habilidad_especial(self, objetivo):
        print(f"{self._nombre} usa Golpe Devastador!")
        objetivo.recibir_dano(50)

    def get_costo_habilidad(self): return 30
    def get_nombre_habilidad(self): return "Golpe Devastador"

    def equipar_item(self, item):
        self._item_equipado = item
        print(f"{self._nombre} equipó: {item}")

    def get_item_equipado(self): return self._item_equipado

class Mago(Personaje, Habilidoso, Sanador):
    def __init__(self, nombre, nivel):
        super().__init__(nombre, nivel, 60 + (nivel * 5))
        self._mana_max = 80 + (nivel * 10)
        self._mana = self._mana_max

    def atacar(self, objetivo):
        if self._mana >= 20:
            dano = 25 + (self._nivel * 5)
            self._mana -= 20
            print(f"{self._nombre} lanza un hechizo!")
            objetivo.recibir_dano(dano)
        else:
            print(f"{self._nombre}: maná insuficiente")

    def get_tipo_personaje(self): return "Mago"

    def usar_habilidad_especial(self, objetivo):
        if self._mana >= 20:
            self._mana -= 20
            print(f"{self._nombre} lanza Bola de Fuego!")
            objetivo.recibir_dano(40)
        else:
            print(f"{self._nombre}: maná insuficiente para Bola de Fuego.")

    def get_costo_habilidad(self): return 20
    def get_nombre_habilidad(self): return "Bola de Fuego"

    def sanar(self, objetivo):
        objetivo._puntos_vida += 25
        if objetivo._puntos_vida > objetivo._puntos_vida_max:
            objetivo._puntos_vida = objetivo._puntos_vida_max
        print(f"{self._nombre} sana a {objetivo._nombre} por 25 HP.")

    def get_potencia_sanacion(self): return 25

class Arquero(Personaje, Equipable):
    def __init__(self, nombre, nivel):
        super().__init__(nombre, nivel, 75 + (nivel * 7))
        self._flechas = 10 + (nivel * 2)
        self._item_equipado = "Arco basico"

    def atacar(self, objetivo):
        if self._flechas > 0:
            dano = 12 + (self._nivel * 4)
            if self._item_equipado != "Arco basico":
                dano += 5
            self._flechas -= 1
            print(f"{self._nombre} dispara una flecha!")
            objetivo.recibir_dano(dano)
        else:
            print(f"{self._nombre} no tiene flechas para atacar.")

    def get_tipo_personaje(self): return "Arquero"

    def equipar_item(self, item):
        self._item_equipado = item
        print(f"{self._nombre} equipó: {item}")

    def get_item_equipado(self): return self._item_equipado

# 4. BATALLA COMPLETA
heroes = [Guerrero('Thorin', 3), Mago('Gandalf', 5), Arquero('Legolas', 4)]
orco = Guerrero('Orco', 1)
turno = 1

print("=== FASE 1: EQUIPAR ===")
heroes[0].equipar_item("Espada Legendaria")
heroes[2].equipar_item("Arco Elfico")

print("\n=== FASE 2: BATALLA ===")
while orco.esta_vivo():
    print(f"\n--- Turno {turno} ---")
    for h in heroes:
        if not orco.esta_vivo(): break
        
        if turno == 2 and isinstance(h, Habilidoso):
            h.usar_habilidad_especial(orco)
        else:
            h.atacar(orco)
    turno += 1

print("\n=== FASE 3: SANACIÓN POST BATALLA ===")
for h in heroes:
    if isinstance(h, Sanador):
        h.sanar(heroes[0])

print("\n=== ESTADO FINAL ===")
for h in heroes:
    print(h)
print(orco)