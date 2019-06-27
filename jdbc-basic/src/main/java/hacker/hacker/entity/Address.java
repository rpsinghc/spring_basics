package hacker.hacker.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Address {

	
	@Id
	@Column(name="address_id")
	private Integer id;
	
	private String street;
	
	private int emp_id;
}
