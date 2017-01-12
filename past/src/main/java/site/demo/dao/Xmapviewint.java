package site.demo.dao;

import java.util.List;


import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;

public interface Xmapviewint {
	List<Xmapview> getproductsbysupp(String supplier);
	List<Xmapview> getproductsbycat(String category);
	public List<Xmapview> getviewbyid(String xid);
	public List<Xmapview> getviewbyxid(String xid);

	List<Xmapview> getxmapproducts();
	
	
}
