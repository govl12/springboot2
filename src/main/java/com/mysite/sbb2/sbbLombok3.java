package com.mysite.sbb2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class sbbLombok3 {

	private final String sbbst;
	private int sbbint;
	
	public static void main(String[] args) {

		sbbLombok3 sbb3 = new sbbLombok3("집에갈래");
		
		System.out.println(sbb3);
		
	}

}
