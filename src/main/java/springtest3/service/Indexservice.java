package springtest3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest3.domain.dto.MemberDto;
import springtest3.domain.entity.MemberRepository;
import springtest3.domain.entity.MemberEntitiy;

import java.util.ArrayList;
import java.util.List;

@Service
public class Indexservice { // 자바 로직 실행되는 클래스

    @Autowired // 자동 빈 생성
    MemberRepository memberRepository;
    // 1. 생성
    public boolean create(MemberDto memberDto){

        System.out.println("save service");
        // 1. Dto -> entitiy 변환
        MemberEntitiy memberEntitiy = memberDto.changeEntiity();
        // 2. entitiy save
        int no =  memberRepository.save( memberEntitiy ).getNo(); //  저장 후에 기본키 빼오기
        // 3. 반환
        System.out.println("저장된 엔티티 번호 : " + no );

        if( no > 0  ) {  return  true;   }
        else{ return  false;  }

    }
    // 2.  호출
    public List<MemberDto> read(){
        System.out.println("read service ");

        List<MemberEntitiy> entitiys = memberRepository.findAll(); //아무조건 없는 모든 엔티티 호출
        //eintitiy -> dto변환
        List<MemberDto> dtos = new ArrayList<>();
        for(MemberEntitiy entitiy : entitiys){
            dtos.add(MemberDto.builder()
                    .no(entitiy.getNo())
                    .name(entitiy.getName())
                    .phone(entitiy.getPhone())
                    .memo(entitiy.getMemo())
                    .build());


        }
        return dtos;

    }
    // 3. 수정
    public void update(){
        System.out.println("update service");

    }
    // 4. 삭제
    public void delete(){
        System.out.println("delete service");

    }
}
