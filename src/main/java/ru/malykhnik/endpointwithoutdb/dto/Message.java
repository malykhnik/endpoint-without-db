package ru.malykhnik.endpointwithoutdb.dto;

import java.util.List;

public record Message (String token, List<ServiceDto> services) { }
