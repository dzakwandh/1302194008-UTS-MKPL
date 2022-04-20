package lib;

public class Person {
    public enum Gender {
        LakiLaki,
        Perempuan
    }

    private String firstName;
    private String lastName;

    private String address;
    private boolean isForeigner;
    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsForeigner() {
        return isForeigner;
    }

    public void setIsForeigner(Boolean isForeigner) {
        this.isForeigner = isForeigner;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
