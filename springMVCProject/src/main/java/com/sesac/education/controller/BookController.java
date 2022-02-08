package com.sesac.education.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sesac.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	
	List<BookVO> blist;
	
	public BookController() {
		blist = new ArrayList<>();
		blist.add(new BookVO(1, "java", "이현지", "새싹", "2022-02-08"));
		blist.add(new BookVO(2, "java", "원윤서", "새싹", "2022-02-08"));
		blist.add(new BookVO(3, "java", "유규원", "새싹", "2022-02-08"));
		blist.add(new BookVO(4, "java", "이미나", "새싹", "2022-02-08"));
		blist.add(new BookVO(5, "java", "양서영", "새싹", "2022-02-08"));
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String bookInsert() {
		return "book/bookInsertForm";
	}
	
	//@RequestParam : 파라미터를 따로 받아 변수 지정이 가능
	// 파라미터명과 변수명이 같다면 생략한다.
	//@ModelAttribute("book") : 파라미터로 받은 값을 View로 전달
	// == model.addAttribute("book2", book3);
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(
			@RequestParam("bno") int bookNo,
			String title,
			String author,
			String pub,
			String pubDate,
			int status,
			@ModelAttribute("book") BookVO book, 
			BookVO book3,
			Model model) {
		System.out.println("bno : " + bookNo);
		System.out.println("title : " + title);
		System.out.println("author : " + author);
		System.out.println("pub : " + pub);
		System.out.println("pubDate : " + pubDate);
		System.out.println("status : " + status);
		System.out.println("BookVO 받기 : " + book);
		model.addAttribute("myname", "jin");
		model.addAttribute("book2", book3);
		return "book/bookResult";
	} 
	
/*	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(BookVO book) {
		System.out.println(book);
		return "book/BookResult";
	}
*/
	@RequestMapping("/list")
	public String booklist(Model model) {
		
		model.addAttribute("booklist", blist);
		
		return "book/bookList";
	}
	
	@RequestMapping("/detail")
	public String bookDetail(int bno, Model model) {
		
		BookVO book = null;
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				book= b;
				break;
			}
		}
		
		model.addAttribute("book",book);
		
		return "book/bookDetail";
	}
	
	@RequestMapping("/update")
	public String update(BookVO book, Model model) {
		System.out.println(book);
		for(BookVO b : blist) {
			if(b.getBno() == book.getBno()) {
				b.setAuthor(book.getAuthor());
				b.setPub(book.getPub());
				b.setPubDate(book.getPubDate());
				b.setStatus(book.getStatus());
				b.setTitle(book.getTitle());
				break;
			}
		}
		return "book/bookResult";
	}
}



























