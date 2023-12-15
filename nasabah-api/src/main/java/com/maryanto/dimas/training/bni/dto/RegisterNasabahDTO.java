package com.maryanto.dimas.training.bni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RegisterNasabahDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NewNasabah{

        private String namaLengkap;
        private String kotaId;
    }
}
