package com.leo.cardriverentals.repository;

import com.leo.cardriverentals.dto.UserDTO;
import com.leo.cardriverentals.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
    SELECT new com.leo.cardriverentals.dto.UserDTO(
        u.userId,
        u.name,
        CASE
            WHEN TYPE(u) = Customer THEN 'Customer'
            WHEN TYPE(u) = Employee THEN 'Employee'
            ELSE 'None'
        END
    )
    FROM User u
""")
    List<UserDTO> findAllUserDetails();

}
