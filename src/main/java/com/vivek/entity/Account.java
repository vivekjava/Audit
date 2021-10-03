package com.vivek.entity;

import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="account")
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="accountname")
	private String accountname ;
	
	@Column(name="age")
	private String age ;
	
	@CreatedBy
	@Column(nullable = false, updatable = false)
	protected  String createdby ;
	
	@CreatedDate
	@Column(nullable = false, updatable = false)
	protected Instant createdDate ;
	

	@LastModifiedBy
	protected  String lastModifiedby ;
	
	@LastModifiedDate
	protected  Instant lastModifiedDate ;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="address_id",referencedColumnName = "id")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="account_id",referencedColumnName = "id")
	private Set<User> users;
	
	
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the accountname
	 */
	public String getAccountname() {
		return accountname;
	}
	/**
	 * @param accountname the accountname to set
	 */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	/**
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}
	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	/**
	 * @return the createdDate
	 */
	public Instant getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the lastModifiedby
	 */
	public String getLastModifiedby() {
		return lastModifiedby;
	}
	/**
	 * @param lastModifiedby the lastModifiedby to set
	 */
	public void setLastModifiedby(String lastModifiedby) {
		this.lastModifiedby = lastModifiedby;
	}
	/**
	 * @return the lastModifiedDate
	 */
	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountname=" + accountname + ", age=" + age + ", createdby=" + createdby
				+ ", createdDate=" + createdDate + ", lastModifiedby=" + lastModifiedby + ", lastModifiedDate="
				+ lastModifiedDate + ", address=" + address + ", users=" + users + "]";
	}
	
	
	
}
