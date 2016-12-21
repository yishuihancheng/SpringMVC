package edu.scu.cs.tlzhang.mybatis.entity;

import edu.scu.cs.tlzhang.helper.DateUtils;
import edu.scu.cs.tlzhang.helper.UUIDUtils;

/**
 * Created by tlzhang on 2016/12/16.
 */
public class Basic extends Vo{
    protected Long createAt = DateUtils.nowDateTime();
    protected Long updateAt = DateUtils.nowDateTime();
    protected Status status = Status.active;
    protected String uuid = UUIDUtils.uuid();

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
