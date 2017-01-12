package site.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.demo.dao.Supplierdaoint;
import site.demo.model.Supplier;
@Service
public class Supplierservice implements Supplierserviceint {

	
	@Autowired
	Supplierdaoint sdao;
	public void addsupplier(Supplier supplier) {
		sdao.addsupplier(supplier);
		
	}

	public List<Supplier> showall() {
		List<Supplier>suppserv=sdao.showall();
		return suppserv ;
	}

	public Supplier showbyid(String suppid) {
		Supplier suppiddata=sdao.showbyid(suppid);
		return suppiddata;
	}

	public void updatesupplier(Supplier supplier) {
		sdao.updatesupplier(supplier);
		
	}

	public void removesupplier(String suppid) {
		sdao.removesupplier(suppid);
		
	}

}
