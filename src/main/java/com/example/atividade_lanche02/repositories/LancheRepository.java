package com.example.atividade_lanche02.repositories;


import java.util.ArrayList;
import java.util.List;

import com.example.atividade_lanche02.entities.Lanche;

public class LancheRepository {
    private List<Lanche> lanches = new ArrayList<>();

    public Lanche searchByCode(int code){
        Lanche lanche = lanches
            .stream()
            .filter(p -> p.getCodigo() == code)
            .findFirst()
            .get();
        
        return lanche;
    }

    public List<Lanche> buscar(){
        return lanches;
    }

    public void addLanches(Lanche lanche) {
        lanches.add(lanche);
    }

    public void removeLanche(int code){
        lanches.removeIf(p -> p.getCodigo() == code);
    }

    public void updateLanche(int code, Lanche lanche){
        Lanche LancheInMemory = this.searchByCode(code);

        LancheInMemory.setNome(lanche.getNome());
        LancheInMemory.setImg_url(lanche.getImg_url());
        LancheInMemory.setPreco(lanche.getPreco());
    }

    public boolean estaVazio(){
        return lanches.isEmpty();
    }
}
