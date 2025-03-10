package com.ms.email.dto;

import java.util.UUID;

public record EmailDTO(UUID userId,
                       String emailTo,
                       String subject,
                       String text) {
}
