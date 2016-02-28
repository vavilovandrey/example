package base.data;

import base.data.dict.AssetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Simple json object or img org something else...
 */
@Entity
public class Asset implements Identifiable<String> {

    /**
     * UUID
     */
    @Id
    @NotEmpty
    private String id;

    /**
     * When asset was created
     */
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_date", updatable = false)
    private Date uploadDate;

    /**
     * When asset was changed
     */
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * Color mark of the asset
     */
    @Enumerated(EnumType.STRING)
    @Column
    @NotEmpty
    private AssetType type;

    /**
     * String representation of the stored object
     */
    @Column
    @NotEmpty
    private String content;

    @Transient
    @JsonIgnore
    private boolean isNew;

    /**
     * UUID
     */
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * When asset was created
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * When asset was changed
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Color mark of the asset
     */
    public AssetType getType() {
        return type;
    }

    public void setType(AssetType type) {
        this.type = type;
    }

    /**
     * String representation of the stored object
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
