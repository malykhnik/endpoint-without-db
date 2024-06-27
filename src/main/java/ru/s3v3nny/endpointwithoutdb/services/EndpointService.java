package ru.s3v3nny.endpointwithoutdb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.s3v3nny.endpointwithoutdb.dto.Response;
import ru.s3v3nny.endpointwithoutdb.utils.ExecuteUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EndpointService {

    private final ExecuteUtil util;

    public Response checkServicesStatus() {
        List<String> services  = Arrays.stream(new String[]{"postgresql", "iptables", "docker"}).toList();
        System.out.println(util.executeIsWorkingCommand(services));
        return null;
    }
}
