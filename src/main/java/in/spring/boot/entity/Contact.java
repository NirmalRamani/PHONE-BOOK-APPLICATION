package in.spring.boot.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "CONTACT_DTLS")
public class Contact {

	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue
	private Integer contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "Contact_Email")
	private String contactEmail;
	@Column(name = "Contact_Number")
	private Integer contactNumber;
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	
}
