package com.computime.nfcmicroservice;

import com.computime.nfcmicroservice.dao.TagDao;
import com.computime.nfcmicroservice.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NfcMicroserviceApplication implements CommandLineRunner {

    private final TagDao tagDao;

    @Autowired
    public NfcMicroserviceApplication(TagDao tagDao) {
        this.tagDao = tagDao;
    }


    public static void main(String[] args) {
        SpringApplication.run(NfcMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tag tag = new Tag("TAG-1","Hello");

        tagDao.save(tag);
    }
}
