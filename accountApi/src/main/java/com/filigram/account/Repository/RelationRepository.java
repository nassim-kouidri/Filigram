package com.filigram.account.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filigram.account.Modele.Post;
import com.filigram.account.Modele.Relation;

@Repository
public interface RelationRepository extends CrudRepository<Relation, Integer> {
//	@Query(value = "SELECT * FROM relation  WHERE id_account_one = :idUser OR id_account_second = :idUser",nativeQuery = true)
//	public List<Relation> getFriends(@Param("idUser") int idUser);
	
	@Query(value = "SELECT r.id_account_second FROM relation r WHERE r.id_account_one = :idUser",nativeQuery = true)
	public List<Relation> testAccountSecond(@Param("idUser") int idUser);
	
	 public List<Relation> findByIdAccountOneOrIdAccountSecond(Integer idAccountOne, Integer idAccountSecond);
	 
		public List<Relation> findByIdAccountOne(Integer idAccountOne);
	 


}
