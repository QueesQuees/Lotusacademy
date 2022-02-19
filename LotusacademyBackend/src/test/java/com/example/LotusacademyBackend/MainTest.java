package com.example.LotusacademyBackend;

import java.sql.Date;
import java.util.Calendar;

public class MainTest {
	public static void main(String[] args) {
		
		long thoiGian =   (25L * 86400000);
		Date date = new Date(Calendar.getInstance().getTime().getTime() + thoiGian);
		System.out.println(date);
		
		long dt = date.getTime();
		
		
		System.out.println(dt);
		System.out.println(thoiGian);
		
	}

}
