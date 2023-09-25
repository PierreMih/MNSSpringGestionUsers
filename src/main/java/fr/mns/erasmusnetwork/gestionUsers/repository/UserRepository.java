package fr.mns.erasmusnetwork.gestionUsers.repository;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    

}
