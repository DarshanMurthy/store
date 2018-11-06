package com.space.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountBuilder {
    private short id;
    private String name;
    private Account.AccountStatus status;
    private int snapshotVersion = Account.SNAPSHOT_VERSION_DEFAULT_VALUE;
    private Map<Short,Container> idToContainerMetadataMap = new HashMap<>();
    public AccountBuilder(Account origin){
        if(origin == null){
            throw new IllegalArgumentException("" +
                    "origin cannot be null");
        }
        id = origin.getId();
        name = origin.getName();
        status = origin.getStatus();
        snapshotVersion = origin.getSnapshotVersion();
        for(Container container: origin.getAllContainers()) {
            idToContainerMetadataMap.put(container.getId(), container);
        }
    }

    public  AccountBuilder(short id, String name, Account.AccountStatus status){
        this.id= id;
        this.name = name;
        this.status = status;
    }

    public AccountBuilder id(short id){
        this.id= id;
        return  this;
    }
    public  AccountBuilder name(String name){
        this.name = name;
        return  this;
    }
    public AccountBuilder status(Account.AccountStatus  status){
        this.status = status;
        return  this;
    }

    public  AccountBuilder snapshotVersion( int snapshotVersion){
        this.snapshotVersion = snapshotVersion;
        return this;
    }
    /**
     * Clear the set of containers
     * for teh {@link Account} to build and
     * provided ones
     */
    public AccountBuilder containers(Collection<Container> containers){
        idToContainerMetadataMap.clear();
        if(containers!=null){
            for(Container container: containers){
                idToContainerMetadataMap.put(container.getId(),container);
            }
        }
        return this;
    }

    public AccountBuilder addOrUpdateContainer(Container container){
        if(container != null){
            idToContainerMetadataMap.put(
                    container.getId(), container
            );

        }
        return this;
    }
    public AccountBuilder removeContainer(Container container){
        if(container != null){
            short id = container.getId();
            Container containerToRemove = idToContainerMetadataMap.get(id);
            if(container.equals(containerToRemove)){
                idToContainerMetadataMap.remove(id);

            }
        }
        return this;
    }

    public Account build( ){
        return new Account(id,name,status,snapshotVersion, idToContainerMetadataMap.values());
    }

}
