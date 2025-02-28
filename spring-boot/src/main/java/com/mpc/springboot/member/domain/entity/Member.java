package com.mpc.springboot.member.domain.entity;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.mapping.MemberCodeConverter;
import com.mpc.springboot.member.domain.vo.MemberName;
import com.mpc.springboot.shared.domain.AuditFields;
import lombok.*;

@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer key;

    @Convert(converter = MemberCodeConverter.class)
    private MemberCode code;

    @Embedded
    private MemberName name;

    @Embedded
    private final AuditFields auditFields = new AuditFields();

    private Member(MemberCode code, MemberName name) {
        this.code = code;
        this.name = name;
    }

    public static Member of(MemberCode code, MemberName name) {
        return new Member(code, name);
    }
}


