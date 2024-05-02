package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class AirportListPojo {

    private List<AirportListDataPojo> data;
    private AirportLinksPojo links;
}
