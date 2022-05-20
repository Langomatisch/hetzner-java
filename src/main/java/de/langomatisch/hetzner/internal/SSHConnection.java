package de.langomatisch.hetzner.internal;

import com.jcraft.jsch.*;
import de.langomatisch.hetzner.type.SSHKey;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class SSHConnection {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private final String ip;
    private final int port;
    private final SSHKey sshKey;
    private final String user;

    private Session session;

    @SneakyThrows
    public void connect() {
        session = getSession();
    }

    public void sendCommand(String command, Consumer<String> output) throws JSchException {
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);
        channel.connect();
        executorService.submit(() -> {
            try {
                InputStream inputStream = channel.getInputStream();
                while (!channel.isClosed()) {
                    byte[] bytes = inputStream.readAllBytes();
                    if (bytes.length == 0) continue;
                    output.accept(new String(bytes, StandardCharsets.UTF_8));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Session getSession() {
        try {
            JSch jsch = new JSch();

            jsch.addIdentity(sshKey.getKey(), sshKey.getPassphrase());
            Session session = jsch.getSession(user, ip, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setTimeout(15000);
            session.connect();
            return session;
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return null;
    }

}
