package com.maryanto.dimas.training.bni.controller;

import com.maryanto.dimas.training.bni.model.Kota;
import com.maryanto.dimas.training.bni.repository.KotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kota/v1")
public class KotaController {

    private KotaRepository kotaRepo;

    @Autowired
    public KotaController(KotaRepository kotaRepo) {
        this.kotaRepo = kotaRepo;
    }

    @GetMapping("/list")
    public List<Kota> findAll() {
        return this.kotaRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        Optional<Kota> optional = this.kotaRepo.findById(id);
        if (optional.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(optional.get());
    }


}
