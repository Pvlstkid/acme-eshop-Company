package com.codehub.acme.eshop.domain;

import com.codehub.acme.eshop.enumerator.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * This domain class represents a user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
   /**
    * the user id
    */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "USER_ID",nullable = false)
   private Long id;
   /**
    * the username
    */
   private String username;
   /**
    * the password
    */
   private String password;
   /**
    * the name
    */
   private String name;
   /**
    * the surname
    */
   private String surname;
   /**
    * the email
    */
   private String email;
   /**
    * the phone number
    */
   private String phoneNumber;
   /**
    * the address
    */
   private String address;
   /**
    * the postal code
    */
   private String postCode;
   /**
    * the Shopping Basket
    */
   @Cascade(org.hibernate.annotations.CascadeType.ALL)
   @OneToOne
   private ShoppingBasket shoppingBasket;
   /**
    * The role
    * {@link Role}
    */
   @Enumerated(EnumType.STRING)
   private Role role;

   /**
    * The token for the user authentication
    */
   private String generateRandomHexToken;
   public static String generateRandomHexToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); //hex encoding

    }
}

