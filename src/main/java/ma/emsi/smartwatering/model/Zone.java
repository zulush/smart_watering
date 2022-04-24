package ma.emsi.smartwatering.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  @Data @NoArgsConstructor @AllArgsConstructor
public class Zone {

	@Id @GeneratedValue(strategy = GenerationType.AUTO	)
	private int id;
	private String libelle;
	
    private float superficie;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
	private byte[] image;
	
}
