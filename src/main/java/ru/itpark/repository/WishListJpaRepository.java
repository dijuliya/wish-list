package ru.itpark.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itpark.entity.WishList;

import java.util.List;

public interface WishListJpaRepository extends JpaRepository<WishList, Integer>{


    @Query("select a.id from WishList a")
    List<Integer> findAllIds();


    @Query("select a.id from WishList a where a.name like :name")
    List<Integer> findAllIds(@Param("name") String name);

    List<WishList> findAllByNameContainsIgnoreCase(String name);

    List<WishList> findAllOrderByCountLikesDesc();

}
