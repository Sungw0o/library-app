package com.group.libraryapp.domain.user.loanhistory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String BookName;

    private boolean isReturn;

    public UserLoanHistory(Long id, String bookName, boolean isReturn) {
        this.id = id;
        BookName = bookName;
        this.isReturn = isReturn;
    }

    protected UserLoanHistory() {

    }
}
