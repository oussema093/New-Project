package tn.esprit.spring.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.repository.ConsultantRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.service.interfaces.ImissionService;
@Component
public class MissionService implements ImissionService{
@Autowired
MissionRepository missionrepo;
@Autowired
ConsultantRepository cons;
	@Override
	public Mission addMission(Mission m) {
		return missionrepo.save(m);
	}
	@Override
	public List<Mission> getMissions() {
		List<Mission>missions=new ArrayList<>();
		missionrepo.findAll().forEach(missions::add);		// TODO Auto-generated method stub
		return missions;
	}
	@Override
	public boolean deleteMission(Mission m) {
		missionrepo.delete(m);
		return true;
	}
	@Override
	public Mission updateMission(Mission m) {
		return missionrepo.save(m);
	}
	@Override
	public Page<Mission> chercher(String mc, int page, int size) {
		return missionrepo.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	@Override
	public Mission getMissionbyId(long id) {
		return missionrepo.findOne(id);
	}
	@Override
	public Mission activerMission(Mission m) {
		m.setEtat(true);
		return missionrepo.save(m);
	}
	@Override
	public Mission desactiverMission(Mission m) {
		m.setEtat(false);
		return missionrepo.save(m);
	}
	@Override
	public Page<Mission> getMissionsByConsultant(Long mc, int page, int size) {
		 return missionrepo.getMissionByConsultant(mc, new PageRequest(page, size));

	}
	@Override
	public Page<Mission> recherchemissionbyconsultant(Long mc, String mc2, int page, int size) {
		return missionrepo.rechercheMissionByConsultant(mc, "%"+mc2+"%",  new PageRequest(page, size));
	}
	@Override
	public List<Mission> rechercheMissionDelai(Date mc) {
		return missionrepo.rechercheMissionDelai(mc);
	}
	@Override
	public Mission affecter(Mission m) {
		// TODO Auto-generated method stub
		return missionrepo.save(m);
	}
	@Override
	public Page<Mission> recherchemissionbyclient(Long mc, String mc2, int page, int size) {
		// TODO Auto-generated method stub
		return missionrepo.rechercheMissionByClient(mc, "%"+mc2+"%",  new PageRequest(page, size));
	}
	@Override
	public Page<Mission> recherchemissionbychargecompte(Long mc, String mc2, int page, int size) {
		// TODO Auto-generated method stub
		return missionrepo.rechercheMissionByChargeCompte(mc, "%"+mc2+"%",  new PageRequest(page, size));
	}
	@Override
	public Page<Mission> recherchemissionnonaffecte(String mc2, int page, int size) {
		// TODO Auto-generated method stub
		return missionrepo.rechercheMissionnonaffecte("%"+mc2+"%", new PageRequest(page, size));
	}

}
