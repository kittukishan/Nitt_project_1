
package site.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken ;
import com.google.gson.JsonObject;

import site.demo.model.Categories;
import site.demo.model.Products;
import site.demo.model.Supplier;
import site.demo.model.Users;
import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;
import site.demo.service.Categoryserviceint;
import site.demo.service.Productserviceint;
import site.demo.service.Supplierserviceint;
import site.demo.service.Userserviceint;

import site.demo.service.Xpsservint;
import site.demo.dao.Xpsdaoint;
@Controller
@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
public class Admincontroller {
	
	@Autowired
	Productserviceint proserv;
	@Autowired
	Supplierserviceint suppserv;
	@Autowired
	Categoryserviceint catserv;
	@Autowired
	Userserviceint userserv;
	@Autowired
	Xpsservint xmap;
	@Autowired
	Xpsdaoint xpsdao;
	
	
	
	/*@RequestMapping(value={"/adminHungry-req"})
	public ModelAndView showallproducts(Model model){
		System.out.println("my admin hungry req sent");
		ModelAndView mv=new ModelAndView("admin/hungry");

		try {
			List<Xmapview> data = xmap.getxmapproducts();
			System.out.println("\ndata "+data);
						mv.addObject("xdata",data);
			}
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("\n......"+e);
		}
		
		System.out.println("......");
		return mv;
	}
	*/
	/*---------------------------------------product------------------------------------*/
	
	@RequestMapping(value="/admin_products_view",method ={ RequestMethod.GET,RequestMethod.POST})
	public ModelAndView adminproductsview(@ModelAttribute("products")Products admin_pro_view){		
		System.out.println("products viewing mapped");
		List<Products> product=proserv.showitems();
		ModelAndView mv1=new ModelAndView("admin/product");
				for(Products x:product){
					System.out.print("\n"+x.getItem_name()+"\t"+x.getStatus());
				//mv1.addObject("name",x.getItem_name());
				//mv1.addObject("desc",x.getDesc());
				//mv1.addObject("status",x.getStatus());
				}
				mv1.addObject("productdata", product);
		return mv1;
	}
	
	@RequestMapping(value="/admin_products_add",method ={ RequestMethod.GET,RequestMethod.POST})
	public String adminproductsadd(@ModelAttribute("products")Products admin_pro_add){
		System.out.println("\nproducts adding mapped");
		System.out.println("\nproducts adding mapped"+admin_pro_add.getImage());
			proserv.addproducts(admin_pro_add);
		/*List<Products> product=proserv.showitems();*/
		
				/*for(Products x:product){
					System.out.print("\n"+x.getItem_name()+"\t"+x.getStatus());
				//mv1.addObject("name",x.getItem_name());
				//mv1.addObject("desc",x.getDesc());
				//mv1.addObject("status",x.getStatus());
				}
				mv1.addObject("productdata", product);*/
		return "redirect:/admin_products_view";
	}
	
	@RequestMapping("admin_productedit")
	public ModelAndView updatedataproduct(@RequestParam("id") String proid){
		System.out.println("\n"+proid);
		 Products prod=proserv.getproductbyid(proid);
		 System.out.println("\n"+prod.getItem_id());
		ModelAndView mv=new ModelAndView("admin/editproduct");
		mv.addObject("proiddata", prod);
		
	return mv ;	
	}
	
	@RequestMapping("admin_productdelete")
	public String deleteproduct(@RequestParam("id") String proid){
		System.out.println("\n"+proid);
		 proserv.removeproduct(proid);
	return "redirect:/admin_products_view" ;	
	}
	
	@RequestMapping("admin_updateproduct")
	public String updateproduct(@ModelAttribute("product")Products product){
		System.out.println("\nproduct modifying");
		proserv.updateData(product);
		System.out.println("\nproduct modified");
		return "redirect:/admin_products_view";
	}
		/*---------------------------------------supplier------------------------------------*/
	
	
	@RequestMapping(value="admin_supplier_view", method ={ RequestMethod.GET,RequestMethod.POST})
	public ModelAndView adminsupplierview(@ModelAttribute("supplier")Supplier admin_supp_view){		
		System.out.println("supplier viewing mapped");
		List<Supplier> supp=suppserv.showall();
		ModelAndView mv1=new ModelAndView("admin/supplier");
				for(Supplier x:supp){
					System.out.print("\n"+x.getSupp_address()+"\t"+x.getSupp_status());
				
				}
				mv1.addObject("suppdata", supp);
		return mv1;
	}
	@RequestMapping(value="admin_supplier_add", method ={ RequestMethod.GET,RequestMethod.POST})
	public String adminsupplieradd(@ModelAttribute("supplier")Supplier admin_supp_add){
		System.out.println("\nsupplier adding mapped");
			suppserv.addsupplier(admin_supp_add);
		//ModelAndView mv1=new ModelAndView("/supplier_view");
		return "redirect:/admin_supplier_view";
	}
	
	@RequestMapping("admin_suppedit")
	public ModelAndView updatedatasupplier(@RequestParam("id") String suppid){
		System.out.println("\nsuppid retrieved"+suppid);
		 Supplier supp;
		 supp=suppserv.showbyid(suppid);
		ModelAndView mv=new ModelAndView("admin/editsupplier");
		System.out.println("\n supp data"+supp);
		mv.addObject("suppiddata", supp);
	//mv.addObject("suppiddata", supp);
		
	return mv ;	
	}
	
	@RequestMapping("/admin_updatesupplier")
	public String updatesupplier(@ModelAttribute("supplier")Supplier supplier){
		System.out.println("\nsupplier modifying");
		suppserv.updatesupplier(supplier);
		System.out.println("\ncategory modified");
		return "redirect:/admin_supplier_view";
	}
	
	/*@RequestMapping(value="/category_view",method ={ RequestMethod.GET,RequestMethod.POST})
	public ModelAndView admincategoryview(Model model,@ModelAttribute("category")Categories admin_cat_add){		
		System.out.println("\ncategory viewing mapped");
		List<Categories> cat=catserv.getcategories();
		ModelAndView mv1=new ModelAndView("admin/category");
		for(int x=0;x<cat.size();)
		{	
			model.addAttribute("catname", cat.get(x).getCat_name());
			System.out.println(cat.get(x).getCat_name());
			model.addAttribute("catdesc", cat.get(x).getCat_desc());
			System.out.println(cat.get(x).getCat_desc());
			model.addAttribute("catstatus", cat.get(x).getStatus());
			System.out.println(cat.get(x).getStatus());
			model.addAttribute("catid", cat.get(x).getCat_id());
			System.out.println(cat.get(x).getCat_id());
		x++;	
		}
		model.addAttribute("catdata", cat);
		
				for(Categories x:cat){
					System.out.print("\n"+x.getCat_desc()+"\t"+x.getCat_name());
				
				}
				mv1.addObject("catdata", cat);
		return mv1;
	}
*/	
	
	/*---------------------------------------category------------------------------------*/
	
	@RequestMapping(value="/admin_category_view")
	public ModelAndView admincategoryview(@ModelAttribute("category")Categories admin_cat_add){		
		System.out.println("\ncategory viewing mapped");
		List<Categories> cat=catserv.getcategories();
		List<String> category=new ArrayList<String>();
		List<String> status=new ArrayList<String>();
		System.out.println(cat);

		category.add("Starters");
		category.add("maincourse");
		category.add("pastries");
		category.add("fluids");
		status.add("available");
		status.add("Un-available");
		status.add("Ready to make");
		ModelAndView mv1=new ModelAndView("admin/category");
		mv1.addObject("catdata", cat);
		mv1.addObject("selectcategory", category);
		mv1.addObject("selectstatus", status);
		return mv1;
	}
	
	
	@RequestMapping(value="/admin_category_add",method ={ RequestMethod.GET,RequestMethod.POST})
	public String admincategoryadd(@ModelAttribute("category")Categories admin_cat_add){
		System.out.println("\ncategory adding mapped");
		System.out.println(admin_cat_add.getCat_name());
			catserv.addcategory(admin_cat_add);
			return "redirect:/admin_category_view";
	}
	
	/*@RequestMapping("/catedit")	/{catiddata}    value="catiddata"
	public ModelAndView updatecategory(@ModelAttribute("category")Categories catdata,@RequestParam("id")String catid){
		//catdata.setCat_id("catid");
		System.out.println("\nid:"+catid+"\n object: "+catdata);
		for(List<Categories> x:catdata)
		
			System.out.println(catdata.getCat_name());
			
		catserv.modifycategory(catdata);
		return null;"redirect:/category_view";
	}*/
	
	/*@RequestMapping("/catedit/{cat.cat_id}")	/{catiddata}    value="catiddata"
	public String updatecategory(@PathVariable("id") String id,Model model){
		//catdata.setCat_id("catid");
		System.out.println("\nid:"+id+"\n object: "+this.catserv.getcategories());
		model.addAttribute("catid",this.catserv.getcategories());
		System.out.println("\nid:"+id+"\n object: "+this.catserv.getcategories());
		
		
			//System.out.println(editcat.getCat_name());
			
		//catserv.modifycategory(catdata);
		return "redirect:/category_view";
	}*/
	
	@RequestMapping("admin_catedit")
	public ModelAndView updatedatacategory(@RequestParam("id") String catid){
		System.out.println(catid);
		
		//Categories ca1t=new Categories();
		 Categories cat=catserv.getcategories(catid);
		 //System.out.println("catdata"+cat.getCat_name());
		//model.addAttribute("categories",cat);
		ModelAndView mv=new ModelAndView("admin/editcategory");
	mv.addObject("catiddata", cat);
		/*mv.addObject("catid",cat.getCat_id());
		mv.addObject("catname",cat.getCat_name());
		mv.addObject("catdesc",cat.getCat_desc());
		mv.addObject("catstatus",cat.getStatus());*/
	return mv ;	
	}
	
	@RequestMapping("admin_updatecategory")
	public String updatecategory(@ModelAttribute("category")Categories category){
		System.out.println("\ncategory modifying");
		catserv.modifycategory(category);
		System.out.println("\ncategory modified");
				return "redirect:/admin_category_view";
	}

		
	/*	------------------------------------xmap------------------------------*/
	
	@RequestMapping("admin_xmap_view")
public ModelAndView xmapdataview(@ModelAttribute("xmap")Xmap_pro_supp xmapdata1){
	System.out.println("xmap controller entered");
	List<Xmap_pro_supp> xmapdata=xmap.getallproducts();
	List<String> proid=xpsdao.getprdid();
	List<String> supid=xpsdao.getsuppid();
	List<String> catid=xpsdao.getcatid();
	ModelAndView mv=new ModelAndView("admin/xmapview");
	mv.addObject("xmap", new Xmap_pro_supp());
	mv.addObject("value",xmapdata);
	mv.addObject("value1",proid);
	mv.addObject("value2", supid);
	mv.addObject("value3", catid);
	
			return mv;
}
	@RequestMapping("admin_xmap_add")
	public String xmapdataadd(@ModelAttribute("xmap")Xmap_pro_supp xmapdata){
		System.out.println("xmap controller entered");
		xmap.addproduct(xmapdata);
		
			return "redirect:/admin_xmap_view";
	}
	@RequestMapping("admin_xmap_delete")
	public String xmapdatadelete(@RequestParam("id") String xid){
		System.out.println("xmap controller entered");
		xmap.removeproduct(xid);
			return "redirect:/admin_xmap_view";
	}
	@RequestMapping("admin_xmap_update")
	public String xmapdataupdate(@ModelAttribute("xmap_pro_supp")Xmap_pro_supp xmapdata){
		System.out.println("xmap controller entered");
		xmap.updateproduct(xmapdata);
		
			return "redirect:/admin_xmap_view";
	}
	@RequestMapping("admin_xmap_edit")
	public ModelAndView xmapdataedit(@RequestParam("id") String xid){
		System.out.println("xmap controller entered");
		Xmap_pro_supp xmapdata=xmap.getproductsbyid(xid).get(0);
		List<String> proid=xpsdao.getprdid();
		List<String> supid=xpsdao.getsuppid();
		List<String> catid=xpsdao.getcatid();
		System.out.println("products: "+xmapdata);
		ModelAndView mv=new ModelAndView("admin/xmapedit");
		//mv.addObject("xmap",new Xmap_pro_supp());
		mv.addObject("xmap1",xmapdata);
		mv.addObject("value1",proid);
		mv.addObject("value2", supid);
		mv.addObject("value3", catid);
		/*for(Xmap_pro_supp x:xmapdata){
			System.out.println("\nproducts are\n"+x.getCat_id());
		}
		*/	return mv;
	}
	
	@RequestMapping("admin_xmapdelete")
	public String deletexmapproduct(@RequestParam("id") String proid){
		System.out.println("\n"+proid);
		 xmap.removeproduct(proid);
	return "redirect:/admin_products_view" ;	
	}
	/*---------------------------- Users -----------------------------------------*/
	/*ObjectMapper mapper = new ObjectMapper();
*/
	
	@RequestMapping("/showusersreq")
	public String userspage(){
		return "admin/users";
	}

	@RequestMapping("/showusers")
	public @ResponseBody String showusers() {
		System.out.println("users controller entered");
		List<Users> datas=userserv.getUsers();
	for(Users x:datas){
		x.setCustomer(null);
	}
		Gson gson = new Gson();
	
		System.out.println("\ngson");
		String prods=gson.toJson(datas);
		System.out.println("\ngson"+prods);
	return prods;
		
	}
	
}
