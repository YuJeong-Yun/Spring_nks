package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}

	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}

	@RequestMapping("/ex")
	public String main() throws Exception {
		throw new Exception("에러가 발생했습니다");
	}

	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new FileNotFoundException("에러가 발생했습니다");
	}

}
