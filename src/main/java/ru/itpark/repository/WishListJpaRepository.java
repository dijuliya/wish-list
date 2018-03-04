package ru.itpark.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.entity.WishList;

import java.util.List;

public interface WishListJpaRepository extends JpaRepository<WishList, Integer>{


    @Query("select w.id from WishList w")
    List<Integer> findAllIds();

    List<WishList> findAllByNameContainsIgnoreCase(String name);

    List<WishList> findAllOrderByLikesDesc();

    @Modifying
    @Transactional
    @Query("update WishList w set w.likes = w.likes+1 where id = :id")
    Integer addLike(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("update WishList w set w.likes = w.likes-1 where id = :id")
    Integer deleteLike(@Param("id") int id);
}
