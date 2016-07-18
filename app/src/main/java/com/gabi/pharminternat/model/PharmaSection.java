package com.gabi.pharminternat.model;

/**
 * Created by gabi on 15/07/16.
 */
public class PharmaSection {
    private int section;
    private String sectionTitle;

    public PharmaSection(int section, String sectionTitle) {

        this.section = section;
        this.sectionTitle = sectionTitle;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }


}
