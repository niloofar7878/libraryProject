package com.example.libraryProject;

import com.example.libraryProject.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository <Member ,Integer> {

    Member findMemberByCardId(int cardId);


}
