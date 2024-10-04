package com.example2.demo_crud.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
import com.example2.demo_crud.models.Barang;
public interface BarangRepository extends JpaRepository<Barang,Long>{

    @Query("Select b FROM Barang b WHERE CONCAT(b.nama, ' ', b.harga) LIKE %?1%")
	
	public List<Barang> search(String keyword);
}

