package com.samorodov.ilia.myapplication.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CommitDTO {

    @SerializedName("sha")
    @Expose
    private String sha;
    @SerializedName("commit")
    @Expose
    private ChildCommitDTO commit;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("committer")
    @Expose
    private String committer;
    @SerializedName("parents")
    @Expose
    private List<Object> parents = new ArrayList<Object>();

    /**
     *
     * @return
     * The sha
     */
    public String getSha() {
        return sha;
    }

    /**
     *
     * @param sha
     * The sha
     */
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     *
     * @return
     * The commit
     */
    public ChildCommitDTO getCommit() {
        return commit;
    }

    /**
     *
     * @param commit
     * The commit
     */
    public void setCommit(ChildCommitDTO commit) {
        this.commit = commit;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     *
     * @param htmlUrl
     * The html_url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     *
     * @return
     * The commentsUrl
     */
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     *
     * @param commentsUrl
     * The comments_url
     */
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     *
     * @return
     * The author
     */
    public Object getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The committer
     */
    public Object getCommitter() {
        return committer;
    }

    /**
     *
     * @param committer
     * The committer
     */
    public void setCommitter(String committer) {
        this.committer = committer;
    }

    /**
     *
     * @return
     * The parents
     */
    public List<Object> getParents() {
        return parents;
    }

    /**
     *
     * @param parents
     * The parents
     */
    public void setParents(List<Object> parents) {
        this.parents = parents;
    }

}
