package site.demo.dao;

import java.util.List;

import site.demo.model.Review;

public interface Reviewdaoint {

	public List<Review> getreviewsbycustomer(String customer);
	public List<Review> getreviewbyxid(String xid);
	public void addreview(Review data);
	
}
