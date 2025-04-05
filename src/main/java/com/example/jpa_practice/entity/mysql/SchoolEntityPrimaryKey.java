package com.example.jpa_practice.entity.mysql;


import lombok.Data;

import java.io.Serializable;

@Data
public class SchoolEntityPrimaryKey  implements Serializable {
        public String schoolName;
        public String address;

}
