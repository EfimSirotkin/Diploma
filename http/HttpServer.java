package sample.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

class HttpServerSingleton {

    private static HttpServer serverInstance;

    private HttpServerSingleton() {
    }

    public static HttpServer getInstance() {
        return serverInstance;
    }

    public static HttpServer getInstance(String hostname, int port, int backlog, int threadPool) throws IOException {
        if(serverInstance == null) {
            serverInstance = HttpServer.create(new InetSocketAddress(hostname,port), backlog);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadPool);
            serverInstance.createContext("/", new CustomHttpHandler());
            serverInstance.setExecutor(threadPoolExecutor);
            serverInstance.start();
            System.out.println("Server " + hostname + "started on port: " + port);
        }
        return serverInstance;
    }
}
