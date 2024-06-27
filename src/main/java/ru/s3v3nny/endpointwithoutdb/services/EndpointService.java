package ru.s3v3nny.endpointwithoutdb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.s3v3nny.endpointwithoutdb.dto.Error;
import ru.s3v3nny.endpointwithoutdb.dto.Message;
import ru.s3v3nny.endpointwithoutdb.dto.Response;

@Service
@RequiredArgsConstructor
public class EndpointService {

    public Response<Message, Error> checkServiceStatus() {
        Message message = new Message("Endpoint is active");
        return new Response<>(message, null);
    }
}
