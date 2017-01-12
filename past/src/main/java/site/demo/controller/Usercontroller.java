package site.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import site.demo.dao.Cartitemdao;
import site.demo.dao.Customerdaoint;
import site.demo.model.Cartitem;
import site.demo.model.Customer;

import site.demo.model.Users;
import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;

import site.demo.service.Userserviceint;
import site.demo.service.Xpsservint;

@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class Usercontroller {
	@Autowired
	Xpsservint xmap;
	@Autowired
	Userserviceint userv;
	@Autowired
	Customerdaoint customer;
	@Autowired
	Cartitemdao cart;
	
	
	/*@RequestMapping(value={"/userpage-req"})
	public ModelAndView profilepagereq(Model model){
		System.out.println("my admin hungry req sent");
		ModelAndView mv=new ModelAndView("/hungry");

		try {
			List<Xmapview> data = xmap.getxmapproducts();
			System.out.println("\ndata "+data);
						mv.addObject("products",data);
			}
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("\n......"+e);
		}
		
		System.out.println("......");
		return mv;
	}	*/
	@RequestMapping(value={"userprofile-req","adminprofile-req"})
	public ModelAndView editprofile(Principal prip){
		System.out.println("my profile req sent");
		Users userdata=userv.getUserById(prip.getName()).get(0);
		System.out.println("user data1: "+userdata.getMobile()+userdata.getPassword());
		ModelAndView mv=new ModelAndView("/user/profile");
		mv.addObject("users",userdata);
		return mv;
		}
	@RequestMapping(value={"update_profile"})
	public String updateuser(@ModelAttribute("users") Users user,Principal prip) {
		System.out.println("userdata"+user.getAuthorities()+user.getName());
		Users userdata=userv.getUserById(prip.getName()).get(0);
	user.setAuthorities(userdata.getAuthorities());
	user.setStatus(userdata.isStatus());
		userv.updateData(user);
		
		return "redirect:/login-fail";
	}
	/*@RequestMapping(value={"admin_profile"})
	public String updateuserdata(@ModelAttribute("users") Users user) 
	{
		userv.updateData(user);
		
		return "redirect:/userpage-req";
	}
	*/
	@RequestMapping("allsuppdata")
	public ModelAndView allsuppliers(@RequestParam("cid")String pid){
		System.out.println("AlL supp req sent");
		List<Xmapview> allsuppdata=xmap.getviewbyid(pid);
		System.out.println("all supp data: "+allsuppdata.get(0).product_name);
		ModelAndView mv=new ModelAndView("user/productdetails");
		mv.addObject("allsuppdata",allsuppdata);
		mv.addObject("id", pid);
		
		return mv;
		
	}
	
	
	
	String Message;
	@RequestMapping("Addingtocartreq/{psid}")
	public ModelAndView addtocart(@PathVariable("psid")String pid,@RequestParam("qnty") String qty,Model model){
		System.out.println("\nadd to cart");
		System.out.println("\nadd to cart psid: "+pid);
		System.out.println("\nadd to cart qnty: "+qty);
		Xmapview allsuppdata;
		ModelAndView mv;
		String s1;
		User user;
		String username;
		try {
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			username = user.getUsername().toString();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			mv= new ModelAndView("redirect:/login-req");
			return mv;
		}

		System.out.println(username);

		/*if(username.isEmpty()){
			mv= new ModelAndView("redirect:/login-req");
			return mv;}
		System.out.println(username);*/
		int qnty=Integer.parseInt(qty);
		try {
			allsuppdata = xmap.getviewbyxid(pid).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("status null: "+e);
			return new ModelAndView("redirect:/Hungry-req");
		}
		System.out.println("\nall supp data: "+allsuppdata.getCategory_type());
		if(customer.getdatabyuser(user.getUsername())==null){
			System.out.println("\n:customer data null: "+allsuppdata.product_name);
			Customer newcustomer=customer.addcustomerbyuser(username);
			cart.addcartitem(newcustomer,allsuppdata,qnty);
			System.out.println("new cust: "+newcustomer.customer_id);
		}
		else{
			Customer existingcustomer=customer.getdatabyuser(user.getUsername());
			cart.addcartitem(existingcustomer,allsuppdata,qnty);
		System.out.println("all supp data2: "+allsuppdata.product_name);
		System.out.println("new cust: "+existingcustomer.customer_id);
		success="Item added to: "+existingcustomer.getUsers().getName()+" Successfully";
		}
	return new ModelAndView("redirect:/Hungry-req");
	}
	String success=null;
	@RequestMapping("/cartsuccess")
	public @ResponseBody String getValues() 
	{
		System.out.print("\nGson");
	
		String success =this.success;
		System.out.println("\nvalue"+success);
		if(success==null)
			success="please add again-sorry for Inconvenience";
		Gson gson = new Gson();
		String prods=gson.toJson(success);	
		
		return prods;
	}
	
	
	@RequestMapping("/cartitemscount")
	public @ResponseBody String countOfCartart(Principal principal) 
	{
		System.out.print("\nGson");
	
		Customer customerdata;
		try {
			customerdata = customer.getdatabyuser(principal.getName());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception at cartcount");
			return null;
		}
		
		int cartcount=cart.getcountitemsbycustomer(customerdata.customer_id);
		System.out.println("\nvalue"+cartcount);
		Gson gson = new Gson();
		String prods=gson.toJson(cartcount);	
		
		return prods;
	}
	
	@RequestMapping("/usercart")
	public ModelAndView Usercart(Principal prip) 
	{
		System.out.print("\nusercart");
		Customer user=customer.getdatabyuser(prip.getName());
		ModelAndView mv=new ModelAndView("user/Mycart");
		List<Cartitem> usercart=cart.getitemsbycustomer(user.customer_id);
	
		//if(user.customer_id!=null|| !user.customer_id.isEmpty()){
		
	if(usercart.isEmpty()||usercart==null){
			String s="You have no items in your cart please add items to buy.";
			boolean s1=true;
			mv.addObject("val",s1);
			/*mv.addObject("customerid",user.customer_id);*/
			return mv;
	}
	else{
		mv.addObject("val",false);
		mv.addObject("usercart", usercart);
		mv.addObject("customerid",user.customer_id);
		
		return mv;
	}
	}
	@RequestMapping("/deleteitem")
	public String deleteusercartitem(@RequestParam("psid") String crtitem,Principal prip) 
	{
		System.out.print("\nusercart");
		cart.removecartitem(crtitem);
		ModelAndView mv=new ModelAndView("user/Mycart");
		
		return "redirect:usercart";
		
	}
	@RequestMapping("/clearcart/{psid}")
	public String clearcartt(@PathVariable("psid") String crtitem,Principal prip) 
	{
		System.out.print("\nclear cart");
		Customer user=customer.getdatabyuser(prip.getName());

		cart.clearcartitems(user.customer_id);
		ModelAndView mv=new ModelAndView("user/Mycart");
		return "redirect:usercart";
		
	}
	
	/*String Message1;
	@RequestMapping("Addingtocartreq1/{psid}")
	public ModelAndView addtocart1(@ModelAttribute("cartitem")Cartitem cartitem){
		System.out.println("\nadd to cart");
		System.out.println("\nadd to cart psid: "+cartitem.product_name);
		System.out.println("\nadd to cart qnty: "+cartitem.quantity);
		Xmapview allsuppdata;
		ModelAndView mv;
		String s1;
		User user;
		String qty;
		String username;
		String pid;
		try {
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			username = user.getUsername().toString();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			mv= new ModelAndView("redirect:/login-req");
			return mv;
		}

		System.out.println(username);

		if(username.isEmpty()){
			mv= new ModelAndView("redirect:/login-req");
			return mv;}
		System.out.println(username);
		int qnty=Integer.parseInt(qty);
		try {
			allsuppdata = xmap.getviewbyxid(pid).get(0);
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("status null: "+e);
			return new ModelAndView("redirect:/Hungry-req");
		}
		System.out.println("\nall supp data: "+allsuppdata.getCategory_type());
		if(customer.getdatabyuser(user.getUsername())==null){
			System.out.println("\n:customer data null: "+allsuppdata.product_name);
			Customer newcustomer=customer.addcustomerbyuser(username);
			cart.addcartitem(newcustomer,allsuppdata,qnty);
			System.out.println("new cust: "+newcustomer.customer_id);
		}
		else{
			Customer existingcustomer=customer.getdatabyuser(user.getUsername());
			cart.addcartitem(existingcustomer,allsuppdata,qnty);
		System.out.println("all supp data2: "+allsuppdata.product_name);
		System.out.println("new cust: "+existingcustomer.customer_id);
		success="Item added to: "+existingcustomer.getUsers().getName()+" Successfully";
		}
	return new ModelAndView("redirect:/Hungry-req");
	}*/
	
}
