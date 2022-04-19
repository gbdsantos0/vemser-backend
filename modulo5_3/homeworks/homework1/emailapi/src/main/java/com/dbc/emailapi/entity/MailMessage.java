package com.dbc.emailapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document("mail_message")
public class MailMessage {
    @Id
    private String id;
    private String title;
    private String name;
    private String message;
    private String supportMail;
    private String email;
}
