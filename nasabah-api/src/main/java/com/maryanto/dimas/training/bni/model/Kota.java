package com.maryanto.dimas.training.bni.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Kota {

    private String id;
    private String nama;
    private Provinsi provinsi;
    private String description;
}
