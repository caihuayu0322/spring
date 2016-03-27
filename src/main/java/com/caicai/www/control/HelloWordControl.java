package com.caicai.www.control;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

//@RestController
@Controller
//@RequestMapping("/a")
public class HelloWordControl {
	
	private Log log = LogFactory.getLog(HelloWordControl.class.getName());
//	private Logger logs = LoggerFactory.getLogger("a");
	
	@RequestMapping(value ="/helloworld/{id}",method={RequestMethod.GET})
	@ResponseBody
	public  String helloWorld( @PathVariable String id){
		log.info("测试");
//		model.addAttribute("message", "helloWorld");
		return "helloWorld"+id;
	}
}

