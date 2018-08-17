package tn.esprit.spring.service.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Mission;

public interface ImissionService {
  public Mission addMission(Mission m);
  public List<Mission> getMissions();
  public boolean deleteMission(Mission m);
  public Mission updateMission(Mission m);
  public Page <Mission> chercher(String mc,int page,int size) ;
  public Mission getMissionbyId(long id);
  public Mission activerMission(Mission m);
  public Mission desactiverMission(Mission m);
  public Page <Mission>getMissionsByConsultant(Long mc,int page,int size);
  public Page <Mission>recherchemissionbyconsultant(Long mc,String mc2,int page,int size);
  public List<Mission> rechercheMissionDelai(Date mc);
  public Mission affecter(Mission m);

  public Page <Mission>recherchemissionbyclient(Long mc,String mc2,int page,int size);
  public Page <Mission>recherchemissionbychargecompte(Long mc,String mc2,int page,int size);
  
  public Page<Mission>recherchemissionnonaffecte(String mc2,int page,int size);


}
