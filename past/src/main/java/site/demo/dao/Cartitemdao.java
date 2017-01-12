package site.demo.dao;


import java.io.IOException;
import java.util.List;

import site.demo.model.Cartitem;
import site.demo.model.Customer;
import site.demo.model.Xmapview;


public interface Cartitemdao {
	
public abstract void addcartitem(Customer customer,Xmapview data,int quantity);
public abstract List<Cartitem> getitemsbycustomer(String customer);
public abstract int getcountitemsbycustomer(String customer);
public abstract void removecartitem(String cartitem);
public abstract void clearcartitems(String customerid);
public Customer validate(String customerid) throws IOException;
}
