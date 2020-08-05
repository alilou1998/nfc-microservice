package com.computime.nfcmicroservice.restcontroller;


import com.computime.nfcmicroservice.dao.PersonneDao;
import com.computime.nfcmicroservice.entities.Personne;
import com.computime.nfcmicroservice.entities.Tag;
import com.computime.nfcmicroservice.entities.mData;
import com.computime.nfcmicroservice.service.NFCServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {


    private final NFCServiceImpl nfcService;
    private final PersonneDao personneDao;

    Logger logger = LoggerFactory.getLogger(TagController.class);

    @Autowired
    public TagController(NFCServiceImpl nfcService, PersonneDao personneDao) {
        this.nfcService = nfcService;
        this.personneDao = personneDao;
    }

    @GetMapping("/tags")
    public List<Tag> listTag() {
        return nfcService.allTag();
    }

    @GetMapping("/tags/{uid}")
    public Tag getTag(@PathVariable("uid") String s) {

        return nfcService.findParUid(s);
    }




    @PostMapping("/tags")
    public Tag addTag(@RequestBody mData mdata) {
        logger.info(mdata.getM());
        List<String> strings = nfcService.tagFormat(mdata.getM());
        Personne personne = new Personne();
        personne.setNom(strings.get(1));

        personne.setPrenom(strings.get(2));

        personneDao.save(personne);

        Tag tag = new Tag();
        tag.setUid(strings.get(0));
        tag.setPersonne(personne);

        return nfcService.addTag(tag);
    }

    @DeleteMapping("/tags/{uid}")
    public void deleteTag(@PathVariable("uid") String s ){
        nfcService.deleteTag(s);
    }

}
