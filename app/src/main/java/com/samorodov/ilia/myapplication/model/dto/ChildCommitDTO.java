package com.samorodov.ilia.myapplication.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ChildCommitDTO {

    @SerializedName("author")
    @Expose
    private AuthorDTO author;
    @SerializedName("committer")
    @Expose
    private CommitterDTO committer;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("tree")
    @Expose
    private TreeDTO tree;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;

    /**
     *
     * @return
     * The author
     */
    public AuthorDTO getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The committer
     */
    public CommitterDTO getCommitter() {
        return committer;
    }

    /**
     *
     * @param committer
     * The committer
     */
    public void setCommitter(CommitterDTO committer) {
        this.committer = committer;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The tree
     */
    public TreeDTO getTree() {
        return tree;
    }

    /**
     *
     * @param tree
     * The tree
     */
    public void setTree(TreeDTO tree) {
        this.tree = tree;
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
     * The commentCount
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     *
     * @param commentCount
     * The comment_count
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

}


