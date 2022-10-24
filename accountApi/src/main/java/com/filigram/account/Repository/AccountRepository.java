package com.filigram.account.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filigram.account.Modele.Account;
import com.filigram.account.Modele.Post;
import com.filigram.account.Modele.Relation;


@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	//List<Account> findByFullname(String fullname);
//	Account findByFullname(String fullname);	
	
    @Query(value = "SELECT * FROM account a WHERE a.fullname LIKE %?1%",nativeQuery = true)
    public List<Account> search(String keyword);
	//Optional<Account> findByFullname(String fullname);
	Account findByFullname(String fullname);
	
	 @Query(value="Select * from account where id = :idUser ", nativeQuery = true)
	 public List<Account> findAccountByIdRelation(@Param("idUser") int idUser);

//	@Query(value = "SELECT role_id FROM account  WHERE fullname = '1'",nativeQuery = true)
//	Account findByRole(String fullname);

	 public List<Account> findBySignalAccountOnce(@Param("trueSignalAccountOnce") Boolean trueSignalAccountOnce);
	

	
	
	//public List<Relation> findBy
}
