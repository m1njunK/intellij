package com.bitc.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {

    private Date regdate;
    private int age;
    private String id;
    private String pw;

    // alt + insert
    // File | Settings | Build, Execution, Deployment | Compiler | Java Compiler
}
