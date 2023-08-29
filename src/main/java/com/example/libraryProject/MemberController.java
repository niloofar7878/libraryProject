package com.example.libraryProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member addMember(@RequestParam String name,@RequestParam String family,@RequestParam int cardId,@RequestParam String userName,@RequestParam String password){
       return memberService.addMember(name,family,cardId,userName,password);
    }

    @GetMapping
    public List<Member> showAllMember(){
        return memberService.getAllMembers();
    }

    @DeleteMapping
    public String deleteByCardId(@RequestParam int cardId){
        return memberService.deleteMemberByCardId(cardId);

    }

    @PutMapping
    public Member editMember(@RequestParam Member member){
        return memberService.editMember(member);
    }



}
