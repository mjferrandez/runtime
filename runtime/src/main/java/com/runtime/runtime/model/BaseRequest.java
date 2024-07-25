package com.runtime.runtime.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
