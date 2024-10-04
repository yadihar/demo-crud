package com.example2.demo_crud.models;

import jakarta.persistence.*;

@Entity
public class Barang {

private Long id;
private String nama;
private float harga;

	
public Barang(){ }

protected Barang(Long id, String nama,float harga) {
   super();
    this.id=id;
    this.nama=nama;
    this.harga=harga;
}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNama() {
    return nama;
}

public void setNama(String nama) {
    this.nama = nama;

}

public float getHarga() {
    return harga;

}
public void setHarga(float harga) {
    this.harga = harga;

}
}