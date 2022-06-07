package springtest3.domain.entity;


import lombok.*;

import javax.persistence.*;

@Entity // 일반클래스 -> jpa entity 으로 사용
@Builder
@Getter@Setter@ToString
@Table(name = "Membertest")
public class MemberEntitiy {
    @Id // pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // auto key
    public Integer no;
    @Column
    public String name;
    @Column
    public String phone;
    @Column
    public String memo;

}