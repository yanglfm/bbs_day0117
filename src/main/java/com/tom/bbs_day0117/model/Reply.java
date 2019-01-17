package com.tom.bbs_day0117.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Reply")
@DynamicInsert
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "re_id")
    private Integer re_id;
    @Column(name = "inv_id")
    private Integer inv_id;
    @Column(name = "content")
    private String content;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "createdate")
    private Timestamp createdate;
    @Column(name = "noread")
    private Integer noread;
    @Column(name = "parentid")
    private String parentid;

}
