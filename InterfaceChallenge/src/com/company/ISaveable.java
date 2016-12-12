package com.company;

import java.util.List;

/**
 * Created by Trebek on 12/8/16.
 */
public interface ISaveable {

    List<String> write();
    void read(List<String> saveValues);


}
