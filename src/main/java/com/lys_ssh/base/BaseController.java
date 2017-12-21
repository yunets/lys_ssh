package com.lys_ssh.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	@RequestMapping("jspView")
	public String jspView(String jsp){
		return jsp;
	}

}
