package ru.s3v3nny.endpointwithoutdb.utils;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class ExecuteUtil {

    @SneakyThrows
    public String executeIsWorkingCommand(String serviceName) {
        String command = String.format("systemctl is-working %s", serviceName);
        /* Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String out = "";
        if ((out = reader.readLine()) != null) {
            System.out.println(out);
            return out;
        }
        reader.close();
        return null; */
    ProcessBuilder builder = new ProcessBuilder();
    builder.command(command);
    Process process = builder.start();
    StringBuilder output = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
        output.append(line);
    }

    int exitCode = process.waitFor();
    if (exitCode != 0) {
        throw new Exception(String.format("Command '%s' failed with exit code %d", command, exitCode));
    }

    return output.toString();
    }
}
