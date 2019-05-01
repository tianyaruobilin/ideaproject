package control;

import control.impl.FamilyDataBase;

import java.util.List;

public interface FamilyInfoDataBase {
    public static class FamilyFactory{
        private static FamilyInfoDataBase dataBase;

        public static FamilyInfoDataBase getDataBaseInstance(){
            if (dataBase == null) {
                dataBase=new FamilyDataBase();
            }
            return dataBase;
        }
    }

    public String[] getColumns();

    public Object getValueAt(int row, int column);

    public String[] getSortingFields();

    public int getRowCount();

    public void sort(String sortField);

    public void addEntry(List columns, List values);

    public void update(String familyName, List columns, List values);
}
