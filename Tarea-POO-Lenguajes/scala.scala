class Persona(val nombre: String, val edad: Int) {
  
  // Método
  def saludar(): Unit = {
    println(s"Hola, soy $nombre y tengo $edad años.")
  }
}

object Main extends App {
  val persona1 = new Persona("Maria", 24)
  persona1.saludar()
}
