package fr.insy2s.commerce.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static fr.insy2s.commerce.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    client(Sets.newHashSet()),
    admin(Sets.newHashSet(COURSE_READ,COURSE_WRITE,CLIENT_READ,CLIENT_WRITE)),
    commercial(Sets.newHashSet(COURSE_READ,CLIENT_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<ApplicationUserPermission>getPermissions(){
        return permissions;
    }
}
