package org.example;

import org.example.Pokemon;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<Pokemon> cargarJSON(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Pokemon> pokemons = new ArrayList<>();
        try {
            pokemons = mapper.readValue(new File(path), new TypeReference<List<Pokemon>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pokemons;
    }
}

