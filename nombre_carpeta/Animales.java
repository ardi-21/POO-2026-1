// ─── 1. Perro ───────────────────────────────────────────
class Perro extends Animal {
    Perro() { super("Perro"); }
 
    @Override
    void sonido()   { System.out.println("🐶 El perro ladra: ¡Guau guau!"); }
 
    @Override
    void moverse()  { System.out.println("🐶 El perro corre y mueve la cola."); }
 
    @Override
    void comer()    { System.out.println("🐶 El perro come croquetas."); }
}
 
// ─── 2. Gato ────────────────────────────────────────────
class Gato extends Animal {
    Gato() { super("Gato"); }
 
    @Override
    void sonido()   { System.out.println("🐱 El gato maúlla: ¡Miau!"); }
 
    @Override
    void moverse()  { System.out.println("🐱 El gato salta sigilosamente."); }
 
    @Override
    void comer()    { System.out.println("🐱 El gato come pescado."); }
}
 
// ─── 3. Pájaro ──────────────────────────────────────────
class Pajaro extends Animal {
    Pajaro() { super("Pájaro"); }
 
    @Override
    void sonido()   { System.out.println("🐦 El pájaro canta: ¡Pío pío!"); }
 
    @Override
    void moverse()  { System.out.println("🐦 El pájaro vuela entre los árboles."); }
 
    @Override
    void comer()    { System.out.println("🐦 El pájaro come semillas."); }
}
 
// ─── 4. Vaca ────────────────────────────────────────────
class Vaca extends Animal {
    Vaca() { super("Vaca"); }
 
    @Override
    void sonido()   { System.out.println("🐄 La vaca muge: ¡Muuu!"); }
 
    @Override
    void moverse()  { System.out.println("🐄 La vaca camina lentamente por el prado."); }
 
    @Override
    void comer()    { System.out.println("🐄 La vaca pasta hierba."); }
}
 
// ─── 5. Serpiente ───────────────────────────────────────
class Serpiente extends Animal {
    Serpiente() { super("Serpiente"); }
 
    @Override
    void sonido()   { System.out.println("🐍 La serpiente sisea: ¡Ssss!"); }
 
    @Override
    void moverse()  { System.out.println("🐍 La serpiente se arrastra por el suelo."); }
 
    @Override
    void comer()    { System.out.println("🐍 La serpiente se traga un ratón entero."); }
}
 
// ─── Main ───────────────────────────────────────────────
public class Main {
    public static void main(String[] args) {
 
        Animal[] animales = { new Perro(), new Gato(), new Pajaro(), new Vaca(), new Serpiente() };
 
        for (Animal a : animales) {
            System.out.println("\n═══ " + a.nombre.toUpperCase() + " ═══");
            a.sonido();
            a.moverse();
            a.comer();
        }
    }
}
