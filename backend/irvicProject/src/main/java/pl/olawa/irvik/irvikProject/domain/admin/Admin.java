package pl.olawa.irvik.irvikProject.domain.admin;

public class Admin {
    private int id =1;
    private String name;
    private String email;
    private String password;
    private AdminRole adminRole;

    public Admin(String name, String email, String password, AdminRole adminRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.adminRole = adminRole;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }
}
