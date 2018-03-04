package ru.itpark.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.itpark.entity.WishList;
import ru.itpark.service.WishListService;

import java.util.List;

@RestController
@CrossOrigin
@Api(description = "Work with wishList")
@RequestMapping("/wishes")
public class WishListController {
    private final WishListService service;


    public WishListController(WishListService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all in order", notes = "Get all wishList in order")
    @GetMapping
    public List<WishList> getAll() {
        return service.findAllByOrderByLikes();

    }

    @PostMapping
    public void save(@RequestBody WishList wishList) {
        service.save(wishList);
    }

    @PostMapping("/{id}/likes")
    public void addLike(@RequestBody Integer id) {
        service.addLike(id);
    }

    @DeleteMapping("/{id}/likes")
    public void deleteLike(@PathVariable int id) {
        service.deleteLike(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


}
