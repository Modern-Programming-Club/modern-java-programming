package com.mpc.springboot.member.domain.entity;

import jakarta.persistence.*;

import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.mapping.MemberCodeConverter;
import com.mpc.springboot.member.domain.vo.MemberName;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer key;

    @Convert(converter = MemberCodeConverter.class)
    private MemberCode code;

    @Embedded
    private MemberName name;

    public Member(MemberCode code, MemberName name) {
        this.code = code;
        this.name = name;
    }
}


