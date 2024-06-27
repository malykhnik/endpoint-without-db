package ru.s3v3nny.endpointwithoutdb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.s3v3nny.endpointwithoutdb.dto.Error;
import ru.s3v3nny.endpointwithoutdb.dto.Message;
import ru.s3v3nny.endpointwithoutdb.dto.Response;
import ru.s3v3nny.endpointwithoutdb.dto.ServiceDto;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EndpointService {

    public Response<Message, Error> checkServiceStatus() {
        Message message = new Message(new ArrayList<>());
        ServiceDto serviceDto = new ServiceDto("endpoint", "active");
        message.services().add(serviceDto);
        return new Response<>(message, null);
    }
}
