use std::io; // Importamos la biblioteca para leer datos del teclado

fn main() {
    println!("¡Hola! ¿Tienes alguna mascota? ¿Cómo se llama?");

    // Creamos una variable mutable para guardar la respuesta.
    // String::new() crea un texto vacío donde almacenaremos lo que el usuario escriba.
    let mut respuesta = String::new();

    // Aquí leemos lo que el usuario escribe en la consola
    io::stdin()
        .read_line(&mut respuesta)
        .expect("Error al leer la línea");

    // .trim() sirve para quitar el salto de línea (el "Enter") que se guarda al escribir
    println!("¡Qué genial! {} es un nombre increíble para una mascota.", respuesta.trim());
}
