package com.example.cafe.DTO;

import com.example.cafe.Entity.CafeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cafe {
    Long id;
    String cname;
    String cphoto1;
    String cphoto2;
    String cphoto3;

    String cintro;
    String carea;
    String ctype;
    String cfilter;
    String cmenu;

    public CafeEntity toCafeEntity(){
        return new CafeEntity(id,cname,cphoto1,cphoto2,cphoto3,cintro,carea,ctype,cfilter,cmenu);
    }
}
