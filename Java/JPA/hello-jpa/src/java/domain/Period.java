package domain;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-30.
 */

@Embeddable
public class Period {
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;
}
