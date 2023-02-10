package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Controller
public class UsersController {

	//List 
	private final UsersRepository usersRepository;
	
	@GetMapping("/users/list")
	@PostMapping("/users/list")
	public String list(Model model) {
		
		List<Users> usersList = this.usersRepository.findAll();
		
		model.addAttribute("usersList", usersList);
		
		return "users_list";
	
	}
	
	@GetMapping("/users/detail/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx ) {
		
		Optional<Users> u = this.usersRepository.findById(idx);
		
		model.addAttribute("users", u.get());
		
		return "users_detail";
		
	}
	
	@GetMapping("/users/insert")
	public String insertUserPageOn() {
		return "users_insert";
	}
	
	@PostMapping("/users/update")
		public String usersupdate(@RequestParam String name, @RequestParam String pass, @RequestParam String email, @RequestParam int cnt) {
	
		Users users = new Users();
		users.setCnt(cnt);
		users.setRegdate(LocalDateTime.now());
		users.setEmail(email);
		users.setName(name);
		users.setPass(pass);
		
		this.usersRepository.save(users);
		
		return "redirect:/users/list";
		

		
	}
	
}
