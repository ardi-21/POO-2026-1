import java.util.ArrayList;
import java.util.List;

// 1. CLASE ABSTRACTA
abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVidaMax;
    protected int puntosVida;

    public Personaje(String nombre, int nivel, int puntosVidaMax) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosVida = puntosVidaMax;
    }

    public void recibirDano(int dano) {
        this.puntosVida -= dano;
        if (this.puntosVida < 0) {
            this.puntosVida = 0;
        }
        System.out.println(this.nombre + " recibe " + dano + " de daño.");
    }

    public boolean estaVivo() {
        return this.puntosVida > 0;
    }

    public abstract void atacar(Personaje objetivo);
    public abstract String getTipoPersonaje();

    @Override
    public String toString() {
        return "[" + getTipoPersonaje() + "] " + this.nombre + " Nv." + this.nivel + " | HP: " + this.puntosVida + "/" + this.puntosVidaMax;
    }
}

// 2. INTERFACES
interface Habilidoso {
    void usarHabilidadEspecial(Personaje objetivo);
    int getCostoHabilidad();
    String getNombreHabilidad();
}

interface Equipable {
    void equiparItem(String item);
    String getItemEquipado();
}

interface Sanador {
    void sanar(Personaje objetivo);
    int getPotenciaSanacion();
}

// 3. SUBCLASES
class Guerrero extends Personaje implements Habilidoso, Equipable {
    private int fuerza;
    private int defensa;
    private String itemEquipado;

    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel, 100 + (nivel * 10));
        this.fuerza = 15 + (nivel * 3);
        this.defensa = 10 + (nivel * 2);
        this.itemEquipado = "Sin equipo";
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(this.nombre + " ataca con fuerza bruta!");
        objetivo.recibirDano(this.fuerza);
    }

    @Override
    public String getTipoPersonaje() { return "Guerrero"; }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        System.out.println(this.nombre + " usa Golpe Devastador!");
        objetivo.recibirDano(50);
    }

    @Override
    public int getCostoHabilidad() { return 30; }

    @Override
    public String getNombreHabilidad() { return "Golpe Devastador"; }

    @Override
    public void equiparItem(String item) {
        this.itemEquipado = item;
        System.out.println(this.nombre + " equipó: " + item);
    }

    @Override
    public String getItemEquipado() { return this.itemEquipado; }
}

class Mago extends Personaje implements Habilidoso, Sanador {
    private int manaMax;
    private int mana;

    public Mago(String nombre, int nivel) {
        super(nombre, nivel, 60 + (nivel * 5));
        this.manaMax = 80 + (nivel * 10);
        this.mana = this.manaMax;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (this.mana >= 20) {
            int dano = 25 + (this.nivel * 5);
            this.mana -= 20;
            System.out.println(this.nombre + " lanza un hechizo!");
            objetivo.recibirDano(dano);
        } else {
            System.out.println(this.nombre + ": maná insuficiente");
        }
    }

    @Override
    public String getTipoPersonaje() { return "Mago"; }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        if (this.mana >= 20) {
            this.mana -= 20;
            System.out.println(this.nombre + " lanza Bola de Fuego!");
            objetivo.recibirDano(40);
        } else {
            System.out.println(this.nombre + ": maná insuficiente para Bola de Fuego.");
        }
    }

    @Override
    public int getCostoHabilidad() { return 20; }

    @Override
    public String getNombreHabilidad() { return "Bola de Fuego"; }

    @Override
    public void sanar(Personaje objetivo) {
        // En Java, las subclases en el mismo archivo/paquete pueden acceder a atributos protected directamente
        objetivo.puntosVida += 25;
        if (objetivo.puntosVida > objetivo.puntosVidaMax) {
            objetivo.puntosVida = objetivo.puntosVidaMax;
        }
        System.out.println(this.nombre + " sana a " + objetivo.nombre + " por 25 HP.");
    }

    @Override
    public int getPotenciaSanacion() { return 25; }
}

class Arquero extends Personaje implements Equipable {
    private int flechas;
    private String itemEquipado;

    public Arquero(String nombre, int nivel) {
        super(nombre, nivel, 75 + (nivel * 7));
        this.flechas = 10 + (nivel * 2);
        this.itemEquipado = "Arco basico";
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (this.flechas > 0) {
            int dano = 12 + (this.nivel * 4);
            if (!this.itemEquipado.equals("Arco basico")) {
                dano += 5;
            }
            this.flechas--;
            System.out.println(this.nombre + " dispara una flecha!");
            objetivo.recibirDano(dano);
        } else {
            System.out.println(this.nombre + " no tiene flechas para atacar.");
        }
    }

    @Override
    public String getTipoPersonaje() { return "Arquero"; }

    @Override
    public void equiparItem(String item) {
        this.itemEquipado = item;
        System.out.println(this.nombre + " equipó: " + item);
    }

    @Override
    public String getItemEquipado() { return this.itemEquipado; }
}

// 4. BATALLA COMPLETA
public class Main {
    public static void main(String[] args) {
        List<Personaje> heroes = new ArrayList<>();
        heroes.add(new Guerrero("Thorin", 3));
        heroes.add(new Mago("Gandalf", 5));
        heroes.add(new Arquero("Legolas", 4));

        Personaje orco = new Guerrero("Orco", 1);
        int turno = 1;

        System.out.println("=== FASE 1: EQUIPAR ===");
        ((Equipable) heroes.get(0)).equiparItem("Espada Legendaria");
        ((Equipable) heroes.get(2)).equiparItem("Arco Elfico");

        System.out.println("\n=== FASE 2: BATALLA ===");
        while (orco.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            for (Personaje h : heroes) {
                if (!orco.estaVivo()) break;
                
                if (turno == 2 && h instanceof Habilidoso) {
                    ((Habilidoso) h).usarHabilidadEspecial(orco);
                } else {
                    h.atacar(orco);
                }
            }
            turno++;
        }

        System.out.println("\n=== FASE 3: SANACIÓN POST BATALLA ===");
        for (Personaje h : heroes) {
            if (h instanceof Sanador) {
                h.sanar(heroes.get(0));
            }
        }

        System.out.println("\n=== ESTADO FINAL ===");
        for (Personaje h : heroes) {
            System.out.println(h.toString());
        }
        System.out.println(orco.toString());
    }
}