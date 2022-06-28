package ma.emsi.smartwatering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.smartwatering.model.Capteur;

public interface CapteurRepository extends JpaRepository<Capteur, Long>{
	
	
}
	