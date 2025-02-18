package com.mpc.springboot.member.domain.entity;

import jakarta.persistence.*;

import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.mapping.MemberCodeConverter;
import com.mpc.springboot.member.domain.vo.MemberName;
import lombok.*;

@Getter
@NoArgsConstructor
//@Table(name = "member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`key`")
    private Integer key;

    @Convert(converter = MemberCodeConverter.class)
    @Column(name = "`code`")
    private MemberCode code;

    @Embedded
    private MemberName name;

    public Member(MemberCode code, MemberName name) {
        this.code = code;
        this.name = name;
    }

    public static Member create(MemberCode code, MemberName name) {
        return new Member(code, name);
    }
}


