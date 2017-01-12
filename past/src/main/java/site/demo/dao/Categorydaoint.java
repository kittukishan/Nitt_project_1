package site.demo.dao;

import java.util.List;

import site.demo.model.Categories;


public interface Categorydaoint {
	void addcategory(Categories cats);
	void modifycategory(Categories data_);
	void removecategory(Categories cat);
	public List<Categories> getcategories();
	public Categories getcategories(String id);
}
