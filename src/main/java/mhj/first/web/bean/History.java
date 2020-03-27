package mhj.first.web.bean;

public class History {
    private Integer hid;
    private Integer eid;
    private String type;
    private String filepath;
    private Double filesize;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer hEid) {
        this.eid = hEid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Double getFilesize() {
        return filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
    }

    @Override
    public String toString() {
        return "History{" +
                "hid=" + hid +
                ", eid=" + eid +
                ", type='" + type + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filesize=" + filesize +
                '}';
    }
}
