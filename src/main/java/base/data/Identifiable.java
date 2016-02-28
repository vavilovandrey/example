package base.data;

import java.io.Serializable;

/**
 * Entity interface
 * @param <KEY> type of id
 */
public interface Identifiable<KEY extends Serializable> {

    void setId(KEY id);
    KEY getId();

    /**
     * Is this object already stored in db
     */
    boolean isNew();

}
