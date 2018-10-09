/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.checkout;

import hotel.HotelHelper;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import hotel.entities.Hotel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Kalyan
 */
@RunWith(MockitoJUnitRunner.class)
public class Bug1Test {
    
    @Mock CheckoutUI checkoutUI;
    
    Hotel hotel = new Hotel();
    
    @InjectMocks CheckoutCTL control = new CheckoutCTL(hotel);
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        hotel = HotelHelper.loadHotel();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRoomIdEntered() {
        
        control.run();
        control.roomIdEntered(301);
        assertEquals(7.00, control.total, 0.1);
    }
    
}
