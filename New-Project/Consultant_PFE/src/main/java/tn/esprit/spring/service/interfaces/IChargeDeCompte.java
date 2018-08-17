package tn.esprit.spring.service.interfaces;

import tn.esprit.spring.entity.ChargeDeCompte;
import tn.esprit.spring.entity.Client;

public interface IChargeDeCompte {
	public ChargeDeCompte findChargeCompteByUserName(String userName);
	public ChargeDeCompte addcc(ChargeDeCompte chargedecompte);

}
