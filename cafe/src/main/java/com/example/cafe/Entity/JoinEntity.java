package com.example.cafe.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "cjoin")
@SequenceGenerator(name = "cjoin_seq_GENERATOR",sequenceName = "cjoin_seq", allocationSize = 1, initialValue = 1)
public class JoinEntity {


    @Column
    String nik;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cjoin_seq_GENERATOR")
    @Id
    @Column
    long id;
    @Column
    String userid;
    @Column
    String pw;

}