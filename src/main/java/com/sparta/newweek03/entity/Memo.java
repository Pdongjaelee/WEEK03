package com.sparta.newweek03.entity;

import com.sparta.newweek03.dto.MemoRequestDto;
//import com.sparta.newweek03.dto.MemoResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id; //유일한 값으로 구분해야 하는 멤버변수 id 추가 //@id와 같이 변수 id는 primart key로 사용한다.

    @Column(nullable = false) //@Column -> 테이블에 Column값으로 작용할 것이다.
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;


    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
     }
    }


//    //    public Memo(String s, String 임민영) {
//    public void createMeme(MemoRequestDto requestDto) {
//        this.username = requestDto.getUsername();
//        this.title = requestDto.getTitle();
//        this.contents = requestDto.getContents();
//
//
//        public void update (MemoRequestDto requestDto){         //MemoService @Transactional단에서 호출되어야 하므로 update 메소드 추가
//            this.username = requestDto.getUsername();
//            this.title = requestDto.getTitle();
//            this.contents = requestDto.getContents();
//        this.password = requestDto.getPassword();

//    public void updateArticle(MemoRequestDto requestDto) {
//        this.username = requestDto.getUsername();
//        this.title = requestDto.getTitle();
//        this.contents = requestDto.getContents();
    

