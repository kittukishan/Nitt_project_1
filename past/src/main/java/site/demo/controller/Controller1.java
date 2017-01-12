package site.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import site.demo.model.Products;
import site.demo.model.Users;
import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;
import site.demo.service.Userserviceint;

import site.demo.service.Xpsservint;
import site.demo.service.EmailService;
import site.demo.service.Productserviceint;

@Controller

public class Controller1 {
	
	
	@Autowired
	Productserviceint Productserv;
	
	@Autowired
	Userserviceint userserv;

	@Autowired
	 EmailService emailService;
	
	

	@Autowired
	Xpsservint xpsserv;
	String username;
	
	Users u;
	
	
@RequestMapping(value={"/","/Home-req","/home"})
public String showhome(){
	System.out.println("my controller is running");
	return "Home";
}

@RequestMapping("/login-req")
public  ModelAndView  showlogin(){
	String reg_err="please Login";
	System.out.println("\nlogin request: ");
	 ModelAndView mv=new ModelAndView("Home");
	mv.addObject("err",reg_err);
	return mv;
}

@RequestMapping("/logout")
public String logout(HttpSession ses){
	return "redirect:/home";
}

@RequestMapping("/login-fail")
public ModelAndView loginfail(){
	System.out.println("my login failed req sent");
	ModelAndView mv=new ModelAndView("Home");
	 String reg_err="Login failed please Login again";
		mv.addObject("err",reg_err);

	return mv;
}
@RequestMapping("/register-req")
public String showregister(@ModelAttribute("users")Users users){
	System.out.println("my register req sent");
	return "register";
}
@RequestMapping(value={"/Hungry-req"})
public ModelAndView showallproducts(){
	System.out.println("my hungry req sent");
	List<Xmapview> data= xpsserv.getxmapproducts();
	ModelAndView mv=new ModelAndView("hungry");
	System.out.println("my dataa"+data);
	String s="please login to continue";
	mv.addObject("products",data);
	mv.addObject("login",s);
	/*for(Xmapview x:data){
		mv.addObject("products",x);
		System.out.println("ijfovij "+x);
	}
	*/
	System.out.println("......");
	return mv;
}
@RequestMapping("/Starters-req")
public ModelAndView showStarters(){
	System.out.println("my starters req sent");
	List<Xmapview> data= xpsserv.getproductsbycat("starter");
	ModelAndView mv=new ModelAndView("hungry");
	mv.addObject("products",data);
	for(Xmapview x:data)
	{
		System.out.println("/n"+x.getXid()+"//n"+x.getProduct_name());
		
	}
	System.out.println("");
	return mv;
}
@RequestMapping("/Main course-req")
public ModelAndView showmaincourse(){
	System.out.println("my maincourse req sent");
	List<Xmapview> data= xpsserv.getproductsbycat("main course");
	ModelAndView mv=new ModelAndView("hungry");
	mv.addObject("products",data);
	for(Xmapview x:data)
	{
		System.out.println("/n"+x.getXid()+"//n"+x.getProduct_name());
		
	}
	return mv;
}
@RequestMapping("/Desserts-req")
public ModelAndView showDesserts(){
	System.out.println("my desserts req sent");
	List<Xmapview> data= xpsserv.getproductsbycat("dessert");
	ModelAndView mv=new ModelAndView("hungry");
	mv.addObject("products",data);
	for(Xmapview x:data)
	{
		System.out.println("/n"+x.getXid()+"//n"+x.getProduct_name());
		
	}
	return mv;
}
@RequestMapping("/fluid-req")
public ModelAndView showFluids(){
	System.out.println("my fluids req sent");
	List<Xmapview> data= xpsserv.getproductsbycat("fluids");
	ModelAndView mv=new ModelAndView("hungry");
	mv.addObject("products",data);
	for(Xmapview x:data)
	{
		System.out.println("/n"+x.getXid()+"//n"+x.getProduct_name());
		
	}
	return mv;
}


@RequestMapping("/Aboutus-req")
public String showAbout(){
	System.out.println("my about req sent");
	return "aboutus";
}

/*@RequestMapping("/userpage-req")
public ModelAndView userPage(){
	System.out.println("my profile page req sent");
	ModelAndView mv1=new ModelAndView("/Home");
	mv1.addObject("name", username);
	return mv1;
}*/

@RequestMapping(value={"/adminpage-req"})
public String showadminhome(){
	System.out.println("my controller is running");
	return "admin/adminpage";
	
	}

	
					/* method used to convert in to text and display in products page*/

		@RequestMapping("/GsonCon")
		public @ResponseBody String getValues() 
		{
			System.out.print("\nGson");
			List<Xmap_pro_supp> data = xpsserv.getallproducts();
			for(Xmap_pro_supp pd : data){
				//System.out.print("\n"+pd.getProduct_id()+" " + pd.getCat_id() + " " + pd.getPrice());
			}		/*+ " " + pd.getPrice()+" "+pd.getOffer()*/
			Gson gson = new Gson();
			String prods=gson.toJson(data);	
			return prods;
		}
 
		/* method used to register user*/
/*		@RequestMapping(value="signUpDataUpdate", method = RequestMethod.POST)*/
		

		@RequestMapping("/reg_user")
		public ModelAndView regUser(@ModelAttribute("users")Users user_reg_details) throws MessagingException{
			String uname = user_reg_details.getName();
			String subject="Registration Success";
			ModelAndView mv;
			if(user_reg_details!=null){
				try{
					
					userserv.addUserDetails(user_reg_details);
				
				String body= "Dear " + uname +",\nWelcome to 4Foodies.com";
				body = body + "\n\nYou have been registered with us!! thank you\nYour Registered user name : "+uname+"\nUse this user name to login to our website";
				body = body + "\n\n\nRegards,\nFoodies Team\nDT5 - Hyderabad";
				emailService.send(user_reg_details, subject, body);

				return mv=new ModelAndView("login");
				}
			
			catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed"+e);
            String reg_err="registration failed please register again";
            mv=new ModelAndView("register");
            	mv.addObject("reg_error",reg_err);
			return mv;
			}}
			else{
				String reg_err="registration failed please register again";
            mv=new ModelAndView("register");
            	mv.addObject("reg_error",reg_err);
			return mv;
			}
		}
				
			/*String body= "Dear " + username +",\nWelcome to BuyToys.com";
			body = body + "\n\nYou have been registered with us!! thank you\nYour user id : "+uname+"\nUse this user id to login to our website";
			body = body + "\n\n\nRegards,\nFashion & the city Team\nDT5 - Secunderabad";
			emailService.send(user_reg_details, subject, body);
			
			 mv = new ModelAndView("login");
			//ud.setPassword("");
			String msg = "Signup is done..\nYour User id : ";// + uid;
			//mv.addObject("message", msg);
			return mv;
		}
*/
		
		/*@RequestMapping("/reg_user")
		public ModelAndView regUser(@ModelAttribute("users")Users user_reg_details){
			
			ModelAndView mv;
			if(user_reg_details!=null)
			try{userserv.addUserDetails(user_reg_details);
			String body= "Dear " + user_reg_details.getName()+",\nWelcome to 4Foodies.com";
			body = body + "\n\nYou have been registered with us!! thank you"
					+ "\nYour user id : \nUse this user id to login to our website";
			
			return mv=new ModelAndView("login");}
			
			catch (Exception e) {
            e.printStackTrace();
            String reg_err="registration failed please register again";
            mv=new ModelAndView("register");
            	mv.addObject("reg_error",reg_err);
			return mv;
			}
			else{
				String reg_err="registration failed please register again";
            mv=new ModelAndView("register");
            	mv.addObject("reg_error",reg_err);
			return mv;
			}
			}*/
		
		/*ynew needed  nd duplicate Exception not allowed */
		
		
		/*@RequestMapping("/loginchk")
		public ModelAndView logincheck(@RequestParam("username")String uid,@RequestParam("password")String pass){
			System.out.println("login chk req sent");
			int value=userserv.chkuser(uid, pass);
			List<Users> us=userserv.getUserById(uid);
			 username = us.get(0).getName();
			ModelAndView mv1;
			if(value==1){
				mv1=new ModelAndView("admin/adminpage");	
				mv1.addObject("name", username);
			}
			else if(value==2){
				mv1=new ModelAndView("user/userpage");
				mv1.addObject("name", username);
			}
			else 
				mv1=new ModelAndView("loginerror");
			return mv1;
		}
		*/
		@RequestMapping("/loginchk")
		public ModelAndView logincheck(Principal principal){
			System.out.println("login chk req sent");
			System.out.println("\nName : " + principal.getName());
			ModelAndView mv1;
			int value=userserv.chkuser1(principal.getName());
			System.out.println(value);
			if(value==1){
				mv1=new ModelAndView("admin/adminpage");
				
				System.out.println("\nName : admin");
				}	
			else if(value==2){
				mv1=new ModelAndView("user/userpage");
				System.out.println("\nName : user");
				}
			else 
			{
				mv1=new ModelAndView("redirect:/login-fail");
			System.out.println("\nName : failed");
			
			}
			return mv1;
			
			
		}
		
}
