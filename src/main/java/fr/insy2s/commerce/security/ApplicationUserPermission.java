package fr.insy2s.commerce.security;

public enum ApplicationUserPermission {
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission){
        this.permission = permission;
    }
    public String getPermission(){
        return permission;
    }

}
