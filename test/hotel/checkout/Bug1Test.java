/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.checkout;

import hotel.HotelHelper;
import hotel.entities.Booking;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import hotel.entities.Hotel;
import hotel.entities.ServiceCharge;
import java.util.List;
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
    
    int roomId = 301;
    
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
        control.roomIdEntered(roomId);
        assertEquals(7.00, control.total, 0.1);
    }
    
    @Test
    public void testRoomIdEnteredPreconditions(){
        Booking booking = hotel.findActiveBookingByRoomId(roomId);
        List<ServiceCharge> charges = booking.getCharges();
        double actual = charges.get(0).getCost();
        assertEquals(7.00, actual, 0.1);
    }
}
