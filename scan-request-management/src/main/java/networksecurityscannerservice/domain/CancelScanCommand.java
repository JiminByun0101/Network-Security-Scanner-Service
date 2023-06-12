package networksecurityscannerservice.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class CancelScanCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
}
