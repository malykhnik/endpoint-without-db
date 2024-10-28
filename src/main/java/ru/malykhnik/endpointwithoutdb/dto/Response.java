package ru.malykhnik.endpointwithoutdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<Value, Error> {
    Value value;
    Error error;
}
