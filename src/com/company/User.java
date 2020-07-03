package pack1;

public class User implements  Comparable<User>{

    private String login;
    private String password;
    private boolean access;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public User(String login, String password, boolean access) {
        this.login = login;
        this.password = password;
        this.access = access;
    }

    @Override
    public int compareTo(User o) {
        if (login.equals(o.getLogin()) && access == o.isAccess()) {
            return 0;
        } else if (login.compareTo(o.getLogin()) < 0) {
            return -1;
        }
        else return 1;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", access=" + access +
                '}';
    }
}
