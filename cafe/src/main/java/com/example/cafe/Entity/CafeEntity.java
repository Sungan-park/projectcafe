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
@Table(name = "ccafe")
@SequenceGenerator(name = "ccafe_seq_GENERATOR",sequenceName = "ccafe_seq", allocationSize = 1, initialValue = 1)
public class CafeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ccafe_seq_GENERATOR")
    @Column
    Long id;
    @Column
    String cname;
    @Column
    String cphoto1;
    @Column
    String cphoto2;
    @Column
    String cphoto3;

    @Column
    String cintro;
    @Column
    String carea;
    @Column
    String ctype;
    @Column
    String cfilter;
    @Column
    String cmenu;
}