package base.service.impl;

import base.dao.AssetDao;
import base.data.Asset;
import base.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetDao dao;

    @Transactional
    public boolean create(Asset asset){
        if(dao.isExist(asset.getId())){
           return false;
        }
        asset.setNew(true);
        asset.setUploadDate(new Date());
        asset.setUpdateDate(asset.getUploadDate());
        dao.saveOrUpdate(asset);
        return true;
    }

    @Transactional
    public boolean change(Asset asset){
        if(!dao.isExist(asset.getId())){
            return false;
        }
        asset.setNew(false);
        asset.setUpdateDate(new Date());
        dao.saveOrUpdate(asset);
        return true;
    }

    @Transactional
    public Asset get(String id){
        return dao.get(id);
    }
}
