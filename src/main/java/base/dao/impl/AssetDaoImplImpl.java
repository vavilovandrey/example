package base.dao.impl;

import base.dao.AssetDao;
import base.data.Asset;
import org.springframework.stereotype.Component;

@Component
public class AssetDaoImplImpl extends AbstractDaoImpl<String, Asset> implements AssetDao {

    @Override
    protected Class getEntityClass() {
        return Asset.class;
    }
}
