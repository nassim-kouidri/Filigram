package com.filigram.account.Modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "relation")
public class Relation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRelation;

	private int idAccountOne;

	@Column(columnDefinition = "Boolean default true")
	private Boolean Friendship;

	private int idAccountSecond;



	public Integer getIdRelation() {
		return this.idRelation;
	}

	public void setIdRelation(Integer idRelation) {
		this.idRelation = idRelation;
	}

	public Boolean isFriendship() {
		return this.Friendship;
	}



	public int getIdAccountOne() {
		return idAccountOne;
	}

	public void setIdAccountOne(int idAccountOne) {
		this.idAccountOne = idAccountOne;
	}

	public int getIdAccountSecond() {
		return idAccountSecond;
	}

	public void setIdAccountSecond(int idAccountSecond) {
		this.idAccountSecond = idAccountSecond;
	}

	public Boolean getFriendship() {
		return Friendship;
	}

	public void setFriendship(Boolean friendship) {
		Friendship = friendship;
	}

}
