package site.demo.dao;


import site.demo.model.Customer;

public interface Customerdaoint {

	public abstract Customer getdatabyuser(String user);
	public Customer addcustomerbyuser(String user);		//,Cart data
	
}
