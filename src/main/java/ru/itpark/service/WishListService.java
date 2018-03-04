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

    public List<WishList> findAllByOrderByLikes() {
        return repository.findAllByOrderByLikes();
    }

    public void save(WishList wishList) {
        repository.save(wishList);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public int addLike(int id){
       return repository.addLike(id);
    }

    public int deleteLike(int id){
       return repository.deleteLike(id);
    }



}
