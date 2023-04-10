package com.example.mediamarkbe.dto;

import com.example.mediamarkbe.common.enumeration.Provinces;
import com.example.mediamarkbe.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPayload {
    @Size(max=200)
    private String name;

    private Long birthday;

    private String citizenIdentification;

    private String phoneNumber;

    private Double salary;

    @Enumerated(EnumType.STRING)
    private Provinces province;


    @Column(columnDefinition = "boolean default false")
    private boolean gender;

    private String email;

    @NotBlank
    @Size(max=100)
    private String username;

    @NotBlank
    @Size(max=100)
    private String password;

    private List<Long> roleId ;

    public static User convertToModel(UserPayload payload){
        User user = new User();

        user.setName(payload.getName());
        if(payload.birthday!=null) user.setBirthday(new Date(payload.birthday));
        user.setCitizenIdentification(payload.getCitizenIdentification());
        user.setPhoneNumber(payload.getPhoneNumber());
        user.setSalary(payload.getSalary());
        user.setProvince(payload.province);
        user.setGender(payload.isGender());
        user.setEmail(payload.getEmail());

        user.setUsername(payload.getUsername());

        return user;
    }
}
