package ma.emsi.smartwatering.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  @Data @NoArgsConstructor @AllArgsConstructor
public class EspaceVert {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO	)
	private long id;
	private String libelle;
	
	@Lob
    @Column(name = "photo", columnDefinition="BLOB")
	private byte[] image;
	
	@OneToMany
	@JoinColumn(name="espace_id")
	private List<Zone> zones;
}
