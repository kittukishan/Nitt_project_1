package site.demo.service;

import java.util.List;

import site.demo.model.Categories;

public interface Categoryserviceint {

	void addcategory(Categories cats);
	void modifycategory(Categories id_);
	
	void removecategory(Categories cat);
	public List<Categories> getcategories();
	public Categories getcategories(String id);
}
