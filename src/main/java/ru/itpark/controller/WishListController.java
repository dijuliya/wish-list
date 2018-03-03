package ru.itpark.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itpark.entity.WishList;
import ru.itpark.service.WishListService;

import java.util.List;

@RestController
@CrossOrigin
@Api(description = "Work with wishList")
@RequestMapping("/wishList")
public class WishListController {
    private final WishListService service;


    public WishListController(WishListService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all", notes = "Get all wishList")
    @RequestMapping(method = RequestMethod.GET)
    public List<WishList> getAll() {
        return service.findAllOrderByCountLikesDesc();
    }

}
