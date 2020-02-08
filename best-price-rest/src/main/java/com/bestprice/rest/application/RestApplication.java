package com.bestprice.rest.application;

import com.bestprice.rest.resources.GetBestPriceForItemResource;

import javax.ws.rs.core.Application;
import java.util.Set;

import com.bestprice.rest.resources.InsertItemByStoreInformationResource;
import com.google.common.collect.Sets;

public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Sets.newHashSet(GetBestPriceForItemResource.class, InsertItemByStoreInformationResource.class);
    }
}
