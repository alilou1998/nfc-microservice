package com.computime.nfcmicroservice;

import com.computime.nfcmicroservice.dao.PersonneDao;
import com.computime.nfcmicroservice.dao.TagDao;
import com.computime.nfcmicroservice.entities.Personne;
import com.computime.nfcmicroservice.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NfcMicroserviceApplication implements CommandLineRunner {

    private final TagDao tagDao;
    private final PersonneDao personneDao;

    @Autowired
    public NfcMicroserviceApplication(TagDao tagDao, PersonneDao personneDao) {
        this.tagDao = tagDao;
        this.personneDao = personneDao;
    }


    public static void main(String[] args) {
        SpringApplication.run(NfcMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Personne personne = new Personne("ali","alaoui");
        personneDao.save(personne);
        Tag tag = new Tag("TAG-1",personne);

        tagDao.save(tag);
    }
}
