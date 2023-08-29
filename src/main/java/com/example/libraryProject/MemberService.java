package com.example.libraryProject;

import com.example.libraryProject.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.libraryProject.MemberRepository;

import java.util.List;


@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;



    public Member addMember(String name, String family, int cardId, String userName, String password){
        Member member= new Member(name, family, cardId, userName, password);
        memberRepository.save(member);
        return member;

    }

    public String deleteMemberByCardId(int cardId){
        Member member = memberRepository.findMemberByCardId(cardId);
        memberRepository.delete(member);
        return "Member with CardId: " + cardId + "with name: " + member.getName() + " " + member.getFamily()+ "deleted";

    }

    public List<Member> getAllMembers(){
        List<Member> members= memberRepository.findAll();
        return members;

    }

    public Member editMember(Member updatedMember){
        Member member =memberRepository.findMemberByCardId(updatedMember.getCardId());
        member.setName(updatedMember.getName());
        member.setFamily(updatedMember.getFamily());
        member.setUserName(updatedMember.getUserName());
        member.setPassword(updatedMember.getPassword());
        member.setBooks(updatedMember.getBooks());
        memberRepository.save(member);
        return member;

    }




}
