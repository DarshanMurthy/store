package com.space.commons;


import com.github.space.config.HelixPropertyStoreConfig;
import org.apache.helix.ZNRecord;

import java.util.List;

public class CommonUtils {
    /**
     * Create an instance of {@link  HelixPropertyStore} based on given
     * {@link HelixPropertyStoreConfig}.
     * @param zkservers the Zookeeper server address
     * @param propertyStoreConfig the config for {@link HelixPropertyStore}
     * @param subscribedPaths a list of paths to which the PropertyStore subscribes
     * @return the instance of {@link HelixPropertyStore}
     */

    public static  HelixPropertyStore<ZNRecord>createHelixPropertyStore(
            String zkServers,
            HelixPropertyStoreConfig propertyStoreConfig,
            List<String> subscribedPaths
    ){
        if( zkServers == null || zkServers.isEmpty() || propertyStoreConfig == null){
            throw  new IllegalArgumentException(" Invalid arguments, cannot create HelixPropertyStore");
        }
        ZkClient zkClient = new ZkClient()




    }




































}
