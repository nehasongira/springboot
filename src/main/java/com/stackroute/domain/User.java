package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Documented;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "music")
public class User {


    @Id
    private int id;
    private String Name;
    private String singer;
    private String film;
    private String comments;




}
