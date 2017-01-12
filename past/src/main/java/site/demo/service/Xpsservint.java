package site.demo.service;

import java.util.List;

import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;

public interface Xpsservint {

	List<Xmapview> getproductsbysupp(String supplier);
	List<Xmapview> getproductsbycat(String category);
	List<Xmapview> getxmapproducts();
	public List<Xmapview> getviewbyid(String xid);
	public List<Xmapview> getviewbyxid(String xid);

	
	List<Xmap_pro_supp> getallproducts();	
	void addproduct(Xmap_pro_supp product);
	void removeproduct(String xid);
	void updateproduct(Xmap_pro_supp product);
	List<Xmap_pro_supp> getproductsbyid(String xid);
	
}
