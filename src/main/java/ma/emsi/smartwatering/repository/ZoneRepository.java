package ma.emsi.smartwatering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.smartwatering.model.Zone;

public interface ZoneRepository extends JpaRepository<Zone,Long>{

}
