package model;

public class FamilyInfoEntry {
    private String familyName;
    private int popularation;
    private int incomePerYear;

    public FamilyInfoEntry(String familyName, int popularation, int incomePerYear) {
        this.familyName = familyName;
        this.popularation = popularation;
        this.incomePerYear = incomePerYear;
    }

    public FamilyInfoEntry() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getPopularation() {
        return popularation;
    }

    public void setPopularation(int popularation) {
        this.popularation = popularation;
    }

    public int getIncomePerYear() {
        return incomePerYear;
    }

    public void setIncomePerYear(int incomePerYear) {
        this.incomePerYear = incomePerYear;
    }

    @Override
    public String toString() {
        return "FamilyInfoEntry{" +
                "familyName='" + familyName + '\'' +
                ", popularation=" + popularation +
                ", incomePerYear=" + incomePerYear +
                '}';
    }
}
