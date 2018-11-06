package com.space.account;
import  java.io.Closeable;
public interface AclService<P> extends Closeable {
    boolean hasAccess(P principle,
                      Resource resource,
                      Operation Operation);
    void allowAccess(
            P principle,
            Resource resource,
            Operation operation
    );
    void revokeAccess(
            P principle,
            Resource resource,
            Operation operation
    );

    enum Operation {
        CREATE,
        READ,
        UPDATE,
        DELETE,
    }
    interface Resource {
        String getResourceType();
        String getResourceId();
    }
}
