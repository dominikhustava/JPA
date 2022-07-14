package entities.embeddables;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BuildingPK implements Serializable {

    private int no;
    private String code;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
