package com.miscloud.entiy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

@Data
@Accessors(chain = true)//对象支持链式变成，默认是false
public class Dept implements Serializable {
    private Integer id;
    private String deptName;
    private String dataBaseName;//微服务一个服务可对应一个数据库，记录在那个数据库中

    public Dept(String deptName, String dataBaseName) {
        this.deptName = deptName;
        this.dataBaseName = dataBaseName;
    }

    public Dept() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dept dept = (Dept) o;
        return Objects.equals(id, dept.id) &&
                Objects.equals(deptName, dept.deptName) &&
                Objects.equals(dataBaseName, dept.dataBaseName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, deptName, dataBaseName);
    }
}
