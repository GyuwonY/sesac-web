package com.sesac.education.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.co.sesac.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	
	List<BookVO> blist;
	
	public BookController() {
		blist = new ArrayList<>();
		blist.add(new BookVO(1, "java", "as", "새싹", "2022-02-08"));
		blist.add(new BookVO(2, "java", "asd", "새싹", "2022-02-08"));
		blist.add(new BookVO(3, "java", "vzd", "새싹", "2022-02-08"));
		blist.add(new BookVO(4, "java", "adf", "새싹", "2022-02-08"));
		blist.add(new BookVO(5, "java", "qfe", "새싹", "2022-02-08"));
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
			Model model, RedirectAttributes redirectAttr) {
		
		model.addAttribute("myname", "jin");
		model.addAttribute("book2", book3);
		blist.add(book3);
		redirectAttr.addFlashAttribute("message","입력성공");
		
		return "redirect:/book/list";
	} 
	
	/*
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(BookVO book) {
		System.out.println(book);
		return "book/BookResult";
	}
	*/
	
	/* 하나의 controller에서 exception 처리
	@ExceptionHandler(Exception.class)
	public String processException(Exception ex) {
		ex.printStackTrace();
		System.out.println("오류 : " + ex.getMessage());
		return "error/errorPage500";
	}
	*/
	
	@RequestMapping("/list")
	public String booklist(Model model, HttpServletRequest request) {
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			String msg = (String)flashMap.get("message");
			System.out.println(msg);
			model.addAttribute("message",msg);
		}
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
	
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public String update(BookVO book, RedirectAttributes redirectAttr) {
		System.out.println("수정된book:"+book);
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
		redirectAttr.addFlashAttribute("message", "수정성공");
		return "redirect:/book/list";
	}
	
	@RequestMapping(value="/delete")
	public String delete(int bno, RedirectAttributes redirectAttr) {
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				blist.remove(b);
				break;
			}
		}
		redirectAttr.addFlashAttribute("message", "수정성공");
		return "redirect:/book/list";
	}
	
}



























