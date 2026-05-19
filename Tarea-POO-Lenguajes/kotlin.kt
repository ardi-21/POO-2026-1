class Persona(private val nombre: String, private val edad: Int) {
    
    // Método
    fun saludar() {
        println("Hola, soy $nombre y tengo $edad años.")
    }
}

fun main() {
    val persona1 = Persona("Luis", 21)
    persona1.saludar()
}
