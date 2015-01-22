package com.benglasser.handfootscorekeeper;

import com.benglasser.handfootscorekeeper.points.*;

/**
 * Created by bglasser on 12/30/14.
 */
public class ScoreKeeper {
    private int score;

    private AcesAndTwosPoints acesAndTwosPoints;
    private JokerPoints jokerPoints;
    private BlackThreesPoints blackThreesPoints;
    private RedThreesPoints redThreesPoints;
    private CleanBooksPoints cleanBooksPoints;
    private DirtyBooksPoints dirtyBooksPoints;
    private GoingOutPoints goingOutPoints;
    private HighPoints highPoints;
    private LowPoints lowPoints;
    private WildBookPoints wildBookPoints;

    ScoreKeeper(){
        this.score = 0;
    }
    ScoreKeeper(AcesAndTwosPoints acesAndTwosPoints,
        JokerPoints jokerPoints,
        BlackThreesPoints blackThreesPoints,
        RedThreesPoints redThreesPoints,
        CleanBooksPoints cleanBooksPoints,
        DirtyBooksPoints dirtyBooksPoints,
        GoingOutPoints goingOutPoints,
        HighPoints highPoints,
        LowPoints lowPoints,
        WildBookPoints wildBookPoints){
        this.acesAndTwosPoints = acesAndTwosPoints;
        this.jokerPoints = jokerPoints;
        this.blackThreesPoints = blackThreesPoints;
        this.redThreesPoints = redThreesPoints;
        this.cleanBooksPoints = cleanBooksPoints;
        this.dirtyBooksPoints = dirtyBooksPoints;
        this.goingOutPoints = goingOutPoints;
        this.highPoints = highPoints;
        this.lowPoints = lowPoints;
        this.wildBookPoints = wildBookPoints;
        this.score = 0;
    }
    ScoreKeeper(int score){
        this.score = score;
    }

    public ScoreKeeper addAcesAndTwos(int num){
        score += num * 20;
        return this;
    }
    public ScoreKeeper addJoker(int num){
        score += num * 50;
        return this;
    }
    public ScoreKeeper addBlackThrees(int num){
        score -= num * 300;
        return this;
    }
    public ScoreKeeper addRedThrees(int num){
        score -= num * 500;
        return this;
    }
    public ScoreKeeper addCleanBooks(int num){
        score += num * 500;
        return this;
    }
    public ScoreKeeper addDirtyBooks(int num){
        score += num * 300;
        return this;
    }
    public ScoreKeeper addGoingOut(int num){
        score += num * 100;
        return this;
    }
    public ScoreKeeper addHighPoints(int num){
        score += num * 10;
        return this;
    }
    public ScoreKeeper addLowPoints(int num){
        score += num * 5;
        return this;
    }
    public ScoreKeeper addWildBook(int num){
        score += num * 1500;
        return this;
    }
    public ScoreKeeper addPoints(int num){
        score += num;
        return this;
    }
    public ScoreKeeper subtractPoints(int num){
        score -= num;
        return this;
    }
    public int getScore(){
        return this.score;
    }

}
