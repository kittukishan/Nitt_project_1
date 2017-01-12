package site.demo.dao;

import java.util.List;


import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;

public interface Xpsdaoint {

	
	List<Xmap_pro_supp> getallproducts();
	
	
public List<Xmap_pro_supp> getproductsbyid(String xid);
	void addproduct(Xmap_pro_supp product);
	void removeproduct(String xid);
	void updateproduct(Xmap_pro_supp product);
	public List<String> getprdid();
	public List<String> getcatid();
	public List<String> getsuppid();
	
	
	
	/*-----------------------*/
	public List<Xmap_pro_supp> getxmapproducts();
}
