package com.rungroup.web.repository;

import com.rungroup.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Component
public interface ClubRepository extends JpaRepository<Club,Long> {

    Optional<Club> findByTitle(String url);

    @Query("SELECT c FROM Club c WHERE c.title LIKE '%' || 'This a runner' || '%'")
    List<Club> searchClubs(String query);
}
