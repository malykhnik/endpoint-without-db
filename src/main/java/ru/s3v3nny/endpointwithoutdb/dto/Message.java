package ru.s3v3nny.endpointwithoutdb.dto;

import java.util.List;

public record Message (List<ServiceDto> services) { }
