package com.example.finalspringshop.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
	@Id
	private String userid;
	
	private String passwd;
	private String name;
	
	@ColumnDefault("1")
	private int level;
	
	private String zipcode;
	private String address1;
	private String address2;
	
	public Member(String userid) {
		this.userid = userid;
	}
	
	@PrePersist
	public void prePersist() {
		level = level == 0 ? 1 : level;
	}
}
