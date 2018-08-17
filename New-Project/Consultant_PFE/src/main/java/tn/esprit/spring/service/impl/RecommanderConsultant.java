package tn.esprit.spring.service.impl;

import org.springframework.stereotype.Component;

import tn.esprit.Mail.NewClass;
import tn.esprit.spring.service.interfaces.IRecommander;
@Component
public class RecommanderConsultant implements IRecommander{

	@Override
	public boolean recommander(String a, String b, String to, String x, String msg) {
		String[] too= {to};
		NewClass.sendFromGMail(a, b, too, x, msg);
		return true;
	}

}
