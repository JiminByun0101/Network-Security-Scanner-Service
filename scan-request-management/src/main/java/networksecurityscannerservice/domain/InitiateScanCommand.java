package networksecurityscannerservice.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class InitiateScanCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String hostname;

    private String ipAddress;
    private String toolName;
}
