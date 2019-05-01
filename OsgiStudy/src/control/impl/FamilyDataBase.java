package control.impl;

import control.FamilyInfoDataBase;
import model.FamilyInfoEntry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FamilyDataBase implements FamilyInfoDataBase {

    private LinkedList familyEntryList=new LinkedList();
    private Object[] sortedValues=null;

    public FamilyDataBase() {
    }

    public FamilyDataBase(LinkedList familyEntryList, Object[] sortedValues) {
        this.familyEntryList.add(new FamilyInfoEntry("穆桂英挂帅", 3, 1200));
        this.familyEntryList.add(new FamilyInfoEntry("双阳公主", 3, 1200));
        this.familyEntryList.add(new FamilyInfoEntry("锁麟囊", 3, 1200));
        this.familyEntryList.add(new FamilyInfoEntry("红娘", 3, 1200));
        this.sortedValues=this.familyEntryList.toArray();
    }

    @Override
    public String[] getColumns() {
        return new String[]{"Family Name","Family Population","Income"};
    }

    @Override
    public Object getValueAt(int row, int column) {
        FamilyInfoEntry entry = (FamilyInfoEntry) this.sortedValues[row];
        switch (column) {
            case 0:
                return entry.getFamilyName();
            case 1:
                return new Integer(entry.getPopularation());
            case 2:
                return new Integer(entry.getIncomePerYear());
            default:
                throw  new IllegalArgumentException("invalid column index");
        }
    }

    @Override
    public String[] getSortingFields() {
        return new String[]{"FamilyName", "Income"};
    }

    @Override
    public int getRowCount() {
        return this.familyEntryList.size();
    }

    @Override
    public void sort(String sortField) {
        if ("FamilyName".equals(sortField)) {
            this.sortedValues=this.familyEntryList.toArray();
            Arrays.sort(this.sortedValues,new SortByName());
        }

        if ("Income".equals(sortField)) {
            this.sortedValues=this.familyEntryList.toArray();
            Arrays.sort(this.sortedValues,new SortByIncome());
        }

        throw new IllegalArgumentException("\"Sorting enties by field '\" + sortField + \"' is not supported.\"");
    }

    @Override
    public void addEntry(List columns, List values) {

    }

    @Override
    public void update(String familyName, List columns, List values) {

    }

    class SortByName implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            if (o1==o2) {
                return 0;
            }
            FamilyInfoEntry entry1= (FamilyInfoEntry) o1;
            FamilyInfoEntry entry2= (FamilyInfoEntry) o2;
            return entry1.getFamilyName().compareTo(entry2.getFamilyName());
        }
    }

    class SortByIncome implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            if (o1==o2) {
                return 0;
            }
            FamilyInfoEntry entry1= (FamilyInfoEntry) o1;
            FamilyInfoEntry entry2= (FamilyInfoEntry) o2;
            return entry1.getIncomePerYear()-(entry2.getIncomePerYear());
        }
    }
}
