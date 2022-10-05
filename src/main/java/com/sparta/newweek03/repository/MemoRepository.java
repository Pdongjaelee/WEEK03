package com.sparta.newweek03.repository;

import com.sparta.newweek03.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {  //미리 구현된 JpaRepository 를 가져와서 활용 <Memo, Long> -> <다룰 객체 클래스, id의 자료형>
                                                                    //id값이 Long -> 유일하게 자료를 구분할 수 있는 형태가 Long인거 //interface라 구현하는 부분은 없다.
    List<Memo> findAllByOrderByCreatedAtDesc();
}

//3장 기준
//public class MemoRepository {
//
//    public void createMemo(Memo memo) throws SQLException {
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//        // DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("select max(id) as id from memo");
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            // product id 설정 = product 테이블의 마지막 id + 1
//            memo.setId(rs.getLong("id") + 1);
//        } else {
//            throw new SQLException("memo 테이블의 마지막 id 값을 찾아오지 못했습니다.");
//        }
//        ps = connection.prepareStatement("insert into product(id, title, image, link, lprice, myprice) values(?, ?, ?, ?, ?, ?)");
//        ps.setLong(1, memo.getId());
//        ps.setString(2, memo.getTitle());
//        ps.setString(3, memo.getImage());
//        ps.setString(4, memo.getLink());
//        ps.setInt(5, memo.getLprice());
//        ps.setInt(6, memo.getMyprice());
//
//        // DB Query 실행
//        ps.executeUpdate();
//
//        // DB 연결 해제
//        ps.close();
//        connection.close();
//    }
//
//    public Memo getMemo(Long id) throws SQLException {
//        Memo memo = new Memo();
//
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//        // DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("select * from memo where id = ?");
//        ps.setLong(1, id);
//
//        // DB Query 실행
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            memo.setId(rs.getLong("id"));
//            memo.setImage(rs.getString("image"));
//            memo.setLink(rs.getString("link"));
//            memo.setTitle(rs.getString("title"));
//        }
//
//        // DB 연결 해제
//        rs.close();
//        ps.close();
//        connection.close();
//
//        return memo;
//    }
//
//    public void updateMemo(Long id, Memo) throws SQLException {
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//        // DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("update product set myprice = ? where id = ?");
//        ps.setInt(1, myprice);
//        ps.setLong(2, id);
//
//        // DB Query 실행
//        ps.executeUpdate();
//
//        // DB 연결 해제
//        ps.close();
//        connection.close();
//    }
//
//    public List<Memo> getMemos() throws SQLException {
//        List<Memo> memos = new ArrayList<>();
//
//        // DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//        // DB Query 작성 및 실행
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from memo");
//
//        // DB Query 결과를 상품 객체 리스트로 변환
//        while (rs.next()) {
//            Memo memo = new Memo();
//            memo.setId(rs.getLong("id"));
//            memo.setImage(rs.getString("image"));
//            memo.setLink(rs.getString("link"));
//            memo.setTitle(rs.getString("title"));
//            memos.add(memo);
//        }
//
//        // DB 연결 해제
//        rs.close();
//        connection.close();
//
//        return memos;
//    }
//}
