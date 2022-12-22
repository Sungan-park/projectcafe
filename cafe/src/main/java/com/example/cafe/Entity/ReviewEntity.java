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
@Table(name = "review")
@SequenceGenerator(name = "review_seq_GENERATOR",sequenceName = "review_seq", allocationSize = 1, initialValue = 1)
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq_GENERATOR")
    @Column
    Long id;
    @Column
    String rphoto;
    @Column
    String rdate;
    @Column
    String rcontent;
    @Column
    String rscore;
    @Column
    String rlike;
}