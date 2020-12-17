package lesson1;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final Person person;

        public Builder() {
            this.person = new Person();
        }

        public Person build() {
            return person;
        }

        public Builder firstName(String firstName) {
            person.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            person.setLastName(lastName);
            return this;
        }

        public Builder middleName(String middleName) {
            person.setMiddleName(middleName);
            return this;
        }

        public Builder country(String country) {
            person.setCountry(country);
            return this;
        }

        public Builder address(String address) {
            person.setAddress(address);
            return this;
        }

        public Builder phone(String phone) {
            person.setPhone(phone);
            return this;
        }

        public Builder age(int age) {
            person.setAge(age);
            return this;
        }

        public Builder gender(String gender) {
            person.setGender(gender);
            return this;
        }
    }
}
