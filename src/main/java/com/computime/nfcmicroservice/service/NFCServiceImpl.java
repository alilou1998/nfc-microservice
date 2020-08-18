package com.computime.nfcmicroservice.service;


import com.computime.nfcmicroservice.dao.TagDao;
import com.computime.nfcmicroservice.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class NFCServiceImpl implements NFCService {


    @Autowired
    private TagDao tagDao;

    @Override
    public List<String> tagFormat(String s){
        return formatCSV(s);
    }

    @Override
    public Tag findParUid(String s) {
        return tagDao.findByUid(s);
    }

    @Override
    public Tag addTag(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    public List<Tag> allTag() {
        return tagDao.findAll();
    }

    @Override
    public void deleteTag(String s) {
        tagDao.deleteById(s);
    }


    private static List<String> formatCSV(String s){
        List<String> list;
        String seperator = ",";
        list = Arrays.asList(s.split(seperator));
        return list;
    }



}
