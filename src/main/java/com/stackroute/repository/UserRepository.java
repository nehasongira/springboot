package com.stackroute.repository;
import com.stackroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User ,Integer> {
//    @Modifying
//    @Query("UPDATE music m SET m.comments = :comment WHERE m.id = :idByUser")
//    Void updateComment(@Param("idByUser") int userId, @Param("comment") String comment1);
}
