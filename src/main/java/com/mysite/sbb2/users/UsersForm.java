package com.mysite.sbb2.users;





import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersForm {

	@NotEmpty(message="이름을 입력해주세요")
	private String name;
	
	@NotEmpty(message="비밀번호를 입력해주세요")
	private String pass;
	
	@NotEmpty(message="이메일을 입력해주세요")
	private String email;
	
	@NotEmpty(message="아무 숫자를 입력해주세요")
	private String cnt;
	
}
