package com.geng.pojo;

public class Score {
    private String kaoName;
    private int score;

    public Score() {
    }

    public Score(String kaoName, int score) {
        this.kaoName = kaoName;
        this.score = score;
    }

    public String getKaoName() {
        return kaoName;
    }

    public void setKaoName(String kaoName) {
        this.kaoName = kaoName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
