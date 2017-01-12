package site.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.demo.dao.Customerdaoint;
import site.demo.dao.Reviewdaoint;
import site.demo.model.Cartitem;
import site.demo.model.Customer;
import site.demo.model.Review;
import site.demo.model.Users;
import site.demo.model.Xmapview;
import site.demo.service.Xpsservint;

@Controller
public class Productcontroller {
	@Autowired
	Xpsservint xpsserv;
	@Autowired
	Reviewdaoint review;
	@Autowired
	Customerdaoint cust;
	
	@RequestMapping("/viewcartitem")
	public ModelAndView Usercart(@RequestParam("cid") String xid,@ModelAttribute("review1")Review form) 
	{
		System.out.print("\nusercart");
		Xmapview data=xpsserv.getviewbyxid(xid).get(0);
		List<Review> reviewdata=review.getreviewbyxid(xid);
		ModelAndView mv=new ModelAndView("user/productdetails");
		System.out.println("xiddata1"+data.product_id);
		System.out.println("review1"+reviewdata);

		if(reviewdata==null||reviewdata.isEmpty()==true){
			System.out.println("\nif failed...");
			mv.addObject("xiddata", data);
			//mv.addObject("review",new Review());
		}
		else{
			Review data1 = reviewdata.get(0);
		System.out.println("xiddata2"+data.product_id);
		System.out.println("review2"+reviewdata.get(0).getReview());  
		mv.addObject("xiddata", data);
		mv.addObject("review",reviewdata);
	//System.out.println("\n"+reviewdata.getReview());
		}
	
		return mv;
		
	}
	@RequestMapping("/Addreview/{xid}")
	public String addreview(@PathVariable("xid") String xid,@ModelAttribute("review1")Review form,Principal prp,RedirectAttributes rm)
	{
		System.out.print("\nreview entered");
	Customer customer=cust.getdatabyuser(prp.getName());
		form.setXmapview(xid);
		form.setCustomerid(customer);
		review.addreview(form);
		System.out.print("\nreview dao entered");

		System.out.println("xiddata data"+form.getReview());
		rm.addAttribute("cid",xid);

		return "redirect:/viewcartitem";
		
	}
	
}
