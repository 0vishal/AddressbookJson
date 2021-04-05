package Json;

import java.sql.Date;

public class AddressbookJson {

        public int Id;
        public String FirstName;
        public String LastName;
        public String Address;
        public String city;
        public String State;
        public String Email;
        public int Phonenumber;
        public String Name;
        public String Type;


    public AddressbookJson(int id, String firstName, String lastName, String address, String city, String state, String email, int phonenumber, String name, String type) {
        this.Id = id;
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        this.city = city;
        State = state;
        Email = email;
        Phonenumber = phonenumber;
        Name = name;
        Type = type;
    }


    public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public int getPhonenumber() {
            return Phonenumber;
        }

        public void setPhonenumber(int phonenumber) {
            Phonenumber = phonenumber;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }


        @Override
        public String toString() {
            return "AddressBookData{" +
                    "id"+ Id + '\'' +
                    "FirstName='" + FirstName + '\'' +
                    ", LastName='" + LastName + '\'' +
                    ", Address='" + Address + '\'' +
                    ", City='" + city + '\'' +
                    ", State='" + State + '\'' +
                    ", Email='" + Email + '\'' +
                    ", Phoneno=" + Phonenumber +
                    ", Name='" + Name + '\'' +
                    ", Type='" + Type + '\'' +
                    '}';
        }
    }
