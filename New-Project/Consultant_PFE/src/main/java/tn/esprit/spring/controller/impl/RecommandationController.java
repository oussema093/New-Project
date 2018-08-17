package tn.esprit.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Experience;
import tn.esprit.spring.service.interfaces.IRecommander;

@RestController
@RequestMapping("/api99")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class RecommandationController {
	@Autowired
	IRecommander service;
	 @GetMapping(value = "/recommander")
	    public boolean recommander(@RequestParam(name="to",defaultValue="") String to,@RequestParam(name="x",defaultValue="") String x,@RequestParam(name="msg",defaultValue="") String msg) {
	    	String a= "ammaroussema1993@gmail.com";

	    	String b = "realmadrid1993";

	    	return service.recommander(a, b, to, x, msg);
	    }	
}
