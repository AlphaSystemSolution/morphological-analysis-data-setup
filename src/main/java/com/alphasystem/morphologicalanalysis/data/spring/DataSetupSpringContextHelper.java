package com.alphasystem.morphologicalanalysis.data.spring;

import com.alphasystem.morphologicalanalysis.spring.support.DefaultSpringContextHelper;

/**
 * @author sali
 */
public class DataSetupSpringContextHelper extends DefaultSpringContextHelper {

    public DataSetupSpringContextHelper(){
        super(DataSetupSpringConfiguration.class);
    }
}
