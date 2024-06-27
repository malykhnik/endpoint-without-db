package ru.s3v3nny.endpointwithoutdb.utils;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.s3v3nny.endpointwithoutdb.dto.Response;
import ru.s3v3nny.endpointwithoutdb.dto.ServiceInfo;
import ru.s3v3nny.endpointwithoutdb.dto.ServicesDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExecuteUtil {

    @SneakyThrows
    public ServicesDto executeIsActiveCommand(List<String> serviceNames) {
        List<ServiceInfo> services = new ArrayList<>();
        Runtime runtime = Runtime.getRuntime();
        Process process;

        for (String s : serviceNames) {
            process = runtime.exec(new String[]{"systemctl", "is-active", s});
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String out = "";
            if ((out = reader.readLine()) != null) {
                ServiceInfo serviceInfo = new ServiceInfo(s, out);
                services.add(serviceInfo);
            }
            reader.close();
        }

        if (services.isEmpty()) {
            return null;
        }
        return new ServicesDto(services);
    }
}
