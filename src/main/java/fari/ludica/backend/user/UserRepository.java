package fari.ludica.backend.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    @Query("{'email' : ?0}")
    User findByEmail(String email);

    @Query("{'username' : ?0}")
    User findByUsername(String username);



}
