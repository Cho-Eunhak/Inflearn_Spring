package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller//스프링이 controller annotaion을 보고 관리된다-->빈이 관리된다라고 함
public class MemberController {

    //private final MemberService memberService = new MemberService(); 잘못된예
//멤버서비스를 가져다 써야함,, new로 쓸수있지만 스프링에서는 컨테이너에 다 등록하고 꺼내서 쓰는것처럼해야함
    
    //다른 controller가 memeberservice 쓸때 계속 new 하면 계속 생성되기 대문에

    //필드주입으로 이런방법도있다, 인텔리제이가 필드주입은 별로안조아한다
    //@Autowired private  MemberService memberService;//스프링 컨테이너와의 연결


    private  MemberService memberService;

//    @Autowired//세터주입, 세터인젝션 방법,
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }

    @Autowired//스프링 컨테이너와의 연결,생성자를 통한 방법
    public MemberController(MemberService memberService) {//이렇게 하면 memberservice를 못찾는 오류가 발생함
        this.memberService = memberService;//멤버서비스는 순수한 자바 클래스기때문에.
    }


}
