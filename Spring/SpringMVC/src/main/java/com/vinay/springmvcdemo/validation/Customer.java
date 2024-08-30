package com.vinay.springmvcdemo.validation;


import javax.validation.constraints.*;

public class Customer {
    @NotNull(message = "First Name Is Required!!")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name should only contain letter!!")
    @Size(min = 2, max = 20, message = "First Name should be in range of 2 to 20 letters!!")
    private String firstName;
    private String lastName;

    @NotNull(message = "Age Is Required!!")
    @Min(value = 18, message = "Age must be above 18!!")
    @Max(value = 30, message = "Only applicable for 30 years or less!!")
    private Integer age;

    @NotNull(message = "Email Is Required!!")
    @Email(message = "Email should be valid (Ex. vinaylahari715@gmail.com)!!")
    private String email;

    @NotNull(message = "Phone Number Is Required!!")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must contain 10 digits and should start with 6,7,8 or 9 (Ex. 9999999999)")
    private String phoneNumber;

    @CouponCode
    private String couponCode;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
