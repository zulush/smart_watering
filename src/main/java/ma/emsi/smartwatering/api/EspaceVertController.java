package ma.emsi.smartwatering.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.emsi.smartwatering.model.AppUser;
import ma.emsi.smartwatering.model.EspaceVert;
import ma.emsi.smartwatering.model.Zone;
import ma.emsi.smartwatering.service.EspaceVertService;
import ma.emsi.smartwatering.service.ZoneService;

@RestController @RequestMapping("/api/espaces_verts")  @RequiredArgsConstructor
public class EspaceVertController {
	
	@Autowired
	private EspaceVertService espaceSer;
	@Autowired
	private ZoneService zoneSer;
	
	@GetMapping()
	public ResponseEntity<List<EspaceVert>> getUsers(){
		return ResponseEntity.ok().body(espaceSer.getEspacesVerts());
		
	}
	
	@PostMapping("/{id}/zone")
	public ResponseEntity<List<Zone>> saveEspaceVert(@PathVariable("id") long id, @RequestBody Zone zone){
		EspaceVert espace = espaceSer.get(id);
		
		if(espace != null) {
			for(Zone z: espace.getZones()) {
				if(z.getLibelle().equals(zone.getLibelle())) {
					return null;
				}
			}
		} else {
			return null;
		}
		
		zoneSer.saveZone(zone);
		espace.getZones().add(zone);
		espaceSer.saveEspaceVert(espace);
		
		return ResponseEntity.ok().body(espace.getZones());
	}

}
