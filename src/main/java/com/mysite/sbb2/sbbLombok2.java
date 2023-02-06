package com.mysite.sbb2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class sbbLombok2 {
	
	private String sbbLombokst;
	private int sbbLombokint;

	public static void main(String[] args) {
		
		sbbLombok2 sbb2 = new sbbLombok2("lombok", 77);
		
		System.out.println(sbb2.getSbbLombokint());
		System.out.println(sbb2.getSbbLombokst());
		
		System.out.println(sbb2);

		
		
	}

}
