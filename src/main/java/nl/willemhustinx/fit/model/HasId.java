package nl.willemhustinx.fit.model;

import java.io.Serializable;

public interface HasId<T> extends Serializable {

    T getId();

    void setId(T id);
}