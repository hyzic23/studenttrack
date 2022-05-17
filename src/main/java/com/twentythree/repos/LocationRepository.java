package com.twentythree.repos;

import com.twentythree.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    //@Query("select type,count(type) from location group by type")
    //@Query("select type,count(type) from location group by type", nativeQuery = true)
    @Query("select lc.type,count(lc.type) from Location lc group by lc.type")
    public List<Object[]> findTypeAndTypeCount();
}
