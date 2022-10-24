package com.Modele;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComment;
	
	private String text;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Posts posts;
	
	
	
//	 @ManyToOne
//	 @JoinColumn(name = "idPost")
//	private Posts idPost;

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

//	public Posts getIdPost() {
//		return idPost;
//	}
//
//	public void setIdPost(Posts idPost) {
//		this.idPost = idPost;
//	}
	 
	 
	
}
