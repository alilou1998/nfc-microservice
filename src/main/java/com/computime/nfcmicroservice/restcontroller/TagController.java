package com.computime.nfcmicroservice.restcontroller;


import com.computime.nfcmicroservice.dao.TagDao;
import com.computime.nfcmicroservice.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TagController {


    private final TagDao tagDao;

    @Autowired
    public TagController(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @GetMapping("/tags")
    public List<Tag> listTag(){
        return tagDao.findAll();
    }

    @GetMapping("/tags/{uid}")
    public Tag getTag(@PathVariable("uid") String s){
        return tagDao.findByUid(s);
    }

}
