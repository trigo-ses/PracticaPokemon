package org.example;

import java.util.List;

public class Main {
     static void main(String[] args) {
        String rutaJson = "pokemon.json";

        // 1. Cargar datos de forma nativa
        List<Pokemon> listaPokemons = FileService.cargarJSON(rutaJson);

        if (listaPokemons != null && !listaPokemons.isEmpty()) {
            // 2. Analizar datos
            PokemonAnalyzer analyzer = new PokemonAnalyzer(listaPokemons);

            // 3. Generar informe de texto
            ReportGenerator.generarInforme(analyzer, "informe_pokemon.txt");
        } else {
            System.out.println("No se pudieron cargar los datos o la lista está vacía.");
        }
    }
}
