package sg.edu.rp.c346.p03_classjournal;

import java.io.Serializable;

public class DailyGrade implements Serializable{
    private String dailyGrade;
    private String moduleCode;
    private int week;

    public DailyGrade(String dailyGrade, String moduleCode, int week) {
        this.dailyGrade = dailyGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }

    public String getDailyGrade() {
        return dailyGrade;
    }

    public void setDailyGrade(String dailyGrade) {
        this.dailyGrade = dailyGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
