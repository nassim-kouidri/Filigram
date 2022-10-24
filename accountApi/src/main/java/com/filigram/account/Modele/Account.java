package com.filigram.account.Modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fullname;
	private String mail;
	private String password;
	@Column(columnDefinition = "text", length = 10000)
	private String profilePicture;
	private String pseudo;
	private String description;
	private int idMessaging;
	
	@JsonIgnore
	@OneToMany(targetEntity = Post.class, mappedBy = "account")
	private List<Post> posts = new ArrayList<>();
	
    @Temporal(TemporalType.DATE)
    private Calendar birthday;
	
    @Column(length=3000, nullable=true)
	private int nbrFollowers;
    
    @Column(length=3000, nullable=true)
	private int nbrPosts;
    
    @Column(length=3000, nullable=false)
	private int nbrSubscriptions;
    
	@Column(columnDefinition = "boolean default true")
	private boolean visibilityAccount;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean signalAccount;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean signalAccountOnce;
	
	public Boolean getSignalAccount() {
		return signalAccount;
	}

	public void setSignalAccount(Boolean signalAccount) {
		this.signalAccount = signalAccount;
	}

	public Boolean getSignalAccountOnce() {
		return signalAccountOnce;
	}

	public void setSignalAccountOnce(Boolean signalAccountOnce) {
		this.signalAccountOnce = signalAccountOnce;
	}

	

	@ManyToOne
	@JoinColumn(name = "role_id", columnDefinition = "integer default 1")
	private InternalRole role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdMessaging() {
		return idMessaging;
	}

	public void setIdMessaging(int idMessaging) {
		this.idMessaging = idMessaging;
	}

	public int getNbrFollowers() {
		return nbrFollowers;
	}

	public void setNbrFollowers(int nbrFollowers) {
		this.nbrFollowers = nbrFollowers;
	}

	public int getNbrPosts() {
		return nbrPosts;
	}

	public void setNbrPosts(int nbrPosts) {
		this.nbrPosts = nbrPosts;
	}

	public int getNbrSubscriptions() {
		return nbrSubscriptions;
	}

	public void setNbrSubscriptions(int nbrSubscriptions) {
		this.nbrSubscriptions = nbrSubscriptions;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public boolean isVisibilityAccount() {
		return visibilityAccount;
	}

	public void setVisibilityAccount(boolean visibilityAccount) {
		this.visibilityAccount = visibilityAccount;
	}




	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InternalRole getRole() {
		return role;
	}

	public void setRole(InternalRole role) {
		this.role = role;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	

}
