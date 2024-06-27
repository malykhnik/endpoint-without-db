package ru.s3v3nny.endpointwithoutdb.dto;

import java.util.List;

public record Response (List<ServiceInfo> services) {}
