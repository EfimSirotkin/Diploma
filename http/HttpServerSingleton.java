package sample.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public final class HttpServerSingleton {

    private static HttpServerSingleton serverInstance;
    private static HttpServer server;

    private HttpServerSingleton() {

    }

    public static HttpServerSingleton getInstance() {
        if(serverInstance == null)
            serverInstance = new HttpServerSingleton();
        return serverInstance;
    }



    public static HttpServer getInstance(String hostname, int port, int backlog, int threadPool) throws IOException {
        if(serverInstance == null) {
            server = HttpServer.create(new InetSocketAddress(hostname,port), backlog);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadPool);
            server.createContext("/", new CustomHttpHandler());
            server.setExecutor(threadPoolExecutor);
            server.start();
            System.out.println("Server " + hostname + " started on port: " + port);
        }
        return server;
    }
}
