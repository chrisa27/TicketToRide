package com.example.Test.ServerProxyTest;

import com.example.Communicators.ProxyServer;
import com.example.Communicators.ResultHolders.ClearResult;
import com.example.Database.DataAccess.AuthDAO;
import com.example.Database.DataAccess.EventDAO;
import com.example.Database.DataAccess.PersonDAO;
import com.example.Database.DataAccess.UserDAO;
import com.example.Server;
import com.example.ServerModel.AuthToken;
import com.example.ServerModel.Event;
import com.example.ServerModel.Location;
import com.example.ServerModel.Person;
import com.example.ServerModel.UserAccount;
import com.example.Services.ClearService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by video on 3/8/2017.
 */

public class ClearProxyTest {
    private static Server server;

    @BeforeClass
    public static void initialize(){
        server = new Server();
        server.clearInitialize();
        server.main(null);
        Location location = new Location(55.55, 66.66, "City", "USA");

        AuthDAO.SINGLETON.addAuthToken(new AuthToken("Johnny"));
        EventDAO.SINGLETON.addEvent(new Event("555", "666", location, "Move", 2030));
        PersonDAO.SINGLETON.addPerson(new Person("Chris", "Arnold", "m"));
        UserDAO.SINGLETON.addUser(new UserAccount("Chrisa", "pass", "Chris", "Arnold", "Chrisa@gmail.com", "f"));
    }

    @Test
    public void clearTest(){
        ClearResult clearResult;
        clearResult = ProxyServer.SINGLETON.clear();

        assertTrue(!clearResult.isError());
        assertEquals(clearResult.getMessage(), "Clear succeeded.");
    }

    @AfterClass
    public static void cleanup(){
        server.close();
        server.closeServer();
    }
}
