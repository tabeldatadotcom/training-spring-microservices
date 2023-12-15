package com.maryanto.dimas.training.bni.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nasabah {

    private String id;
    private String cif;
    private String namaLengkap;
    private BigDecimal saldo;
    private Kota kota;
}
