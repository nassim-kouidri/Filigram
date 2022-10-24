package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Modele.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
	
	// public List<Posts> findPostBySignalPost(@Param("signalPost") Boolean signalPost);
	 public List<Posts> findPostBySignalPostOnce(@Param("trueSignalPost") Boolean trueSignalPost);
	 
	 
	 @Query(value = "SELECT COUNT(id_post) FROM posts p WHERE p.account_id=?1", nativeQuery = true)
	 public int getNbrPost(int id);
}
