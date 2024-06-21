package com.dongduk.HealthPlanet.domain;

import java.io.Serializable;

public class WishId implements Serializable {
    
    private int id;
    private int postid;

    // 생성자, equals/hashCode 메서드, getter/setter 등
    
    // 반드시 equals와 hashCode 메서드를 재정의해야 합니다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WishId wishId = (WishId) o;

        if (id != wishId.id) return false;
        return postid == wishId.postid;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + postid;
        return result;
    }
}
