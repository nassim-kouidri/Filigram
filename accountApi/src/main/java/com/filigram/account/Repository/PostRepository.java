package com.filigram.account.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filigram.account.Modele.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	 @Query(value="Select * from posts where account_id = :idUser ", nativeQuery = true)
	 public List<Post> findPostByIdRelation(@Param("idUser") int idUser);
	 
}
