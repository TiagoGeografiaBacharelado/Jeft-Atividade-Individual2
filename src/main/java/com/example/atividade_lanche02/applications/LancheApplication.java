package com.example.atividade_lanche02.applications;


import java.util.List;

import com.example.atividade_lanche02.entities.Lanche;
import com.example.atividade_lanche02.repositories.LancheRepository;
import com.example.atividade_lanche02.services.LancheService;

public class LancheApplication {
    private LancheRepository lancheRepository;
    private LancheService lancheService;

    public LancheApplication(
        LancheRepository lancheRepository, 
        LancheService lancheService) {
        this.lancheRepository = lancheRepository;
        this.lancheService = lancheService;
    }

    public void cadastrar(Lanche lanche){
        lancheRepository.addLanches(lanche);
        lancheService.save(lanche);
        System.out.println(lancheService.save(lanche));
    }

    public void atualizar(int codigo, Lanche lanche){
        lancheRepository.updateLanche(codigo, lanche);
        lancheService.save(lanche);
    }

    public void remover(int codigo){
        Lanche lanche = lancheRepository.searchByCode(codigo);
        lancheRepository.removeLanche(codigo);
        lancheService.delete(lanche);
    }

    public List<Lanche> buscar(){
        return this.lancheRepository.buscar();
    }

    public Lanche buscarPorCodigo(int codigo){
        return this.lancheRepository.searchByCode(codigo);
    }

    public double calcularLanche(Lanche lanche, int quantidade){
        return lanche.getPreco() * quantidade;
    }

    public boolean estaVazio(){
        return lancheRepository.estaVazio();
    }
}
