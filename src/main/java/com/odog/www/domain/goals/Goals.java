package com.odog.www.domain.goals;

import com.odog.www.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Goals extends BaseTimeEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Column(columnDefinition ="TEXT", nullable = false)
    private String text;

    private String state;

    @Builder
    public Goals(String userId, String text, String state) {
        this.userId = userId;
        this.text = text;
        this.state = state;
    }

    public void text_update(String text) {
        this.text = text;

    }
    public void state_update(String state) {
        this.state = state;
    }
}
