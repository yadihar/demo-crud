package com.example2.demo_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import com.example2.demo_crud.models.Barang;
import com.example2.demo_crud.services.BarangService;

@Controller
public class BarangController {

	@Autowired
	private BarangService barangService;

    public BarangController(){}

	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		
		List<Barang> listBarang = barangService.listAll(keyword);
		model.addAttribute("listBarang", listBarang);
		model.addAttribute("keyword", keyword);
		
		 return "barang";
	}

    @RequestMapping(value="/barang")    
    public String index(Model model){
        		
		List<Barang> listBarang= barangService.listAll();
		model.addAttribute("listBarang", listBarang);
		
		 return "barang";

    }

	@RequestMapping("/barang/new")
	public String showNewBarangPage(Model model) {
		
		Barang barang = new Barang();
		model.addAttribute("barang", barang);
			
		return "new_barang";
	}

	@RequestMapping(value = "barang/barang/save", method = RequestMethod.POST)
	public String saveBarang(@ModelAttribute("barang") Barang barang) {
		barangService.save(barang);
		
		return "redirect:/barang";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditBarangPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_barang");
		Barang barang = barangService.get(id);
		mav.addObject("barang", barang);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBarang(@PathVariable(name = "id") int id) {
		barangService.delete(id);
		return "redirect:/barang";		
	}

}



	

	
	

	
	


