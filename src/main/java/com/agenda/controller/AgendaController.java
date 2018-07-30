package com.agenda.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.entity.User;
import com.agenda.repository.UserRepository;

@Controller
public class AgendaController {
	/*private final UserRepository userRepository;
	
	@Autowired
	public AgendaController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}*/
	
	@ResponseBody
  	@RequestMapping("/")
    public String cnp(Model model) {
        return "Bine ai venit !";
    }
	
  	@RequestMapping(value="/again", method=RequestMethod.GET)
	    public String hyAgain() {
        return "redirect:https://google.com";
    }

	@ResponseBody
	@RequestMapping(value = "/returnCnp", params = "cnp",method = RequestMethod.GET)
	public String returnCnp(@RequestParam String cnp, Model model) {
		return cnp + "12" ;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/returnId", method = RequestMethod.GET)
	public int returnId(@PathVariable int id, Model model) {
		return id +10;
	}
	
	@RequestMapping(value = "/cnp", method = RequestMethod.GET)
	public String getCnp(Model model) {
        model.addAttribute("cnp", "1811003081823");
		return "view";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView returnUser() {
		User obiectulUtilizator = new User();
		obiectulUtilizator.setId(1);
		obiectulUtilizator.setName("gica");
		obiectulUtilizator.setPhone("082992882");
		return new ModelAndView("user", "user", obiectulUtilizator);
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String postExemple(@RequestBody User user) {
		System.out.println(user.getName());
		return "redirect:/list";
	}
	
	@RequestMappping(value="/saveUser", method=RequestMethod.GET)
	public String saveUser() {
		User user = new User();
		user.setLastName("fane");
		user.setName("Popescu");
		user.setPhone("0744337821");
	}
	
	
	
	/*
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		userRepository.save(user);
		return "redirect:/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> saveUser() {
		List<User> findAll = (List<User>) userRepository.findAll();
		return findAll;
	}
	
	*/

  	
}
