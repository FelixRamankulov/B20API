package pojo;

public class AirportDataPojo {

    private String id;
    private String type;
    private AirportAttributesPojo attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AirportAttributesPojo getAttributes() {
        return attributes;
    }

    public void setAttributes(AirportAttributesPojo attributes) {
        this.attributes = attributes;
    }
}
