using System;

public class Persona {
    private string nombre;
    private int edad;

    // Constructor
    public Persona(string nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método
    public void Saludar() {
        Console.WriteLine($"Hola, soy {nombre} y tengo {edad} años.");
    }
}

class Program {
    static void Main() {
        Persona persona1 = new Persona("Ana", 22);
        persona1.Saludar();
    }
}