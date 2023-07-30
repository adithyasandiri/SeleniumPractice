package com.qa.testscripts;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;


public class HandlingCookies extends TestBase {
	
	@Test
	public void Cookies() {
		driver.get("https://www.yatra.com/");
		
		Set <Cookie> cookies = driver.manage().getCookies();
		System.out.println("size of the cookies are :"+ cookies.size());
		
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : "+ cookie.getValue());
			
		}
		
		
		//Adding Cookies to browser
		Cookie CookieObj = new Cookie("MyCookies","1236464646");
		driver.manage().addCookie(CookieObj);
		
		cookies = driver.manage().getCookies();
		System.out.println("After adding : " + cookies.size());
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+ " : "+ cookie.getValue());
		}
		
		//Deleting Cookie
		driver.manage().deleteCookie(CookieObj);
		cookies = driver.manage().getCookies();
		System.out.println("After adding : " + cookies.size());
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+ " : "+ cookie.getValue());
		}
		
		//Deleting all cookies
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("After Deleting : " + cookies.size());
	}
	
}
