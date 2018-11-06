package com.space.account;
/*
Version 1:
{
    "accountId": 101,
    "accountName": "MyAccount",
    "containers": [
        {
         "ContainerName": "MyContainer"
         "description": "This is my personal Container",
         "isPrivate": "true",
         "containerId":0,
         "version":1
         "status":"ACTIVE"
         "parentAccountId":"101"
        }
    ]

 */

import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Account {
    static final String JSON_VERSION_KEY="version";
    static final String ACCOUNT_ID_KEY= "accountId";
    static final String ACCOUNT_NAME_KEY="accoutName";
    static final String STATUS_KEY="status";
    static final String SNAPSHOT_VERSION_KEY="snapshotVersion";
    static final String CONTAINERS_KEY="containers";
    static final short JSON_VERSION_1=1;
    static final short CURRENT_JSON_VERSION=JSON_VERSION_1;
    static final  int SNAPSHOT_VERSION_DEFAULT_VALUE=0;
    public static final short UNKNOWN_ACCOUNT_ID=-1;
    public static final String UNKNOWN_ACCOUNT_NAME="ambry-unknown-account";


    // account member variable
    private final short id;
    private final String name;
    private AccountStatus status;
    private final int snapshotVersion;

    // internal datastructure
    private final Map<Short, Container> containerIdToContainerMap = new HashMap<>();
    private final Map<String,Container> containerNameToContainerMap = new HashMap<>();
    /**
     Constructing a { @link Account } object from account metadata
     @param metadata the metadata of the account in JSON
     @throw JSONException if fails to parse metadata
     */
    private  Account( JSONObject metadata) throws JSONException {
        if( metadata == null){
            throw new IllegalArgumentException("metadata cannot be null");
        }
        short metadataVersion = (short)metadata.getInt(JSON_VERSION_KEY);
        switch (metadataVersion){
            case  JSON_VERSION_1:
                id = ( short) metadata.getInt( ACCOUNT_ID_KEY);
                name = metadata.getString(ACCOUNT_NAME_KEY);
                status = AccountStatus.valueOf(metadata.getString(STATUS_KEY));
                snapshotVersion = metadata.optInt(SNAPSHOT_VERSION_KEY,SNAPSHOT_VERSION_DEFAULT_VALUE);
                checkRequiredFieldsForBuild();
                JSONArray containerArray = metadata.optJSONArray(CONTAINERS_KEY);
                if (containerArray != null){
                    for(int index = 0 ; index < containerArray.length();index++){
                        Container container = Container.fromJson(containerArray.getJSONObject(index),id);
                        checkParentAccountIdInContainers(container);
                    }

                }
        }
    }
    private void checkRequiredFieldsForBuild(){
        if( name == null || status == null) {
            throw  new IllegalStateException("Either of required fields name="+ name+ "or status"+ status+ " is null");
        }
    }
    private void checkParentAccountIdInContainers(Container container){

    }
    public enum AccountStatus {
        ACTIVE, INACTIVE;
    }











































}
