package com.sparta.newweek03.controller;

import com.sparta.newweek03.dto.MemoRequestDto;
import com.sparta.newweek03.entity.Memo;
import com.sparta.newweek03.repository.MemoRepository;
import com.sparta.newweek03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor    // final로 선언된 멤버 변수를 자동으로 생성합니다
@RestController             // JSON으로 데이터를 주고받음을 선언합니다.
public class MemoController {

    //    @Autowired
    private final MemoService memoService;
//    private final MemoRepository memoRepository; //->Repository꺼도 가져와야하는 기능 있느니까?


    //3장 중복삭제
    // public MemoController() {
    //    MemoService memoService = new MemoService();
    //     this.memoService = memoService;
    // }

    //전체 조회
//    @ResponseBody       //http body 그대로 받는 어노테이션
    @GetMapping("/api/memo")           //post와 같은 url 사용
    public List<Memo> readMemoList() {
        return memoService.readMemoList();
//        return memoRepository.findAllByOrderByCreatedAtDesc();
        // List<Memo> memos = memoService
        // .getMemos();
        //
        //return memoRepository.findAllByOrderByModifiedAtDesc(); //findAllByOrderByModifiedAtDesc -> 수정된 순서를 내림차순으로 정렬해서 모든 값을 가져오겠다.
    }

    //  조회
    @GetMapping("/api/memo/{id}")
    public Memo searchById(@PathVariable Long id) {
        return memoService.searchById(id);
    }

    //  작성
    @PostMapping("/api/memo")          // 멤버변수에 어떤 값을 넣을지 재료가 필요하다.
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {    //@RequestBody를 통해서 재료 그릇 dto 지정
        Memo memo = new Memo(requestDto);
        return memoService.createMemo(memo);                       //dto에서 생성된 Memo객체가 //Repository로 전달되어 db에 데이터로 기록
    }
    // 수정
    @PutMapping("/api/memo/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    // 삭제
    @DeleteMapping("/api/memo/{id}")           //삭제하려는 유일한 하나의 값을 가져와야 하므로 {id}이 경로레 쓰인다.
    public Long delete(@PathVariable Long id) {   //위 경로에 넘겨주기 위해서는 @PathVariable를 사용
        return memoService.delete(id); //@DeleteMapping으로 해당 id의 메모 데이터가 지워진다.

    }

    //비밀번호 확인
    @GetMapping("/api/memo/{id}/{password}")
    public Boolean getMemoPassword(@PathVariable Long id, @PathVariable String password){
        return memoService.checkPassword(id, password);
    }


//    //게시글 pw 확인
//    @PostMapping("/api/memos/{id}")
//    public MemoRequestDto certifyPw(int id, int pw) {
//        return memoService.certifyPw(id,pw);

}

