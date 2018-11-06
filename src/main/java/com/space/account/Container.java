package com.space.account;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <p>
 *     A representation of a container.A container virtually groups a
 *     number of blobs under the same {@link Account}, so that an operation on
 *     container can be applied to all the bolbs of the container.
 *
 *     When posting a blob, a container needs to be specified.
 *
 *     There can be multiple containers under the same {@link Account }, but containers
 *     cannot be nested.
 *
 * </p>
 *
 *
 *
 */
public class Container {
    //constants
    static final String JSON_VERSION_KEY = "version";
    static final String CONTAINER_NAME_KEY="containerName";
    static final String CONTAINER_ID_KEY="containerId";
    static final String STATUS_KEY="status";
    static final String DESCRIPTION_KEY="description";
    static final String IS_PRIVATE_KEY= "isPrivate";
    static final String ENCRYPTED_KEY ="encrypted";
    static final String PREVIOUSLY_ENCRYPTED_KEY="prviouslyEncrypted";
    static final String CACHEABLE_KEY="cacheable";
    static final  String MEDIA_SCAN_DISABLED_KEY ="mediaScanDisabled";
    static final String REPLICATION_POLICY_KEY ="replicationPolicy";
    static final String TTL_REQUIRED_KEY="ttlRequired";
    static final String PARENT_ACCOUNT_ID_KEY="parentAccountId";
    static final boolean ENCRYPTED_DEFAULT_VALUE=false;
    static final boolean MEDIA_SCAN_DISABLED_DEFAULT_VALUE=true;
    static final boolean CACHEABLE_DEFAULT_VALUE=true;
    public static final short JSON_VERSION_1=1;
    public static final short JSON_VERSION_2=2;
    /**
     * The current version to serialize in.
     */
    private static short currentJsonVersion = JSON_VERSION_2;
    public  static final short UNKNOWN_CONTAINER_ID = -1;
    /*
    The id for the containers to be associated with the blobs
    that are put without specifying a target container,
    but are specified public.
     */
    public static final short DEFAULT_PUBLIC_CONTAINER_ID = 0;
    public static final short DEFAULT_PRIVATE_CONTAINER_ID = 1;
    public static final String UNKNOWN_CONTAINER_NAME="ambry-unknown-container";
    public static final  String DEFAULT_PUBLIC_CONTAINER_NAME="default-public-container";
    public static final  String DEFAULT_PRIVATE_CONTAINER_NAME="default-private-container";
    public static final ContainerStatus UNKNOWN_CONTAINER_STATUS = ContainerStatus.ACTIVE;
    public static  final ContainerStatus DEFAULT_PUBLIC_CONTAINER_STATUS= ContainerStatus.ACTIVE;
    public static final  ContainerStatus DEFAULT_PRIVATE_CONTAINER_STATUS
            =ContainerStatus.ACTIVE;
    public static final String UNKNOWN_CONTAINER_DESCRIPTION= "This is a container for the  blobs without specifying a target account and account when they are put";
    public static final String DEFAULT_PUBLIC_CONTAINER_DESCRIPTION=
            "This is a container for the blobs without specifying a target account and " +
                    "container when they are put and isPrivate flag is false";
    public static final String DEFAULT_PRIVATE_CONTAINER_DESCRIPTION="isPrivate is true";
    public static final  boolean UNKNOWN_CONTAINER_ENCRYPTED_SETTING= ENCRYPTED_DEFAULT_VALUE;
    public static final boolean DEFAULT_PUBLIC_CONTAINER_ENCRYPTED_SETTING= ENCRYPTED_DEFAULT_VALUE;
    public static final  boolean DEFAULT_PRIVATE_CONTAINER_ENCRYPTED_SETTING
            =ENCRYPTED_DEFAULT_VALUE;


    //contanier field variables
    private final short parentAccountId;

    private Container(JSONObject metadata, short parentAccoutId) {
        if( metadata == null ){
            throw new IllegalArgumentException("metadata cannot be null");
        }
        this.parentAccountId = parentAccoutId;

    }


    static  Container fromJson(JSONObject json, short parentAccoutId ) throws JSONException{
        return  new Container(json, parentAccoutId);
    }





    public enum ContainerStatus {
        ACTIVE, INACTIVE
    }















}
