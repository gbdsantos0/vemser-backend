package com.dbc.pessoaapi.dto.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MailMessageDTO {
    private String title;
    private String name;
    private String message;
    private String supportMail;
    private String email;
}