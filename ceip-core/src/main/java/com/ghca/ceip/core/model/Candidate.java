package com.ghca.ceip.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/18.
 */

@Entity
public class Candidate {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(strategy = "uuid2", name = "id")
    private String id;

    private String name; //公司名称

    private String rank; //排名

    private String bidPrice;  //投标价

    private String reviewPrice; //评审价

    private String score;   //综合评分

    @OneToMany
    @JoinColumn(name = "candidate_id")
    private Set<Leader> leaders = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "candidate_id")
    private Set<Achievement> achievements = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getReviewPrice() {
        return reviewPrice;
    }

    public void setReviewPrice(String reviewPrice) {
        this.reviewPrice = reviewPrice;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Set<Leader> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<Leader> leaders) {
        this.leaders = leaders;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }
}
