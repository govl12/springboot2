package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Controller
public class UsersController {

	
	private final UsersRepository usersRepository;
	
	@GetMapping("/users/list")
	@PostMapping("/users/list")
	public String list(Model model) {
		
		List<Users> usersList = this.usersRepository.findAll();
		
		model.addAttribute("usersList", usersList);
		
		return "users_list";
	
	}
	
	
	
}