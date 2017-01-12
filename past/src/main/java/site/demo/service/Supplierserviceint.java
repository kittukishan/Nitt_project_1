package site.demo.service;

import java.util.List;

import site.demo.model.Supplier;

public interface Supplierserviceint {

	void addsupplier(Supplier supplier);
	 List<Supplier> showall();
	Supplier showbyid(String suppid);
	void updatesupplier(Supplier supplier);
	 void removesupplier(String suppid);
	
}
