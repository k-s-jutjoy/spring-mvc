package com.example.demo.domain.entity;

import java.sql.Timestamp;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Users implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail_address")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "note")
    private String note;

    @CreatedDate
    @Column(name = "registered_date")
    private Timestamp registeredDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Override
    public boolean isNew() {
        return true;
    }

	@Override
	public Integer getId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void setName(String name2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setEmail(String email2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setAge(Integer age2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setNote(Object note2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}