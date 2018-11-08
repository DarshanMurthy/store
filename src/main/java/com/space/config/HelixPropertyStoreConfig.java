package com.space.config;

public class HelixPropertyStoreConfig {
    public static final String HELIX_PROPERTY_STORE_PREFIX= "helix.property.store";

    @Config(HELIX_PROPERTY_STORE_PREFIX + "zk.client.connection.timeout.ms")
    @Default("20 * 1000")
    public final int zkClientConnectionTimeoutMs;



}
