package org.example;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    public static void generarInforme(PokemonAnalyzer analyzer, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("=========================");
            writer.println(" INFORME DE POKÉMON");
            writer.println("=========================");
            writer.println();
            writer.println("Total de Pokémon: " + analyzer.getTotalPokemon());
            writer.println();
            writer.printf("Nivel medio: %.2f%n", analyzer.getNivelMedio());
            writer.println();
            writer.printf("PS medios: %.2f%n", analyzer.getPsMedios());
            writer.println();

            Pokemon maxNivel = analyzer.getPokemonMayorNivel();
            if (maxNivel != null) {
                writer.println("Pokémon con mayor nivel:");
                writer.println(maxNivel.getNombre() + " (Nivel " + maxNivel.getNivel() + ")");
                writer.println();
            }

            Pokemon maxPs = analyzer.getPokemonMayorPs();
            if (maxPs != null) {
                writer.println("Pokémon con más PS:");
                writer.println(maxPs.getNombre() + " (PS " + maxPs.getPs() + ")");
                writer.println();
            }

            writer.println("-------------------------");
            writer.println("POKÉMON POR TIPO");
            writer.println("-------------------------");
            writer.println();

            Map<String, List<Pokemon>> porTipo = analyzer.agruparPorTipo();
            for (Map.Entry<String, List<Pokemon>> entry : porTipo.entrySet()) {
                String tipo = entry.getKey();
                List<Pokemon> lista = entry.getValue();
                writer.println(tipo + ": " + lista.size());
                for (Pokemon p : lista) {
                    writer.println(p.getNombre());
                }
                writer.println();
            }

            System.out.println("¡Informe generado con éxito en '" + nombreArchivo + "'!");

        } catch (Exception e) {
            System.err.println("Error al escribir el informe: " + e.getMessage());
        }
    }
}