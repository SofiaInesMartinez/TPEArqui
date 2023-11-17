package tpe.administrationMS.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties(value = {"accounts"})
public class User implements Serializable{
	@Id
	private long id;
	@Column(nullable=false)
	private int phone;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String surname;
	@Column(nullable=false)
	private String username;
	@Column (nullable=false)
	private int status;
	
	@ManyToMany
    @JoinTable(name = "user_account",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "accountId"))
	private List<Account> accounts;
	
	@ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<Role> roles;
	
	public User() {
		super();
	}
	public User(long id, int phone, String email, String password, String name, String surname, String username, List<Role> roles) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.roles = roles;
		this.accounts = new ArrayList<>();
		this.status = 1;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", username=" + username + ", status=" + status + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	}
	
	
	

}