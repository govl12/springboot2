package com.mysite.sbb2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class sbbLombok {

	
	public String LombokString;
	public int Lombokint;

	
	public static void main(String[] args) {
	
		//객체 생성
		sbbLombok sbb = new sbbLombok();
		
		//setter
		sbb.setLombokint(5);
		sbb.setLombokString("0206실습");

		//getter
		System.out.println(sbb.getLombokint());
		System.out.println(sbb.getLombokString());
		
		//toString
		
		System.out.println(sbb);
		
	
		
	
	}

}
