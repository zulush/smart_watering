package ma.emsi.smartwatering.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.emsi.smartwatering.model.AppUser;
import ma.emsi.smartwatering.model.Arrosage;
import ma.emsi.smartwatering.model.EspaceVert;
import ma.emsi.smartwatering.model.Grandeur;
import ma.emsi.smartwatering.model.Installation;
import ma.emsi.smartwatering.model.Plantage;
import ma.emsi.smartwatering.model.Zone;
import ma.emsi.smartwatering.service.AppUserService;
import ma.emsi.smartwatering.service.EspaceVertService;

@RestController @RequestMapping("/api/farmer")  @RequiredArgsConstructor
public class FarmerController {

	@Autowired
	private AppUserService userSer;
	@Autowired
	private EspaceVertService espaceSer;
	
	@GetMapping()
	public AppUser getFarmer(){
		System.out.println("getFarmer is called!");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		
		return userSer.getUser(username);
		
	}
	
	@GetMapping("/espaces_verts")
	public List<EspaceVert> getEspace(){
		return this.getFarmer().getEspacesVerts();	
	}
	
	
	@GetMapping("/espaces_verts/{id}/zones")
	public List<Zone> getZones(@PathVariable("id") long id){
		
		for(EspaceVert e: this.getEspace()) {
			if(e.getId() == id) {
				return e.getZones();
			}
		}
		
		return null;
	}
	
	@GetMapping("/zone/{id}")
	public Zone getZone(@PathVariable("id") long id){
		
		for(EspaceVert e: this.getEspace()) {
			for(Zone z: e.getZones()) {
				if(z.getId() == id) {
					return z;
				}
			}
		}
		
		return null;
	}
	
	@GetMapping("/zone/{id}/boitiers")
	public List<Installation> getZoneBoitier(@PathVariable("id") long id){
		
		for(EspaceVert e: this.getEspace()) {
			for(Zone z: e.getZones()) {
				if(z.getId() == id) {
					return z.getInstallations();
				}
			}
		}
		
		return null;
	}
	
	@GetMapping("/zone/{id}/arrosage")
	public List<Arrosage> getZoneArrosage(@PathVariable("id") long id){
		
		for(EspaceVert e: this.getEspace()) {
			for(Zone z: e.getZones()) {
				if(z.getId() == id) {
					return z.getArrosages();
				}
			}
		}
		
		return null;
	}
	
	@GetMapping("/zone/{id}/plante")
	public List<Plantage> getZonePlantes(@PathVariable("id") long id){
		
		for(EspaceVert e: this.getEspace()) {
			for(Zone z: e.getZones()) {
				if(z.getId() == id) {
					return z.getPlantages();
				}
			}
		}
		
		return null;
	}
	
	@GetMapping("/zone/{id}/grandeurs")
	public List<Grandeur> getZoneGrandeurs(@PathVariable("id") long id){
		
		for(EspaceVert e: this.getEspace()) {
			for(Zone z: e.getZones()) {
				if(z.getId() == id) {
					return z.getGrandeurs();
				}
			}
		}
		
		return null;
	}
}
