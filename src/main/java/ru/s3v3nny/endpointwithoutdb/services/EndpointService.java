package ru.s3v3nny.endpointwithoutdb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.s3v3nny.endpointwithoutdb.dto.Error;
import ru.s3v3nny.endpointwithoutdb.dto.Response;
import ru.s3v3nny.endpointwithoutdb.dto.ServicesDto;
import ru.s3v3nny.endpointwithoutdb.utils.ExecuteUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EndpointService {

    private final ExecuteUtil util;

    public Response<ServicesDto, Error> checkServicesStatus() {
        List<String> serviceNames  = Arrays.stream(new String[]{"postgresql", "iptables", "docker"}).toList();
        ServicesDto services = util.executeIsActiveCommand(serviceNames);
        if(services == null) {
            var err = new Error("No services to check");
            return new Response<>(null, err);
        }
        return new Response<>(services, null);
    }
}
