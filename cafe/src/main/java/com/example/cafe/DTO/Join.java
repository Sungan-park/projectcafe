package com.example.cafe.DTO;

import com.example.cafe.Entity.JoinEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Join {
     String nik;
     Long id;
     String userid;
     String pw;

    public JoinEntity toJoinEntity(){
        return new JoinEntity(nik,id,userid,pw);
    }
}
