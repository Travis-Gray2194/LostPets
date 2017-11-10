package me.travisgray;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ${TravisGray} on 11/9/2017.
 */
//
//The details are as follows:
//
//        - Pet Name (required)
//
//        - Age (must be a number)
//
//        - Type of animal (dog, cat, hamster, etc.). required
//
//        - Breed (if applicable)
//
//        - Colour (required)
//
//        - Distinguishing features (optional )
//
//        - Contact Number of owner

@Entity
public class PetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    //    @NotNull won’t allow a null value, which is what Spring MVC generates if the entry is empty
    @NotNull
//    @Size(min=2, max=30) will only allow names between 2 and 20 characters long
    @Size(min=2, max=30)
    private String name;


    @NotEmpty
    private int age;

    @NotEmpty
    private String Type;

    @NotEmpty
    private String Breed;

    @NotEmpty
    private String Colour;

    @NotEmpty
    private String DistinguishingFeatures;

    @Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
    @NotEmpty(message="Phone field is mandatory.") @NumberFormat(style= NumberFormat.Style.NUMBER)
    private String ownerphonenumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getDistinguishingFeatures() {
        return DistinguishingFeatures;
    }

    public void setDistinguishingFeatures(String distinguishingFeatures) {
        DistinguishingFeatures = distinguishingFeatures;
    }

    public String getOwnerphonenumber() {
        return ownerphonenumber;
    }

    public void setOwnerphonenumber(String ownerphonenumber) {
        this.ownerphonenumber = ownerphonenumber;
    }
}
