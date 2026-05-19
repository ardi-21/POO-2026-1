#include <iostream>
#include <string>

class Persona {
private:
    std::string nombre;
    int edad;

public:
    // Constructor
    Persona(std::string n, int e) {
        nombre = n;
        edad = e;
    }

    // Método
    void saludar() {
        std::cout << "Hola, soy " << nombre << " y tengo " << edad << " años." << std::endl;
    }
};

int main() {
    Persona persona1("Carlos", 20);
    persona1.saludar();
    return 0;
}