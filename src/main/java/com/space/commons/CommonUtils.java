package com.space.commons;
import com.space.config.HelixPropertyStoreConfig;
import org.apache.helix.ZNRecord;
import org.apache.helix.store.HelixPropertyStore;

import java.util.List;

public class CommonUtils {
    /*
    Generic record format to store
    data in node.
    This is used to store
    SimpleFields
    MapFields
    ListFields
     */

    public static HelixPropertyStore<ZNRecord> createHelixPropertyStore
            (String zkServers,
             HelixPropertyStoreConfig propertyStoreConfig,
              List<String>  subscribedPaths) {


    }

    }



}
