public class Person {
    private String name;
    private String address;
    private String password;

    public Person(String name, String address, String password) {
        this.name = name;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

}
