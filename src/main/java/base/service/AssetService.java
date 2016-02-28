package base.service;

import base.data.Asset;

/**
 * Some operations with assets
 */
public interface AssetService {

    /**
     * try to create new asset
     * @return true if asset was created
     */
    boolean create(Asset asset);

    /**
     * try to change existing asset
     * @return true if asset was changed
     */
    boolean change(Asset asset);

    /**
     * Return asset by {@link Asset#id}
     */
    Asset get(String id);
}
