package com.bsuir.aipos.server;

import com.bsuir.aipos.servive.SportsnamServiceHandler;
import com.bsuir.aipos.thrift.SportsmanService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.ResourceBundle;

public class Server {

    private TServer server;
    private SportsmanService.Processor<SportsmanService.Iface> processor;
    private SportsnamServiceHandler sportsnamServiceHandler;


    public Server() {
        sportsnamServiceHandler = new SportsnamServiceHandler();
        processor = new SportsmanService.Processor<SportsmanService.Iface>(sportsnamServiceHandler);
    }

    public void start() {
        new Thread(() -> serve()).start();
    }


    private void serve() {
        try {

            TServerTransport serverTransport = new TServerSocket(9900);
            server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            server.serve();
        } catch (TTransportException e) {

        }
    }
}
