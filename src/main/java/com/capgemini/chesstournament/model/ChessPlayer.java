package com.capgemini.chesstournament.model;

import java.time.LocalDate;

public class ChessPlayer {


    private long id;
    private String firstName;
    private String lastName;
    private String insertion;
    private LocalDate birthDate;
    private int wonMatches;
    private int lostMatches;
    private int draw;

    public ChessPlayer() {
    }

    public ChessPlayer(String firstName, String lastName, String insertion, LocalDate birthDate, int wonMatches, int lostMatches, int draw) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.insertion = insertion;
        this.birthDate = birthDate;
        this.wonMatches = wonMatches;
        this.lostMatches = lostMatches;
        this.draw = draw;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(int wonMatches) {
        this.wonMatches = wonMatches;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
