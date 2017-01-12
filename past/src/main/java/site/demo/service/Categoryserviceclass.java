package site.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.demo.dao.Categorydao;
import site.demo.model.Categories;
@Service
public class Categoryserviceclass implements Categoryserviceint {
@Autowired
Categorydao categorydao;
	public void addcategory(Categories cats) {
		categorydao.addcategory(cats);

	}


	public void modifycategory(Categories id) {
		categorydao.modifycategory(id);
	}

	public void removecategory(Categories cat) {
		categorydao.removecategory(cat);

	}

	public List<Categories> getcategories() {
		List<Categories> data=categorydao.getcategories();
		return data;
	}

	public Categories getcategories(String id) {
		Categories data=categorydao.getcategories(id);		
		return data;
	}

}
