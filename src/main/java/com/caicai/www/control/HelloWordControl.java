package com.caicai.www.control;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caicai.www.service.HelloWorldService;

import ch.qos.logback.classic.Logger;

//@RestController
@Controller
//@RequestMapping("/a")
public class HelloWordControl {
	
	private Log log = LogFactory.getLog(HelloWordControl.class.getName());
//	private Logger logs = LoggerFactory.getLogger("a");
	@Autowired
	private HelloWorldService helloWorldService;
	
	@RequestMapping(value ="/helloworld/{id}",method={RequestMethod.GET})
	@ResponseBody
	public  String helloWorld( @PathVariable String id){
		log.info("测试");
		log.info(helloWorldService.test());
//		model.addAttribute("message", "helloWorld");
		List<String> a = null;
		a.get(0);
		return "helloWorld"+id;
	}
}

