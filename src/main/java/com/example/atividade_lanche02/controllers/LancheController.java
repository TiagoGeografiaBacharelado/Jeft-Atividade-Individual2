package com.example.atividade_lanche02.controllers;

import com.example.atividade_lanche02.entities.Lanche;
import com.example.atividade_lanche02.services.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lanche")
public class LancheController {
    @Autowired
    private LancheService lancheService;

    @PutMapping("/{id}")
    public ResponseEntity<Lanche> atualizarLanche(@PathVariable Long id, @RequestBody Lanche novoLanche) {
        Lanche lancheAtualizado = lancheService.atualizarLanche(id, novoLanche);
        return ResponseEntity.ok(lancheAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLanche(@PathVariable Long id) {
        lancheService.removerLanche(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/comprar/{id}")
    public ResponseEntity<Lanche> comprarLanche(@PathVariable Long id) {
        Lanche lancheComprado = lancheService.comprarLanche(id);
        return ResponseEntity.ok(lancheComprado);
    }
}
