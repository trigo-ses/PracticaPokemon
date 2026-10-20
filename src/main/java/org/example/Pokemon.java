package org.example;

public class Pokemon {
    private Integer id;
    private String nombre;
    private String tipo;
    private Integer nivel;
    private Integer ps;

    public Pokemon(Integer id, String nombre, String tipo, Integer nivel, Integer ps){
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.ps = ps;
    }
    public int getId() {
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public Integer getNivel(){
        return nivel;
    }
    public Integer getPs(){
        return ps;
    }


}
