package site.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.demo.dao.Xmapviewint;
import site.demo.dao.Xpsdaoint;
import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;
@Service
public class Xpsservclass implements Xpsservint {

	@Autowired
	Xpsdaoint xpsdao;
	@Autowired
	Xmapviewint xmpvdao;

	

	public List<Xmap_pro_supp> getallproducts() {
		List<Xmap_pro_supp> list=xpsdao.getallproducts();
		return list;
	}

	
	public void addproduct(Xmap_pro_supp product) {
		xpsdao.addproduct(product);
		
	}

	public List<Xmap_pro_supp> getproductsbyid(String xid) {
		List<Xmap_pro_supp> list=xpsdao.getproductsbyid(xid);
		return list;
	}

	public void removeproduct(String xid) {
		xpsdao.removeproduct(xid);
		
	}
	public void removexmapproduct(String xid) {
		xpsdao.removeproduct(xid);
		
	}

	public void updateproduct(Xmap_pro_supp product) {
		xpsdao.updateproduct(product);
		
	}
	
	
	public List<Xmapview> getproductsbysupp(String supp) {
		List<Xmapview> list=xmpvdao.getproductsbysupp(supp);
				return list;
	}

	public List<Xmapview> getproductsbycat(String cat) {
		List<Xmapview> list=xmpvdao.getproductsbycat(cat);
		return list;
	}

	public List<Xmapview> getviewbyid(String xid) {
		List<Xmapview> list=xmpvdao.getviewbyid(xid);
		return list;
	}


	public List<Xmapview> getxmapproducts() {
		List<Xmapview> list=xmpvdao.getxmapproducts();
		return list;
	}


	public List<Xmapview> getviewbyxid(String xid) {
		List<Xmapview> list=xmpvdao.getviewbyxid(xid);
		return list;
	}
}
