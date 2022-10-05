package com.sparta.newweek03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //생성일자, 수정일자 자동등록 어노테이션
@SpringBootApplication
public class NewWeek03Application {

    public static void main(String[] args) {
        SpringApplication.run(NewWeek03Application.class, args);
    }
}
//    @Bean
//    public MemoService memoService() {return new MemoService(memoRepository()); }
//
//    @Bean
//    public MemoRepository memoRepository() {return new MemoRepository() {
//        @Override
//        public List<Memo> findAllByOrderByCreatedAtDesc() {
//            return null;
//        }
//
//        @Override
//        public List<Memo> findAll() {
//            return null;
//        }
//
//        @Override
//        public List<Memo> findAll(Sort sort) {
//            return null;
//        }
//
//        @Override
//        public List<Memo> findAllById(Iterable<Long> longs) {
//            return null;
//        }
//
//        @Override
//        public <S extends Memo> List<S> saveAll(Iterable<S> entities) {
//            return null;
//        }
//
//        @Override
//        public void flush() {
//
//        }
//
//        @Override
//        public <S extends Memo> S saveAndFlush(S entity) {
//            return null;
//        }
//
//        @Override
//        public <S extends Memo> List<S> saveAllAndFlush(Iterable<S> entities) {
//            return null;
//        }
//
//        @Override
//        public void deleteAllInBatch(Iterable<Memo> entities) {
//
//        }
//
//        @Override
//        public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//        }
//
//        @Override
//        public void deleteAllInBatch() {
//
//        }
//
//        @Override
//        public Memo getOne(Long aLong) {
//            return null;
//        }
//
//        @Override
//        public Memo getById(Long aLong) {
//            return null;
//        }
//
//        @Override
//        public Memo getReferenceById(Long aLong) {
//            return null;
//        }
//
//        @Override
//        public <S extends Memo> List<S> findAll(Example<S> example) {
//            return null;
//        }
//
//        @Override
//        public <S extends Memo> List<S> findAll(Example<S> example, Sort sort) {
//            return null;
//        }
//
//        @Override
//        public Page<Memo> findAll(Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends Memo> S save(S entity) {
//            return null;
//        }
//
//        @Override
//        public Optional<Memo> findById(Long aLong) {
//            return Optional.empty();
//        }
//
//        @Override
//        public boolean existsById(Long aLong) {
//            return false;
//        }
//
//        @Override
//        public long count() {
//            return 0;
//        }
//
//        @Override
//        public void deleteById(Long aLong) {
//
//        }
//
//        @Override
//        public void delete(Memo entity) {
//
//        }
//
//        @Override
//        public void deleteAllById(Iterable<? extends Long> longs) {
//
//        }
//
//        @Override
//        public void deleteAll(Iterable<? extends Memo> entities) {
//
//        }
//
//        @Override
//        public void deleteAll() {
//
//        }
//
//        @Override
//        public <S extends Memo> Optional<S> findOne(Example<S> example) {
//            return Optional.empty();
//        }
//
//        @Override
//        public <S extends Memo> Page<S> findAll(Example<S> example, Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends Memo> long count(Example<S> example) {
//            return 0;
//        }
//
//        @Override
//        public <S extends Memo> boolean exists(Example<S> example) {
//            return false;
//        }
//
//        @Override
//        public <S extends Memo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//            return null;
//        }
//    }; }
//
//    }


//    public CommandLineRunner demo(MemoRepository memoRepository, MemoService memoService) {
//        return (args) -> {
//
//            List<Memo> memoList = memoRepository.findAll();
//            for (int i = 0; i < memoList.size(); i++) {
//                Memo memo = memoList.get(i);
//                System.out.println(memo.getId());
//                System.out.println(memo.getUsername());
//                System.out.println(memo.getTitle());
//                System.out.println(memo.getContents());
//            }
//
//            MemoListRequestDto memoRequestDto = new MemoListRequestDto();
//            memoService.update(1L, memoRequestDto);
//            memoList = memoRepository.findAll();
//            for (int i = 0; i < memoList.size(); i++) {
//                Memo memo = memoList.get(i);
//                System.out.println(memo.getId());
//                System.out.println(memo.getUsername());
//                System.out.println(memo.getTitle());
//                System.out.println(memo.getContents());
//            }
//        };
//    }
//}
