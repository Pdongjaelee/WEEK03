package com.sparta.newweek03.service;

import com.sparta.newweek03.dto.MemoRequestDto;
import com.sparta.newweek03.entity.Memo;
import com.sparta.newweek03.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class  MemoService {
    //멤버 변수 선언
//    @Autowired
    private final MemoRepository memoRepository; //O


    //update단이 반드시 가져가야 할 부분 -> 내가 수정할 유일한 대상을 가져와 거기에 대해 dto에 해당되는 값을 넣어 보내준다.
    // id값이 있는지 없는지 확인하는 코드

    // 전체 조희
    @Transactional
    public  List<Memo> readMemoList() {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    //조회
    @Transactional
    public Memo searchById(Long id) {
        Memo memo = memoRepository.findById(id).get();  //db에서 받아온 정보
        return memo;
    }
    // 작성
    @Transactional
    public Memo createMemo(Memo memo) {
        return memoRepository.save(memo);
    }


    //수정
    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        memoRepository.save(memo);
        return memo.getId();
    }

    // 삭제
    @Transactional
    public Long delete(Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    //비밀번호 확인
    @Transactional
    public boolean checkPassword(Long id, String password){
        Memo memo = memoRepository.findById(id).get();
        if (!memo.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

//    @Transactional //update 메소드가 sql 쿼리로 작동하는 메소드구나 알려주는 annotation //update메서드 작업 중 하나라도 실패할 경우 전체 작업 취소 어노테이션
//    public Long update(Long id, MemoRequestDto requestDto) {    //변경 대상 데이터 하나를 가져올 것이다, dto에 담긴 데이터로 기존의 데이터를 변경할 것이다.
//        Memo memo = memoRepository.findById(id).orElseThrow(    //findById(id)데이터 하나를 가져다가  변수memo에 대입,
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        memo.update(requestDto);    //update함수를 적용하면서 파라미터로 변경할 데이터들이 담긴 dto객체를 넘겨주게 되는거다.
//        return memo.getId();        //getId로 바꾸려는 데이터가 변경이 됐는지 확인
//    }
//
//    @Transactional
//    public MemoRequestDto certifyPw(int id, int pw) {
//        Memo memo = memoRepository.findById((long) id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//
//        );
//        if(memo !=null)
//            (memo.getPassword().equals(pw))
//            return new MemoRequestDto(true, "비밀번호 일치");
//
//    return new MemoRequestDto(false, "비밀번호 오류");

// }
}