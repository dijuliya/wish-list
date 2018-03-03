package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.entity.WishList;
import ru.itpark.repository.WishListJpaRepository;

import java.util.List;

@Service
public class WishListService {
    private WishListJpaRepository repository;

    @Autowired
    public WishListService(WishListJpaRepository repository){
        this.repository = repository;
    }

    public List<WishList> findAllOrderByCountLikesDesc() {
        return repository.findAllOrderByCountLikesDesc();
    }



}
