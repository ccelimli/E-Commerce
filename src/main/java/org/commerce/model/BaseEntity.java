package org.commerce.model;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public class BaseEntity {
    @Nullable
    private LocalDateTime createdDate=null;
    @Nullable
    private LocalDateTime updatedDate=null;
}
