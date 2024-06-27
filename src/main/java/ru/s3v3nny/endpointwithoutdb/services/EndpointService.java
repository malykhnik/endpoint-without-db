package ru.s3v3nny.endpointwithoutdb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.s3v3nny.endpointwithoutdb.dto.Response;
import ru.s3v3nny.endpointwithoutdb.utils.ExecuteUtil;

@Service
@RequiredArgsConstructor
public class EndpointService {

    private final ExecuteUtil util;

    public Response checkServicesStatus() {
        String[] services = {"postgresql", "iptables", "docker"};
        for (String service : services) {
            System.out.println(util.executeIsWorkingCommand(service));
        }
        return null;
    }
}
