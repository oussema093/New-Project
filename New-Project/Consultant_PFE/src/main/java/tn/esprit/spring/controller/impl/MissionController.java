package tn.esprit.spring.controller.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.service.interfaces.ImissionService;

@RestController
@RequestMapping("/apimission")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class MissionController  {
	@Autowired
	ImissionService service;
	
	@GetMapping(value = "/mission/{missionid}")
    public ResponseEntity<Mission> getMissionbyId(@PathVariable Long missionid) {
    	
    	
    	return new ResponseEntity<>(service.getMissionbyId(missionid), HttpStatus.OK); //TODO
    }
	
	@PostMapping(value = "/mission/")
    public Mission addMission(@RequestBody Mission m){
    	return service.addMission(m);
    	
    }
	
	@DeleteMapping(value = "/mission/{missionid}")
    public Boolean deleteMission(@PathVariable("missionid") Long missionid){
    	
    	Mission m=new Mission();
    	m=service.getMissionbyId(missionid);
    	
    	return service.deleteMission(m);
    }
	
	@GetMapping(value = "/mission/")
    public List<Mission> getAllMissions(){
    	
    	
    	return service.getMissions();
    }
	
	
	@PutMapping(value = "/mission/")
    public Mission updateMission(@RequestBody Mission m){
    	
    	return service.updateMission(m);
    }
	
	
	@PutMapping(value = "/mission/activer/{missionid}")
    public Mission activerMission(@PathVariable Long missionid){
    	Mission m=new Mission();
    	m=service.getMissionbyId(missionid);
    	service.activerMission(m);
    	return m;
    }
	
	@PutMapping(value = "/mission/desactiver/{missionid}")
    public Mission desactivermission(@PathVariable Long missionid){
		Mission m=new Mission();
    	m=service.getMissionbyId(missionid);
    	service.desactiverMission(m);
    	return m;
    }
	 @GetMapping(value = "/cherchermission")
	    public Page<Mission> chercher(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.chercher(mc, page, size);
	    }
	 @GetMapping(value = "/getmissionsbyconsultant")
	    public Page<Mission> getmissionbyconsultant(@RequestParam("mc") Long mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.getMissionsByConsultant(mc, page, size);
	    }
	
	 
	 @GetMapping(value = "/recherchemissionsbyconsultant")
	    public Page<Mission> recherchemissionbyconsultant(@RequestParam("mc") Long mc,@RequestParam(name="mc2",defaultValue="") String mc2,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.recherchemissionbyconsultant(mc, mc2,page, size);
	    }
	 @GetMapping(value = "/recherchemissionsbyclient")
	    public Page<Mission> recherchemissionbyclient(@RequestParam("mc") Long mc,@RequestParam(name="mc2",defaultValue="") String mc2,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.recherchemissionbyclient(mc, mc2,page, size);
	    }
	 @GetMapping(value = "/recherchemissionnonaffecte")
	    public Page<Mission> recherchemissionnonaffecte(@RequestParam(name="mc2",defaultValue="") String mc2,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.recherchemissionnonaffecte(mc2,page, size);
	    }
	 @GetMapping(value = "/recherchemissionsbycc")
	    public Page<Mission> recherchemissionbychargedecompte(@RequestParam("mc") Long mc,@RequestParam(name="mc2",defaultValue="") String mc2,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.recherchemissionbychargecompte(mc, mc2,page, size);
	    }
		@DeleteMapping(value = "/missionauto/")
	    public Boolean deleteMissionAuto(){
			List<Mission>missions=new ArrayList<>();
			 java.util.Date today = new java.util.Date();
			missions=service.rechercheMissionDelai(new Timestamp(today.getTime()));
			for (Mission m : missions) {
		    	 service.deleteMission(m);
	
			}

	    	
	    	
	    	return true;
	    }
		@PutMapping(value="/affectermission")
		public Mission affecterMission(@RequestBody Mission m)
		{
			
			return service.affecter(m);
		}
}
