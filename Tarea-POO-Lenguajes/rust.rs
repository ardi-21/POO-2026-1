struct Persona {
    nombre: String,
    edad: u32,
}

impl Persona {
    // Constructor (por convención se llama 'new')
    fn new(nombre: &str, edad: u32) -> Persona {
        Persona {
            nombre: nombre.to_string(),
            edad,
        }
    }

    // Método
    fn saludar(&self) {
        println!("Hola, soy {} y tengo {} años.", self.nombre, self.edad);
    }
}

fn main() {
    let persona1 = Persona::new("David", 25);
    persona1.saludar();
}