package tn.esprit.user.entities;

import lombok.Data;
@Data
public class UserContact {
    private String phoneNumber;
    private UserAddress address = new UserAddress();
    private String website;
    private String linkedin;
    private String facebook;
    private String github;

    public UserAddress getUserAddress() {
        return address;
    }
}
