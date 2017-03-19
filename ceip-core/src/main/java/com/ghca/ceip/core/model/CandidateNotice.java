
package com.ghca.ceip.core.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gh on 2017/3/16.
 */
@Entity
@EntityListeners({AuditingEntityListener.class})
public class CandidateNotice {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(strategy = "uuid2", name = "id")
    private String id;

    @NotNull
    private String project;  //项目名称

    private String region;  //所属地区

    @NotNull
    @Column(unique = true)
    private String url;     //公示链接

    private Date date;      //发布时间

    @CreatedDate
    private Date insertTime;    //采集时间

    private String source;  //采集网站

    //private String owner;  //项目业主


    /*@OneToMany
    @JoinColumn(name = "candidate_notice_id")
    private Set<Candidate> candidates = new HashSet<>(); //中标候选人*/

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /*public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }*/
}
