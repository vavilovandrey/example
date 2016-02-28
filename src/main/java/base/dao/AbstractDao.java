package base.dao;

import base.data.Identifiable;

import java.io.Serializable;

public interface AbstractDao<KEY extends Serializable, ENTITY extends Identifiable> {

    public ENTITY get(String id);

    /**
     * If asset is new - create new row in db, else - update row.
     */
    public ENTITY saveOrUpdate(ENTITY asset);
    public boolean isExist(KEY id);

}
