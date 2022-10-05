package com.sparta.newweek03.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;
}

//    private Integer password;
//    public MemoRequestDto(Memo entity) {
//        this.username = entity.getUsername();
//        this.title = entity.getTitle();
//        this.contents = entity.getContents();
//        this.password = entity.getPassword();

