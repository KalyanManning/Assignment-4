/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.service;

import hotel.HotelHelper;
import hotel.entities.Hotel;
import hotel.entities.Booking;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Kalyan
 */
public class Bug2Test {
    
    @Mock RecordServiceUI recordServiceUI;
    Hotel hotel;
    int roomId = 301;
    
    @InjectMocks RecordServiceCTL control = new RecordServiceCTL(hotel);
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        hotel = HotelHelper.loadHotel();
        control.hotel = hotel;
        hotel.checkout(roomId);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRoomNumberEntered() {
        control.roomNumberEntered(roomId);
        assertNull(control.booking);
        String mesg = String.format("No active booking for room id: %d", roomId);
        verify(recordServiceUI).displayMessage(mesg);
    }
    
    @Test
    public void testFindActiveBookingByRoomId(){
        Booking booking = hotel.findActiveBookingByRoomId(roomId);
        assertNull(booking);
    }
    
    @Test
    public void testActiveBookingsByRoomId(){
        Booking booking = hotel.activeBookingsByRoomId.get(roomId);
        assertNull(booking);
    }
}
