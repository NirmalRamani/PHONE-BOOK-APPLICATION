package in.spring.boot.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm {

	private Integer contactId;	
	private String contactName;	
	private String contactEmail;	
	private Integer contactNumber;	
	private String activeSw;	
	private LocalDate createdDate;	
	private LocalDate updatedDate;
}
