import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class krc {

    String key;
    String abbreviation;


    AbbTree a = new AbbTree();

    public krc(String key, AbbTree a) {
        this.key = key;
        this.a = a;
    }


    public String search(String key, AbbTree a) {
        if (key == null || key.length() == 0) {
            return key;
        }
        int index = (int) key.charAt(0);
        if (index >= 97 && index <= 122) {
            index = index - 97;
        } else if (index >= 65 && index <= 90) {
            index = index - 65;
        } else {
            return key;
        }
        Node node = a.getBranch(index);
        String output = key;
        try {
            while (node.getChild() != null) {
                if (node.getAbbreviation().equals(key)) {
                    output = (String) node.getExpansion();
                    break;

                }
                node = node.getChild();
            }
        } catch (NullPointerException e) {

        }


        return output;
    }
    public String getKey() {
        return key;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public AbbTree getA() {
        return a;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setA(AbbTree a) {
        this.a = a;
    }
}
