package com.cos.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User클래스가 MySQL에 테이블이 생성이 된다.
//@DynamicInsert //insert 시에 null인 필드를 제외시켜준다
public class User {

	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY ) //
	private int id; // 오라클(시퀀스), Mysql(auto_increment)
	
	@Column(nullable = false, length = 30)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100) // 123456 => 해쉬(비밀번호 암호화) 
	private String password;
	  
	@Column(nullable = false, length = 50)
	private String email; // myEmail, my_email
	
	//@ColumnDefault("user")
	//DB는 RoleType이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. //ADMIN,USER
	
	@CreationTimestamp // 시간이 자동으로 입력
	private Timestamp createDate;
}
