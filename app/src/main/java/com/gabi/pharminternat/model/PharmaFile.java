package com.gabi.pharminternat.model;


import java.util.Date;

/**
 * Created by gabi on 15/07/16.
 */
public class PharmaFile {
    private int id;
    private int section;
    private double displayOrder;
    private String fileTitle;
    private int reviewCounter;
    private Date lastReview;
    private Date todoDate;

    public PharmaFile(int id, int section, double displayOrder, String fileTitle, int reviewCounter, Date lastReview, Date todoDate) {
        this.id = id;
        this.section = section;
        this.displayOrder = displayOrder;
        this.fileTitle = fileTitle;
        this.reviewCounter = reviewCounter;
        this.lastReview = lastReview;
        this.todoDate = todoDate;
    }

    public int getId() {
        return id;
    }
    public int getSection() {
        return section;
    }

    public double getDisplayOrder() {
        return displayOrder;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public int getReviewCounter() {
        return reviewCounter;
    }

    public void incrementReviewCounter() {
        this.reviewCounter++;
    }

    public Date getLastReview() {
        return lastReview;
    }

    public Date getTodoDate() {
        return this.todoDate;
    }

    public void setTodoDate(Date newTodoDate) {
        this.todoDate = newTodoDate;
    }

    public void setLastReview(Date lastReview) {
        this.lastReview = lastReview;
    }
}
