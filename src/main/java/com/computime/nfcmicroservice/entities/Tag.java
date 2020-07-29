package com.computime.nfcmicroservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {
    @Id
    private String uid;
    private String texte;

    public Tag() {
    }

    public Tag(String uid,String texte) {
        this.uid=uid;
        this.texte=texte;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
