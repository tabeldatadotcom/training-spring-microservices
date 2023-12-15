package com.maryanto.dimas.training.bni.repository;

import com.maryanto.dimas.training.bni.model.Kota;
import com.maryanto.dimas.training.bni.model.Provinsi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class KotaRepository {

    private List<Kota> list = new ArrayList<>();

    public KotaRepository() {
        Provinsi jabar = new Provinsi("002", "Jawa Barat", "");
        Provinsi jakarta = new Provinsi("001", "DKI Jakarta", "");

        this.list.add(new Kota("001", "Bandung", jabar, ""));
        this.list.add(new Kota("002", "Jakarta Selatan", jakarta, ""));
        this.list.add(new Kota("003", "Jakarta Timur", jakarta, ""));
    }

    public List<Kota> findAll() {
        return this.list;
    }

    public Optional<Kota> findById(String id){
       return this.list.stream()
               .filter(data -> data.getId().equalsIgnoreCase(id))
               .findFirst();
    }
}
