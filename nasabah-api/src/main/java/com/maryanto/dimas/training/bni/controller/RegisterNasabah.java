package com.maryanto.dimas.training.bni.controller;

import com.maryanto.dimas.training.bni.dto.RegisterNasabahDTO;
import com.maryanto.dimas.training.bni.model.Kota;
import com.maryanto.dimas.training.bni.model.Nasabah;
import com.maryanto.dimas.training.bni.service.WilayahApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/nasabah/register/v1")
public class RegisterNasabah {

    private WilayahApiService service;

    public RegisterNasabah(WilayahApiService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> regiter(
            @RequestBody RegisterNasabahDTO.NewNasabah dto) {
        Optional<Kota> optionalKota = this.service.findKotaById(dto.getKotaId());

        if (optionalKota.isEmpty())
            return ResponseEntity.badRequest().body("field kota not found!");

        Nasabah nasabah = new Nasabah(UUID.randomUUID().toString(), "0001", dto.getNamaLengkap(), BigDecimal.ZERO, optionalKota.get());
        return ResponseEntity.ok(nasabah);
    }
}
