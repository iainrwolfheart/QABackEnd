package com.nationwide.contact;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contactforms")
public class Contact {

    @Id
    private String id;
    private String name;
    private String email;
    private String subject;
    private String yourMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getYourMessage() {
        return yourMessage;
    }

    public void setYourMessage(String yourMessage) {
        this.yourMessage = yourMessage;
    }

    public Contact(String id, String name, String email, String subject, String yourMessage) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.yourMessage = yourMessage;
    }
}