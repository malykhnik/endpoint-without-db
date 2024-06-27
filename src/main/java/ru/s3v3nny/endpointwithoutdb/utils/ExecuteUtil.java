package ru.s3v3nny.endpointwithoutdb.utils;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class ExecuteUtil {

    @SneakyThrows
    public String executeIsWorkingCommand(String serviceName) {
        String command = "systemctl is-working ".concat(serviceName);
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String out = "";

        if ((out = reader.readLine()) != null) {
            return out;
        }
        reader.close();
        return null;
    }
}
