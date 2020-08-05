package com.computime.nfcmicroservice.dao;

import com.computime.nfcmicroservice.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TagDao extends JpaRepository<Tag,String> {

//    @Query("select tag from Tag tag where tag.uid=:x")
    Tag findByUid(@Param("x") String s);

    void deleteById(String s);
}
