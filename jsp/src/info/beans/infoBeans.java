package info.beans;

public class infoBeans {
    private String id;
    private String name;

    public infoBeans() {
    }

    public infoBeans(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getGender() {
        char sexNum = id.charAt( 7 );
        if(sexNum == '1') {
            return "남자";
        } else return "여자";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
