package com.tom.bbs_day0117.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invitation")
@DynamicInsert
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inv_id")
    private Integer inv_id;
    @Column(name = "title")
    private String title;
    @Column(name = "summary")
    private String summary;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "createdate")
    private Timestamp createdate;
    @Column(name = "noread")
    private Integer noread;

}
