package org.example;

import java.util.*;

public class PokemonAnalyzer {
    private List<Pokemon> pokemons;

    public PokemonAnalyzer(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getTotalPokemon() {
        return pokemons.size();
    }

    public double getNivelMedio() {
        return pokemons.stream().mapToInt(Pokemon::getNivel).average().orElse(0.0);
    }

    public double getPsMedios() {
        return pokemons.stream().mapToInt(Pokemon::getPs).average().orElse(0.0);
    }

    public Pokemon getPokemonMayorNivel() {
        return pokemons.stream().max(Comparator.comparingInt(Pokemon::getNivel)).orElse(null);
    }

    public Pokemon getPokemonMayorPs() {
        return pokemons.stream().max(Comparator.comparingInt(Pokemon::getPs)).orElse(null);
    }

    public Map<String, List<Pokemon>> agruparPorTipo() {
        Map<String, List<Pokemon>> mapa = new TreeMap<>();
        for (Pokemon p : pokemons) {
            mapa.computeIfAbsent(p.getTipo().toUpperCase(), k -> new ArrayList<>()).add(p);
        }
        return mapa;
    }
}
