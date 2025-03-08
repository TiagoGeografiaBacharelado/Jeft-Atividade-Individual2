package com.example.atividade_lanche02.services;

import com.example.atividade_lanche02.entities.Lanche;
import com.example.atividade_lanche02.repositories.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LancheService {
    @Autowired
    private LancheRepository lancheRepository;

    public Lanche atualizarLanche(Long id, Lanche novoLanche) {
        return lancheRepository.findById(id).map(lanche -> {
            lanche.setNome(novoLanche.getNome());
            lanche.setPreco(novoLanche.getPreco());
            lanche.setQuantidade(novoLanche.getQuantidade());
            return lancheRepository.save(lanche);
        }).orElseThrow(() -> new RuntimeException("Lanche não encontrado"));
    }

    public void removerLanche(Long id) {
        if (!lancheRepository.existsById(id)) {
            throw new RuntimeException("Lanche não encontrado");
        }
        lancheRepository.deleteById(id);
    }

    public Lanche comprarLanche(Long id) {
        Optional<Lanche> lancheOpt = lancheRepository.findById(id);
        if (lancheOpt.isPresent()) {
            Lanche lanche = lancheOpt.get();
            if (lanche.getQuantidade() > 0) {
                lanche.setQuantidade(lanche.getQuantidade() - 1);
                return lancheRepository.save(lanche);
            } else {
                throw new RuntimeException("Lanche esgotado");
            }
        } else {
            throw new RuntimeException("Lanche não encontrado");
        }
    }
}
