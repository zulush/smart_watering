package ma.emsi.smartwatering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.smartwatering.model.AppUser;
import ma.emsi.smartwatering.model.Connection;
import ma.emsi.smartwatering.model.Grandeur;

public interface GrandeurRepository extends JpaRepository<Grandeur, Long>{

}
	