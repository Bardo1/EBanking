package com.back.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email" , "CIN"}))
public @Data class User implements Serializable{

	@Id @GeneratedValue
	private Long id_user;
	private String CIN;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String pays;
	private String ville;
	private boolean enabled;
	@OneToMany(mappedBy="adrs"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
    private List<Adresse> adresses;
	@OneToMany(mappedBy="tels"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
    private List<Telephone> telephones;
	private Date date_naissance;
	private Date date_ouverture;
	private Date date_adhesion;  
	//@OneToMany(mappedBy="user_role"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
	//private Role role;
	@Enumerated(EnumType.STRING)
	private Role_values role;
	@OneToMany(mappedBy="user_cpt"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
	private List<Compte> comptes;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Long id_user, String email, String password, boolean enabled, Role_values role) {
		super();
		this.id_user = id_user;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}


	public User( String email, String password, boolean enabled, Role_values role) {
		super(); 
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}
	
	public User( String email, String password) {
		super(); 
		this.email = email;
		this.password = password; 
	}

 
}
