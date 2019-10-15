package com.stackroute.repository;
import com.stackroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User ,Integer> {
    @Query(value = "SELECT m FROM User m where m.Name = :name")
    List<User> findTitleByName(@Param("name") String name);

//    @Query(value = "SELECT * FROM music t WHERE t.Name = 'Name'",
//            nativeQuery=true)
//    List<User> findByNameEndsWith(String chars);
//    @Modifying
//    @Query("UPDATE music m SET m.comments = :comment WHERE m.id = :id")
//    Void updateComment(@Param("id") int userId, @Param("comment") String comment1);
}
