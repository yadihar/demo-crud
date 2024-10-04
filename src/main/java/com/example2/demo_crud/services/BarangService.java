package com.example2.demo_crud.services;

import java.util.List;
import com.example2.demo_crud.models.Barang;
import com.example2.demo_crud.repositoris.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BarangService{

    @Autowired
	private BarangRepository repo;
		
	public List<Barang> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public List<Barang> listAll() {

		return repo.findAll();
	}

	public void save(Barang barang) {
		repo.save(barang);
	}
	
	public Barang get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

}